package chassis.buildingblocks;

public interface Handles<T extends Message>  {
    void handle(T message);
}
