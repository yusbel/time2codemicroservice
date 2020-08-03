package platform.messaging;

public interface IDispatcher {
    MessageHub getOrCreateHub(String name);
}
