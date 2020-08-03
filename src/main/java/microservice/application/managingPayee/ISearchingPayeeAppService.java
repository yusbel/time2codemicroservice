package microservice.application.managingPayee;

import microservice.Common.managingPayee.Views.PayeeView;

import java.util.List;

public interface ISearchingPayeeAppService {
    List<PayeeView> search(String name);
}
