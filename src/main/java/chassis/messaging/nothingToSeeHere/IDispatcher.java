package chassis.messaging.nothingToSeeHere;

public interface IDispatcher {
    MessageHub getOrCreateHub(String name);
}
