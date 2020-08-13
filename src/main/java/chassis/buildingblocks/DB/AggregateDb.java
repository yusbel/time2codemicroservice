package chassis.buildingblocks.DB;

import chassis.buildingblocks.AggregateRoot;
import microservice.implementation.billpay.coordination.PayBillHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AggregateDb<T extends AggregateRoot> {

    private static final Logger logger = LoggerFactory.getLogger(AggregateDb.class);

    private AggregateDb(){}
    final Map<AggregateIdentifier, T> aggregates = new HashMap<>();
    private class AggregateIdentifier{
        private final Class type;
        private final UUID ID;
        private AggregateIdentifier(Class Type, UUID ID){
            type = Type;
            this.ID = ID;
        }
    }

    public void add(T toAdd){
        logger.info("Adding aggregate to aggregate db with id " + toAdd.getId());
        synchronized (aggregates){
            final var aggId = new AggregateIdentifier(toAdd.getClass(), toAdd.getId());
            aggregates.put(aggId, toAdd);
        }
    }

    public T get(Class type, UUID id){
        logger.info("Getting aggregate with id " + id);
        aggregates.values().forEach(a -> logger.info("aggregate found with id " + a.getId()));
        synchronized (aggregates){
            final var aggId = new AggregateIdentifier(type, id);

            return aggregates.get(aggId);
        }
    }

    private static AggregateDb singleton;
    public synchronized static AggregateDb getSingleton(){
        if(null == singleton)
            singleton = new AggregateDb();
        return singleton;
    }




}
