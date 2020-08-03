package microservice.Common.managingPayee.repositories;

import org.springframework.data.repository.CrudRepository;
import microservice.domainModel.managingPayee.Payee;

public interface IPayeeRepository extends CrudRepository<Payee, Integer> {
    Iterable<Payee> findByName(String name);
}
