package microservice.implementation;

import chassis.buildingblocks.Handles;
import chassis.buildingblocks.Message;
import chassis.messaging.InMemmory.EventRouter;
import microservice.implementation.billpay.coordination.EnforcementHandler;
import microservice.implementation.billpay.coordination.PayBillCmd;
import microservice.implementation.billpay.coordination.PayBillHandler;
import microservice.implementation.billpay.domain.events.BillPaid;
import microservice.implementation.dashboard.coordination.SequentialViewBillPaid;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class Setup<M extends Message> implements chassis.buildingblocks.CommandRouter<M> {

    private final HashMap<Class, Handles<M>> handles;

    public Setup(){
        this.handles = new HashMap<>();
        setupCommandHandlers();
        setupEventHandlers();
    }

    private void setupCommandHandlers(){
        this.handles.put(PayBillCmd.class,
            cmd -> EnforcementHandler.enforce(cmd,
                    c -> {
                            var payBillHandler = new PayBillHandler();
                            payBillHandler.handle((PayBillCmd) c);
                        }));

        /*//PayBill command
        this.handles.put(PayBillCmd.class.toString(),
                cmd -> EnforcementHandler.enforce(cmd,
                        c -> PayBillFunctionalHandler.handler(c)));*/

    }

    private void setupEventHandlers(){
        EventRouter.getSingleton().subscribe(e-> SequentialViewBillPaid.handle(e), BillPaid.class);
    }

    @Override
    public void exec(M command) {
        final var commandHandler = this.handles.get(command.getClass());
        if(null == commandHandler)
            throw new IllegalArgumentException("Sorry not command handler found for this command");
        commandHandler.handle(command);
    }
}
