package com.envent.Events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class UserRegisterEvent {

    private String username;
    private String password;
    private byte age;

}
