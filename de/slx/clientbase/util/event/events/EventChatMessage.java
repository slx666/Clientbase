package de.slx.clientbase.util.event.events;

import de.slx.clientbase.util.event.Event;

/**
 * Created by joshua
 * in Client
 * at 06.05.2020
 * Good example of an event that should be cancelled.
 */
public class EventChatMessage implements Event {

    private boolean cancelled;
    private String message;

    public EventChatMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
