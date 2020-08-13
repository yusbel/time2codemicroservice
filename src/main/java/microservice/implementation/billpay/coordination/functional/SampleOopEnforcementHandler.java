package microservice.implementation.billpay.coordination.functional;

import chassis.buildingblocks.Handles;
import chassis.buildingblocks.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleOopEnforcementHandler<M extends Message, T extends Handles<M>> {

    private static final Logger logger = LoggerFactory.getLogger(SampleOopEnforcementHandler.class);
    private final Handles<M> next;

    public SampleOopEnforcementHandler(Handles<M> next){
        this.next = next;
    }

    public void handle (M message){
        //TODO: ADD enforcement common logic here.
        next.handle(message);
    }
}
