package com.envent.Events;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserValidatedEvent {
    private String username;
    private boolean isValid;
}
