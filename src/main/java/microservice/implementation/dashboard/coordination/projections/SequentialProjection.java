package microservice.implementation.dashboard.coordination.projections;

import java.sql.Timestamp;

public class SequentialProjection {
    private String payeeName;
    private Double amount;
    private Timestamp createdOn;

    public SequentialProjection(String payeeId, Double amount) {
        this.payeeName = payeeId;
        this.amount = amount;
        this.createdOn = new Timestamp(System.currentTimeMillis());
    }

    public String getPayeeName() {
        return payeeName;
    }

    public Double getAmount() {
        return amount;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }
}
