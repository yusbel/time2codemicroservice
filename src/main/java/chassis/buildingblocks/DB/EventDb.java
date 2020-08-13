package chassis.buildingblocks.DB;

import chassis.buildingblocks.Event;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EventDb {

    final Map<EventIdentifier, Iterable<Event>> events = new HashMap<>();
    private EventDb(){}

    private class EventIdentifier {
        private final Class type;
        private final UUID ID;
        private EventIdentifier(Class Type, UUID ID){
            type = Type;
            this.ID = ID;
        }
    }

    public void add(Class aggRoot, UUID id, Iterable<Event> eventsToAdd){
        synchronized (events){
            final var aggId = new EventIdentifier(aggRoot, id);
            events.put(aggId, eventsToAdd);
        }
    }

    public Iterable<Event> get(Class type, UUID id){
        synchronized (events){
            final var aggId = new EventIdentifier(type, id);
            return events.get(aggId);
        }
    }

    private static EventDb singleton;
    public synchronized static EventDb getSingleton(){
        if(null == singleton)
            singleton = new EventDb();
        return singleton;
    }




}
