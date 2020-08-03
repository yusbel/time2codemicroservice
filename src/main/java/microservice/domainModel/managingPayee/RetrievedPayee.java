package microservice.domainModel.managingPayee;

import platform.messaging.DomainEvent;
import java.util.UUID;

public class RetrievedPayee extends DomainEvent {

    public RetrievedPayee(String key, String name) {
        super(UUID.randomUUID().toString(), name);
    }


}
