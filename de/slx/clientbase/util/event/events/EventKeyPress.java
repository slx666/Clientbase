package de.slx.clientbase.util.event.events;

import de.slx.clientbase.util.event.Event;

/**
 * Created by joshua
 * in Client
 * at 05.05.2020
 */
public class EventKeyPress implements Event {

    private int key;

    public EventKeyPress(int key) {
        this.key = key;
    }

    public int getKey() {
        return this.key;
    }
}
