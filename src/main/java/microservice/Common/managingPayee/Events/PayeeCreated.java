package microservice.Common.managingPayee.Events;

import platform.messaging.DomainEvent;

public class PayeeCreated extends DomainEvent {

    protected PayeeCreated(String messageHubName) {
        super("Payee", messageHubName);
    }
}
