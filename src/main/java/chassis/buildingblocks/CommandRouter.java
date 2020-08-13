package chassis.buildingblocks;

public interface CommandRouter<M extends Message> {
    void exec(M command);
}
