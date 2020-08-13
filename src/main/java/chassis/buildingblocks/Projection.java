package chassis.buildingblocks;

public interface Projection {
    <E extends Event> void process(Handles<Event> handler, E event);
}
