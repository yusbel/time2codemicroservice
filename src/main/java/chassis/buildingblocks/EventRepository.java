package chassis.buildingblocks;

import chassis.buildingblocks.DB.EventDb;
import chassis.messaging.InMemmory.EventHubDispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class EventRepository implements IEventRepository {

    private static final Logger logger = LoggerFactory.getLogger(EventRepository.class);
    private final EventHubDispatcher dispatcher;

    public EventRepository(EventHubDispatcher dispatcher){
        this.dispatcher = dispatcher;
    }

    @Override
    public void save(UUID aggregateId, Class aggRoot, Iterable<Event> events) {
        var eventDB = EventDb.getSingleton();
        logger.info(String.format("Saving events with id %s", aggregateId));
        eventDB.add(aggRoot, aggregateId, events);

        events.forEach(e-> {
            logger.info(String.format("Dispatching events %s", e.toString()));
            dispatcher.publish(e);
        });
    }

    @Override
    public Iterable<Event> getEvents(UUID aggregateId) {
        return null;
    }
}
