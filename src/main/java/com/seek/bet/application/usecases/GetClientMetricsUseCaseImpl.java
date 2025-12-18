package com.seek.bet.application.usecases;

import com.seek.bet.domain.model.Client;
import com.seek.bet.domain.model.ClientMetrics;
import com.seek.bet.domain.ports.in.GetClientMetricsUseCase;
import com.seek.bet.domain.ports.out.ClientRepositoryPort;
import com.seek.bet.infraestructure.entities.ClientEntity;

import java.util.List;

public class GetClientMetricsUseCaseImpl implements GetClientMetricsUseCase {

    private final ClientRepositoryPort clientRepositoryPort;

    public GetClientMetricsUseCaseImpl(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    public ClientMetrics getMetrics() {
        List<Client> clients = clientRepositoryPort.findAll();

        if (clients.isEmpty()) {
            return new ClientMetrics(0, 0);
        }

        // Calcular promedio
        double sum = clients.stream().mapToDouble(Client::getAge).sum();
        double average = sum / clients.size();

        // Calcular desviación estándar
        double variance = clients.stream()
                .mapToDouble(c -> Math.pow(c.getAge() - average, 2))
                .sum() / clients.size();
        double stdDev = Math.sqrt(variance);

        return new ClientMetrics(average, stdDev);
    }
}