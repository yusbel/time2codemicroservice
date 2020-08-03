package microservice.domainModel.managingPayee;

import microservice.Common.managingPayee.Views.PayeeView;
import microservice.Common.managingPayee.WriteCommand.AddingPayee;
import microservice.Common.managingPayee.WriteCommand.CreatingPayee;

public class PayeeAggregate {

    private int id;
    private Payee payee;
    public PayeeAggregate(Integer id) {
        this.id = id;
    }

    private Payee getPayee(){
        if(null == payee)
            payee = new Payee();
        return payee;
    }

    public void createPayee(CreatingPayee payee){
        //TODO query database
        RetrievedPayee.apply(new RetrievedPayee("1", payee.getName()));
    }

    public PayeeView addPayee(AddingPayee addingPayee){
        return PayeeView.createDefault();
    }
}
