package com.envent.Listener;

import com.envent.Events.UserRegisterEvent;
import com.envent.Events.UserValidatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserListener {

    @EventListener
    public UserValidatedEvent listenUserRegisterEvent(UserRegisterEvent userRegisterEvent){
        System.out.println("Listening: Event has been listened -> ".concat(userRegisterEvent.toString()));
        return  new UserValidatedEvent(userRegisterEvent.getUsername(), true);
    }

    @EventListener
    public void listenUserValidateEvent(UserValidatedEvent userValidatedEvent){
        System.out.println("Listening:userValidatedEvent Event has been listened -> ".concat(userValidatedEvent.toString()));
    }
}
