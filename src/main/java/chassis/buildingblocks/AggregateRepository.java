package chassis.buildingblocks;

import chassis.buildingblocks.DB.AggregateDb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.UUID;

public class AggregateRepository<T extends AggregateRoot> implements Repository<T> {

    private static final Logger logger = LoggerFactory.getLogger(AggregateRepository.class);
    private final IEventRepository eventRepo;

    public AggregateRepository(IEventRepository eventRepo){
        this.eventRepo = eventRepo;
    }

    @Override
    public void save(AggregateRoot aggregateRoot) {
        var db = AggregateDb.getSingleton();
        db.add(aggregateRoot);
        eventRepo.save(aggregateRoot.getId(), aggregateRoot.getClass(), aggregateRoot.getEvents());
    }

    @Override
    public T getById(UUID id, Class type) {
        var db = AggregateDb.getSingleton();
        logger.info("Getting transaction aggregate with id " + id);
        return (T)db.get(type, id);
        /*
        try{
            Constructor<T> constructor = type.getDeclaredConstructor(null);
            return constructor.newInstance(null);
        }
        catch (Exception e) {
            e.printStackTrace();
        }*/
    }


}
