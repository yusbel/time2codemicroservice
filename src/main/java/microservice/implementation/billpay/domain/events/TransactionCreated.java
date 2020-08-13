package microservice.implementation.billpay.domain.events;

import chassis.buildingblocks.Event;
import java.util.UUID;

public class TransactionCreated implements Event {
    private final UUID id;
    private final boolean isNew;
    private UUID userId;
    private UUID payeeId;
    private String accountNum;
    private Double amount;
    private Integer version;

    public TransactionCreated(UUID id, boolean isNew, UUID userId, UUID payeeId, String accountNum, Double amount){
        this.id = id;
        this.isNew = isNew;
        this.userId = userId;
        this.payeeId = payeeId;
        this.accountNum = accountNum;
        this.amount = amount;
    }

    public boolean getIsNew() {
        return isNew;
    }

    public UUID getId() {
        return id;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public UUID getPayeeId() {
        return payeeId;
    }

    public UUID getUserId() {
        return userId;
    }

    public Double getAmount() {
        return amount;
    }


}
