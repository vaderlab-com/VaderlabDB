package vaderlab.db.core.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import vaderlab.db.core.KernelEvent;

import java.util.HashMap;

/**
 * Created by kost on 3.6.16.
 */
@Configuration("event.dispatcher_service")
@ComponentScan
public class EventDispatcherService {

    private EventDispatcher eventDispatcher;

    public EventDispatcherService()
    {
        eventDispatcher = new EventDispatcher();
    }

    public void dispatch(Event event)
    {
        if(!(event instanceof KernelEvent)) {
            eventDispatcher.multicastEvent(new KernelEvent(event));
        }

        eventDispatcher.multicastEvent(event);
    }

    public void addListener(ApplicationListener<Event> eventListener)
    {
        eventDispatcher.addApplicationListener(eventListener);
    }

    public void removeListener(ApplicationListener<Event> eventListener)
    {
        eventDispatcher.removeApplicationListener(eventListener);
    }

    public void removeAllListeners()
    {
        eventDispatcher.removeAllListeners();
    }
}
