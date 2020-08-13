package microservice.implementation.dashboard.coordination;

import chassis.buildingblocks.Command;
import java.sql.Timestamp;

public class FindSequentialViewCmd implements Command {

    private Timestamp olderThan;
    public FindSequentialViewCmd(Timestamp olderThan){
        this.olderThan = olderThan;
    }

    public Timestamp getOlderThan() {
        return olderThan;
    }
}
