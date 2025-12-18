package com.seek.bet.application.usecases;

import com.seek.bet.domain.model.Client;
import com.seek.bet.domain.model.ClientWithEvent;
import com.seek.bet.domain.ports.in.ListClientsWithEventUseCase;
import com.seek.bet.domain.ports.out.ClientRepositoryPort;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ListClientsWithEventUseCaseImpl implements ListClientsWithEventUseCase {

    private final ClientRepositoryPort clientRepositoryPort;

    public ListClientsWithEventUseCaseImpl(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public List<ClientWithEvent> listAllWithEvent() {
        List<Client> clients = clientRepositoryPort.findAll();

        // Ejemplo: calcular "esperanza de vida" como 80 años
        int lifeExpectancy = 80;

        return clients.stream().map(c -> {
            LocalDate estimatedEventDate = c.getBirthDate().plusYears(lifeExpectancy);
            return new ClientWithEvent(
                    c.getId(),
                    c.getFirstName(),
                    c.getLastName(),
                    c.getAge(),
                    c.getBirthDate(),
                    estimatedEventDate
            );
        }).collect(Collectors.toList());
    }
}