package com.seek.bet.domain.ports.in;

import com.seek.bet.domain.model.Client;

public interface CreateClientUseCase {
    Client createClient(Client client);
}
