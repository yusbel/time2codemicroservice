package microservice.implementation.dashboard.coordination;

import chassis.buildingblocks.Event;
import microservice.implementation.billpay.domain.events.BillPaid;
import microservice.implementation.dashboard.coordination.DB.ProjectionDb;
import microservice.implementation.dashboard.coordination.projections.SequentialProjection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SequentialViewBillPaid {

    private static final Logger logger = LoggerFactory.getLogger(SequentialViewBillPaid.class);

    public static void handle(Event billPaid) {
        logger.info("Sequential event handler invoked");
        if(!(billPaid instanceof BillPaid))
            return;
        var event = (BillPaid)billPaid;
        var db = ProjectionDb.getSingleton();
        var toAdd = new SequentialProjection("Fido", event.getAmount());
        db.add(toAdd);
        logger.info("Sequential projection created and added ");
    }
}
