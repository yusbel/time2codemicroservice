package microservice.implementation.billpay.domain.events;

import chassis.buildingblocks.Event;

import java.util.UUID;

public class BillPaid implements Event {

    private final UUID id;
    private final Double amount;

    public BillPaid(UUID id, Double amount){
        this.id = id;
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    public UUID getId() {
        return id;
    }
}
