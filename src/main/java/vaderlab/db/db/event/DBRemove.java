package vaderlab.db.db.event;

import vaderlab.db.core.event.Event;

public class DBRemove extends Event {
    public DBRemove(Object source) {
        super(source);
    }

    public DBRemove(Object source, String message) {
        super(source, message);
    }
}
