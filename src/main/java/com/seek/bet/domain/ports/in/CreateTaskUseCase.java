package com.seek.bet.domain.ports.in;

import com.seek.bet.domain.model.Task;

public interface CreateTaskUseCase {
    Task createTask(Task task);
}
