package chassis.messaging.InMemmory;

import chassis.buildingblocks.Event;
import java.util.function.Consumer;

public interface EventHubDispatcher {
    void publish(Event e);
    void subscribe(Consumer<Event> handler, Class eventType);
}
