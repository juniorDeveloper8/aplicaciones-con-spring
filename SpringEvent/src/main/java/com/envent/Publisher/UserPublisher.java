package com.envent.Publisher;

import com.envent.Events.UserRegisterEvent;
import com.envent.Events.UserValidatedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class UserPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public UserPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    //Medoto para publicar el evento
    public void publishUserRegisterEvent(String username, String password, byte age) {
        System.out.println("Publish: Event has been published");
        applicationEventPublisher.publishEvent(new UserRegisterEvent(username, password, age));
    }

    public void  publishUserValidateEvent(String username,boolean isValid) {
        System.out.println("Evento de Validacion: Publicado");
        applicationEventPublisher.publishEvent(new UserValidatedEvent(username, isValid));
    }
}
