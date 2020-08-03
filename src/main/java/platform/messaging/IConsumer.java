package platform.messaging;

public interface IConsumer {
    void handle(final Message message);
}
