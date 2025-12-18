package com.seek.bet.domain.ports.out;

import com.seek.bet.domain.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepositoryPort {
    Client save(Client client);
    Optional<Client> findById(Long id);
    List<Client> findAll();
    Optional<Client> update(Client client);
    boolean deleteById(Long id);
}
