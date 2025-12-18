package com.seek.bet.domain.ports.in;

import com.seek.bet.domain.model.ClientWithEvent;
import java.util.List;

public interface ListClientsWithEventUseCase {
    List<ClientWithEvent> listAllWithEvent();
}
