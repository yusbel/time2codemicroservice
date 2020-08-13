package microservice.implementation.billpay.coordination;

import chassis.buildingblocks.Handles;
import chassis.buildingblocks.Message;

public class EnforcementHandler {

    /*
     *Functional method using handles interface
     */
    public static <M extends Message> void enforce(M message, Handles<M> handler){
        //Todo: Apply reusable security checks here
        handler.handle(message);
    }
}
