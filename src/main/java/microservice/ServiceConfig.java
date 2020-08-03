package microservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import microservice.Common.managingPayee.repositories.PayeeRepository;
import microservice.application.managingPayee.ISearchingPayeeAppService;
import microservice.application.managingPayee.SearchingPayeeAppService;
import microservice.domainModel.managingPayee.Payee;

//@Configuration
public class ServiceConfig {
    //@Bean
    public CrudRepository<Payee, Integer> payeeRepository() {
        return new PayeeRepository();
    }

    //@Bean
    public ISearchingPayeeAppService searchingPayeeAppService(){
        return new SearchingPayeeAppService(payeeRepository());
    }
}
