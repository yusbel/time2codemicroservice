package microservice.implementation.billpay.coordination;

import chassis.buildingblocks.Command;
import java.util.UUID;

public class PayBillCmd implements Command {
    private final UUID userId;
    private final UUID payeeId;
    private final String accountNum;
    private final Double amount;

    public PayBillCmd(UUID userId, UUID payeeId, String accountNum, Double amount) {
        this.userId = userId;
        this.payeeId = payeeId;
        this.accountNum = accountNum;
        this.amount = amount;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getPayeeId() {
        return payeeId;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public Double getAmount() {
        return amount;
    }
}
