package vaderlab.db.db.event;

import vaderlab.db.core.event.Event;

public class DBCreate extends Event {
    public DBCreate(Object source) {
        super(source);
    }

    public DBCreate(Object source, String message) {
        super(source, message);
    }
}
