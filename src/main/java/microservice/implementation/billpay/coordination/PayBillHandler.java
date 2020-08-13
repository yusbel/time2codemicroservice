package microservice.implementation.billpay.coordination;

import chassis.buildingblocks.AggregateRepository;
import chassis.buildingblocks.EventRepository;
import chassis.buildingblocks.Handles;
import chassis.messaging.InMemmory.EventRouter;
import microservice.implementation.billpay.domain.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class PayBillHandler implements Handles<PayBillCmd> {

    private static final Logger logger = LoggerFactory.getLogger(PayBillHandler.class);

    @Override
    public void handle(PayBillCmd billPay) {
        //Invoke command
        var transaction = new Transaction(UUID.randomUUID(), billPay.getUserId(), billPay.getPayeeId(), billPay.getAccountNum(), billPay.getAmount(), true);
        logger.info("Transaction is paid? " + transaction.isPaid());
        transaction.payBill(billPay);
        logger.info("Transaction is paid? " + transaction.isPaid());

        //Save events and state
        var repo = new AggregateRepository<>(new EventRepository(EventRouter.getSingleton()));
        repo.save(transaction);
        var trans = repo.getById(transaction.getId(), Transaction.class);
        logger.info("Is transaction null? " + (null == trans));
    }

}
