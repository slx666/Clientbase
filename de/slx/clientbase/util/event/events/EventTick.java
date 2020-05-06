package de.slx.clientbase.util.event.events;

import de.slx.clientbase.util.event.Event;

/**
 * Created by joshua
 * in Client
 * at 05.05.2020
 */
public class EventTick implements Event {

    private Type type;

    public EventTick(Type type) {
        this.type = type;
    }

    public Type getType() {
        return this.type;
    }

    public enum Type {
        WORLD, EVERYWHERE
    }
}
