package com.seek.bet.application.services;

import com.seek.bet.domain.model.Client;
import com.seek.bet.domain.model.ClientMetrics;
import com.seek.bet.domain.model.ClientWithEvent;
import com.seek.bet.domain.ports.in.*;

import java.util.List;

public class ClientService implements CreateClientUseCase,GetClientMetricsUseCase,ListClientsWithEventUseCase  {

    private final CreateClientUseCase createClientUseCase;
    private final GetClientMetricsUseCase  getClientMetricsUseCase;
    private final ListClientsWithEventUseCase listClientsWithEventUseCase;

    public ClientService(CreateClientUseCase createClientUseCase, GetClientMetricsUseCase getClientMetricsUseCase,
                         ListClientsWithEventUseCase listClientsWithEventUseCase) {
        this.createClientUseCase = createClientUseCase;
        this.getClientMetricsUseCase = getClientMetricsUseCase;
        this.listClientsWithEventUseCase = listClientsWithEventUseCase;
    }

    @Override
    public Client createClient(Client client) {
        return createClientUseCase.createClient(client);
    }

    @Override
    public ClientMetrics getMetrics() {
        return getClientMetricsUseCase.getMetrics();
    }
    @Override
    public List<ClientWithEvent> listAllWithEvent() {
        return listClientsWithEventUseCase.listAllWithEvent();
    }
}
