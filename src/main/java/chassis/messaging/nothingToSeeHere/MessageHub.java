package chassis.messaging.nothingToSeeHere;

import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MessageHub extends Thread {

    private final String name;
    private final boolean stopped;
    private final HashSet<IConsumer> consumers;
    private final ConcurrentLinkedQueue<Message> messages;

    @Override
    public void run(){
        while(!stopped){
            final Message message = messages.poll();
            if (message != null) { // dispatch message
                synchronized (consumers) {
                    for (final IConsumer consumer : consumers) {
                        try {
                            consumer.handle(message);//TODO: consumers exception are logged
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            if(null == message)
                try {
                    Thread.sleep(20L);//TODO: make a configuration variable for it.
                } catch (InterruptedException e) {
                    // ignore
                }
        }
    }

    public void subscribe(IConsumer consumer){
        synchronized (consumers){
            consumers.add(consumer);
        }
    }

    public void addMessage(Message message){
        synchronized (messages){
            messages.add(message);
        }
    }

    protected MessageHub(final String name) {
        this.name = name;
        this.stopped = false;
        this.messages = new ConcurrentLinkedQueue<>();
        this.consumers = new HashSet<IConsumer>();
    }
}
