package platform.messaging;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class DomainEvent {
    public final long occurredOn;
    public final int eventVersion;
    public final String messageHubName;
    public final String dispatcherName;

    public static void apply(final DomainEvent... domainEvents) {
        apply(Arrays.asList(domainEvents));
    }

    public static void apply(final List<DomainEvent> domainEvents) {
        final List<DomainEvent> toReturn = new ArrayList<>(domainEvents.size());
        for (final DomainEvent domainEvent : domainEvents) {
            IDispatcher dispatcher = Dispatcher.init("this.dispatcherName");
            MessageHub hub = dispatcher.getOrCreateHub(domainEvent.messageHubName);
            hub.addMessage(new Message(UUID.randomUUID().toString(), "DomainEvent", domainEvent.convertDomainToJsonString()));
        }
    }
    
    protected DomainEvent(String dispatcherName, String messageHubName) {
        this(1, dispatcherName, messageHubName);
    }

    protected DomainEvent(int eventVersion, String dispatcherName, String messageHubName) {
        this.occurredOn = System.currentTimeMillis();
        this.eventVersion = eventVersion;
        this.messageHubName = messageHubName;
        this.dispatcherName = dispatcherName;
    }

    private String convertDomainToJsonString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
