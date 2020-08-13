package chassis.buildingblocks;

import java.util.*;
import java.util.function.Consumer;

public abstract class AggregateRoot {
    final private List<Event> events = new ArrayList<>();
    final private Map<Class, Consumer<Event>> callback = new HashMap<>();

    private Integer version;
    private void setVersion(Integer version) {
        this.version = version;
    }

    public abstract AggregateRoot createEmpty();
    public abstract UUID getId();
    protected abstract void setId(UUID id);

    protected void setCallback(Consumer<Event> eventConsumer, Class typeEvent){
        synchronized (callback){
            if(null != callback.get(typeEvent))
                throw new RuntimeException("Only one callback is allow");
            callback.put(typeEvent, eventConsumer);
        }
    }

    public Integer getVersion() {
        return version;
    }

    public Iterable<Event> getEvents(){
        return events;
    }

    public void clearEvents(){
        synchronized (events){
            events.clear();
        }
    }

    public void loadEvents(Iterable<Event> events){
        synchronized (events){
             events.forEach(e -> applyChange(e));
        }
    }

    protected void applyChange(Event e){
        applyChange(e, true);
    }

    private void applyChange(Event e, boolean isNew){
        var callBackHandler = callback.get(e.getClass());
        if(null == callBackHandler)
            throw new RuntimeException("Call back handler not found");
        callBackHandler.accept(e);
        if(isNew)
            events.add(e);
    }
}
