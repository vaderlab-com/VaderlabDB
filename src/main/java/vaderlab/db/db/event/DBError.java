package vaderlab.db.db.event;

import vaderlab.db.core.event.Event;

public class DBError extends Event {

    public static final Integer E_ALREADY_EXISTS = 1;

    private Integer code;

    public DBError(Integer code, String message, Object source) {
        super(source, message);

        this.code = code;
    }

    Integer getCode() {
        return code;
    }
}
