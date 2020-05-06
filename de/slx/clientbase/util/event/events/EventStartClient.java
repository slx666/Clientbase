package de.slx.clientbase.util.event.events;

import de.slx.clientbase.util.event.Event;
import org.lwjgl.opengl.Display;

/**
 * Created by joshua
 * in Client
 * at 04.05.2020
 */
public class EventStartClient implements Event {

    private String title;

    public EventStartClient(String title) {
        this.title = title;
        Display.setTitle(this.title);
    }

    public String getTitle() {
        return this.title;
    }
}
