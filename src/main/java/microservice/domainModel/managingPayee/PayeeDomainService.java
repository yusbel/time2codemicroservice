package microservice.domainModel.managingPayee;

import java.util.ArrayList;
import java.util.List;

public class PayeeDomainService {

    public List<Payee> getPayeesByName(final String name){
        ArrayList payees = new ArrayList();
        payees.add(new Payee());
        payees.add(new Payee());
        return payees;
    }

}
