package chassis.buildingblocks;

import java.util.UUID;

public interface IEventRepository {
    void save(UUID aggregateId, Class aggRoot, Iterable<Event> events);
    Iterable<Event> getEvents(UUID aggregateId);
}
