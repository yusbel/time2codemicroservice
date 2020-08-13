package chassis.messaging.nothingToSeeHere;

import java.util.HashMap;
import java.util.Map;

public class Dispatcher implements IDispatcher {

    private static final Map<String, Dispatcher> dispatchers = new HashMap<String, Dispatcher>();

    private final String name;
    private final Map<String, MessageHub> hubs;

    public static synchronized Dispatcher init(final String name) {
        final Dispatcher dispatcher = dispatchers.get(name);
        if (dispatcher != null) {
            return dispatcher;
        }
        final Dispatcher newDispatcher = new Dispatcher(name, new HashMap<>());
        dispatchers.put(name, newDispatcher);
        return newDispatcher;
    }

    protected Dispatcher(String name, Map<String, MessageHub> hubs) {
        this.name = name;
        this.hubs = hubs;
    }

    public String getName() {
        return name;
    }

    @Override
    public MessageHub getOrCreateHub(final String name) {
        synchronized (hubs){
            final MessageHub toReturn = hubs.get(name);
            if(null != toReturn)
                return toReturn;
            final MessageHub hub = new MessageHub(name);
            hubs.put(name, hub);
            return hub;
        }
    }
}
