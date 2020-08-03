package microservice.application.managingPayee.eventHandlers;

import platform.messaging.IConsumer;
import platform.messaging.Message;

public class RetrievedPayeeEventHandler implements IConsumer {
    @Override
    public void handle(Message message) {
        //TODO: deserialize the event from the payload property
        //TODO: use payee application service.
    }
}
