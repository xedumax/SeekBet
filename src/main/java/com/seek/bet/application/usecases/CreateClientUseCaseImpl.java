package com.seek.bet.application.usecases;

import com.seek.bet.domain.model.Client;
import com.seek.bet.domain.ports.in.CreateClientUseCase;
import com.seek.bet.domain.ports.out.ClientRepositoryPort;

public class CreateClientUseCaseImpl implements CreateClientUseCase {

    private final ClientRepositoryPort clientRepositoryPort;

    public CreateClientUseCaseImpl(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public Client createClient(Client client) {
        return clientRepositoryPort.save(client);
    }
}
