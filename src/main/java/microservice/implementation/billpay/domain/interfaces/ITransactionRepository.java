package microservice.implementation.billpay.domain.interfaces;

import microservice.implementation.billpay.domain.Transaction;

public interface ITransactionRepository {

    Transaction getById(Integer id);
    int save(Transaction transaction);
}
