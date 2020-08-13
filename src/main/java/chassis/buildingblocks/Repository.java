package chassis.buildingblocks;

import java.util.UUID;

public interface Repository<T extends AggregateRoot> {

    void save(AggregateRoot aggregateRoot);
    T getById(UUID id, Class type);
}
