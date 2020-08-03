package microservice.application.managingPayee;

import microservice.Common.managingPayee.Views.PayeeView;
import org.springframework.data.repository.CrudRepository;
import microservice.domainModel.managingPayee.Payee;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SearchingPayeeAppService implements ISearchingPayeeAppService {

    private CrudRepository<Payee, Integer> repo;

    public SearchingPayeeAppService(CrudRepository<Payee, Integer> repo) {
        this.repo = repo;
    }

    @Override
    public List<PayeeView> search(String name){
        return new ArrayList<PayeeView>() {
            {
                add(PayeeView.create(UUID.randomUUID().toString(), "Rogers", "345-875-3456"));
                add(PayeeView.create(UUID.randomUUID().toString(), "Fido", "999-3412"));
                add(PayeeView.create(UUID.randomUUID().toString(), "Bell", "111-654-1111"));
            }
        };
    }
}
