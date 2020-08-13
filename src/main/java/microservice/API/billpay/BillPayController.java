package microservice.API.billpay;

import chassis.buildingblocks.CommandRouter;
import chassis.buildingblocks.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillPayController {
    private static final Logger logger = LoggerFactory.getLogger(BillPayController.class);
    private final CommandRouter<Message> router;

    @Autowired
    public BillPayController(CommandRouter<Message> router){
        this.router = router;
    }

    public void testHandler(){
        /*var payBill = new PayBillCmd();
        router.exec(payBill);*/
    }
}
