package microservice.implementation.billpay.domain;

import chassis.buildingblocks.AggregateRoot;
import microservice.implementation.billpay.coordination.PayBillCmd;
import microservice.implementation.billpay.coordination.PayBillHandler;
import microservice.implementation.billpay.domain.events.BillPaid;
import microservice.implementation.billpay.domain.events.TransactionCreated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/*
* Transaction aggregate
*/
public class Transaction extends AggregateRoot {

    private static final Logger logger = LoggerFactory.getLogger(Transaction.class);

    public Transaction(){
    }

    public Transaction(UUID id, UUID userId, UUID payeeId, String accountNum, Double amount, boolean isNew){
        setupCallback.run();
        create.run();
    }

    public void payBill(PayBillCmd payBillCmd){
        if(payBillCmd.getUserId() == new UUID(0L, 0L))
            throw new IllegalArgumentException("Invalid user id");
        if(payBillCmd.getPayeeId() == new UUID(0L, 0L))
            throw new IllegalArgumentException("Invalid payee id");
        if(payBillCmd.getAccountNum() == "")
            throw new IllegalArgumentException("Invalid account number");
        if(payBillCmd.getAmount() >= 5000 || payBillCmd.getAmount() <= -5000)
            throw new IllegalArgumentException("Invalid amount");
        //apply change
        applyChange(new BillPaid(this.getId(), amount));
    }

    @Override
    public AggregateRoot createEmpty() {
        return new Transaction();
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    protected void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    private void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getPayeeId() {
        return payeeId;
    }

    private void setPayeeId(UUID payeeId) {
        this.payeeId = payeeId;
    }

    public String getAccountNum() {
        return accountNum;
    }

    private void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public Double getAmount() {
        return amount;
    }

    private void setAmount(Double amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return paid;
    }

    private void setPaid(boolean paid) {
        this.paid = paid;
    }

    public boolean isNew() {
        return isNew;
    }

    private void setNew(boolean aNew) {
        isNew = aNew;
    }

    private boolean isNew;
    private UUID id;
    private UUID userId;
    private UUID payeeId;
    private String accountNum;
    private Double amount;
    private boolean paid;

    private Runnable create = () -> {
        applyChange(new TransactionCreated(this.getId(), this.isNew(), this.getUserId(), this.getPayeeId(), this.getAccountNum(), this.getAmount()));
    };

    private Runnable setupCallback = () ->{
        this.setCallback(e -> this.applyTransactionCreated((TransactionCreated)e), TransactionCreated.class);
        this.setCallback(e -> this.applyBillPaid((BillPaid)e), BillPaid.class);
    };

    private void applyTransactionCreated(TransactionCreated transactionCreated){
        this.setPaid(false);
        this.setNew(true);
        this.setId(UUID.randomUUID());
        this.setNew(transactionCreated.getIsNew());
        this.setUserId(transactionCreated.getUserId());
        this.setPayeeId(transactionCreated.getPayeeId());
        this.setAmount(transactionCreated.getAmount());
        this.setAccountNum(transactionCreated.getAccountNum());
    }

    private void applyBillPaid(BillPaid billPaid){
        this.setPaid(true);
    }
}
