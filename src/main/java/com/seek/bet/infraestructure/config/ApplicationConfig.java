package com.seek.bet.infraestructure.config;

import com.seek.bet.application.services.ClientService;
import com.seek.bet.application.services.TaskService;
import com.seek.bet.application.usecases.*;
import com.seek.bet.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.seek.bet.domain.ports.in.GetClientMetricsUseCase;
import com.seek.bet.domain.ports.in.ListClientsWithEventUseCase;
import com.seek.bet.domain.ports.out.ClientRepositoryPort;
import com.seek.bet.domain.ports.out.ExternalServicePort;
import com.seek.bet.domain.ports.out.TaskRepositoryPort;
import com.seek.bet.infraestructure.adapters.ExternalServiceAdapter;
import com.seek.bet.infraestructure.repositories.JpaClientRepositoryAdapter;
import com.seek.bet.infraestructure.repositories.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ApplicationConfig {

    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        return new TaskService(
                new CreateTaskUseCaseImpl(taskRepositoryPort),
                new RetrieveTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskUseCaseImpl(taskRepositoryPort),
                new DeleteTaskUseCaseImpl(taskRepositoryPort),
                getAdditionalTaskInfoUseCase
        );
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter) {
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort) {
        return new GetAdditionalTaskInfoUseCaseImpl(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort() {
        return new ExternalServiceAdapter();
    }


    // --- Client beans nuevos ---
    @Bean
    public ClientService clientService(ClientRepositoryPort clientRepositoryPort,
                                       GetClientMetricsUseCase getClientMetricsUseCase,
                                       ListClientsWithEventUseCase listClientsWithEventUseCase
                                       ) {
        return new ClientService(
                new CreateClientUseCaseImpl(clientRepositoryPort),
                getClientMetricsUseCase,
                listClientsWithEventUseCase
        );
    }
    /**CASO DE USO 1**/
    @Bean
    public ClientRepositoryPort clientRepositoryPort(JpaClientRepositoryAdapter jpaClientRepositoryAdapter) {
        return jpaClientRepositoryAdapter;
    }
    /**CASO DE USO 2**/
    @Bean
    public GetClientMetricsUseCase getClientMetricsUseCase(ClientRepositoryPort clientRepositoryPort) {
        return new GetClientMetricsUseCaseImpl(clientRepositoryPort);
    }
    /**CASO DE USO 3**/
    @Bean
    public ListClientsWithEventUseCase listClientsWithEventUseCase(ClientRepositoryPort clientRepositoryPort) {
        return new ListClientsWithEventUseCaseImpl(clientRepositoryPort);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/api/**",
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/swagger-ui.html"
                        ).permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
