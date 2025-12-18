package com.seek.bet.domain.ports.in;

import com.seek.bet.domain.model.ClientMetrics;

public interface GetClientMetricsUseCase {
    ClientMetrics getMetrics();
}
