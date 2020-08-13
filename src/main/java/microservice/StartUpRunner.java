package microservice;

import chassis.buildingblocks.Message;
import microservice.implementation.Setup;
import microservice.implementation.billpay.coordination.PayBillCmd;
import microservice.implementation.billpay.coordination.PayBillHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
public class StartUpRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(StartUpRunner.class);


    @Override
    @Transactional
    public void run(String... args) throws Exception {

        var setup = new Setup<>();


        PayBillCmd cmd = new PayBillCmd(UUID.randomUUID(), UUID.randomUUID(), "334-544-999", 23.98);
        setup.exec(cmd);
        //PayBillHandler handler = new PayBillHandler();
        //handler.handle(cmd);


        /*Payee payee = new Payee();
        payee.setId(1);
        payee.setName("Rogers");
        payee.setCustomerId("1111");
        payeeRepository.save(payee);

        payee.setId(2);
        payee.setName("Fido");
        payee.setCustomerId("1111");
        payeeRepository.save(payee);

        payee.setId(3);
        payee.setName("Bell");
        payee.setCustomerId("1111");
        payeeRepository.save(payee);

        logger.info("Payee saved");*/

    }
}
