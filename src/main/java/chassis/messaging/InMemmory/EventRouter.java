package chassis.messaging.InMemmory;

import chassis.buildingblocks.AggregateRepository;
import chassis.buildingblocks.DB.EventDb;
import chassis.buildingblocks.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class EventRouter implements EventHubDispatcher {

    private static final Logger logger = LoggerFactory.getLogger(EventRouter.class);
    private final Map<Class, List<Consumer<Event>>> routes = new HashMap<>();

    private EventRouter(){}

    private static EventRouter singleton;
    public synchronized static EventRouter getSingleton(){
        if(null == singleton)
            singleton = new EventRouter();
        return singleton;
    }

    public void subscribe(Consumer<Event> handler, Class eventType){
        if(null == handler)
            return;
        logger.info("Subscribing event handler " + eventType.toString());
        synchronized (routes){
            var subscribers = routes.get(eventType);
            if(null == subscribers){
                subscribers = new ArrayList<>();
                routes.put(eventType, subscribers);
            }
            subscribers.add(handler);
            logger.info("Subscribed event handler " + eventType.toString());
        }
    }

    @Override
    public void publish(Event e) {
        if(null == e)
            return;
        logger.info("Publishing event ==> " + e);
        routes.entrySet().stream()
                .forEach(consumers -> {
                    logger.info("Consumers found");
                    consumers.getValue()
                            .forEach(consumer -> {
                                logger.info("Invoking event handler " + consumer);
                                consumer.accept(e);
                            });
                });
    }
}
