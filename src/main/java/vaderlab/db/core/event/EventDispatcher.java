package vaderlab.db.core.event;

import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by kost on 3.6.16.
 */
@Component("event.dispatcher")
public class EventDispatcher extends SimpleApplicationEventMulticaster {
}
