package microservice.Common.managingPayee.repositories;

import microservice.domainModel.managingPayee.Payee;
import java.util.Optional;

public class PayeeRepository implements IPayeeRepository {
    @Override
    public <S extends Payee> S save(S s) {
        return null;
    }

    @Override
    public <S extends Payee> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Payee> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Payee> findAll() {
        return null;
    }

    @Override
    public Iterable<Payee> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Payee payee) {

    }

    @Override
    public void deleteAll(Iterable<? extends Payee> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Iterable<Payee> findByName(String name) {
        return null;
    }
}
