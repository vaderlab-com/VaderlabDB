package vaderlab.db.core;

import vaderlab.db.core.event.Event;

/**
 * Created by kost on 3.6.16.
 */
public class KernelEvent extends Event {

    final public static String EVT_RUN        = "app.run";

    final public static String EVT_SHUTDOWN   = "app.shutdown";

    final public static String EVT_CUSTOM     = "app.other";

    public KernelEvent(Object message)
    {
        super(message);
    }
}
