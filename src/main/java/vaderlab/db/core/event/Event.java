package vaderlab.db.core.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by kost on 3.6.16.
 */
public class Event extends ApplicationEvent {

    private String message;

    /**
     * @param source event source data
     */
    public Event(Object source)
    {
        super(source);
        message = "";
    }

    /**
     *
     * @param source event source data
     * @param message event description
     */
    public Event(Object source, String message)
    {
        super(source);
        this.message = message;
    }

    /**
     * @return Event message
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * @return event description
     */
    public String toString()
    {
        return "Event \"" +
                this.getClass().toString() +
                "\": Message: \"" +
                getMessage() +
                "\" Source: " + getSource();
    }
}