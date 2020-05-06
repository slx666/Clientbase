package de.slx.tests;

import de.slx.clientbase.util.event.Event;
import de.slx.clientbase.util.event.EventHandler;
import de.slx.clientbase.util.event.EventTarget;

/**
 * Created by joshua
 * in Client
 * at 04.05.2020
 * This class should be removed
 */
public class EventHandlerTest {

    private boolean executable;

    public static void main(String[] args) {
        //Creating an object of the test class
        EventHandlerTest eventHandlerTest = new EventHandlerTest();

        //Registering the class to the event handler
        EventHandler.registerClass(eventHandlerTest);

        //Calling the test event
        EventHandler.call(new EventTest());

        //Invoke our test method
        eventHandlerTest.handleTest();

        //Unregistering the class from the event handler (In this case it's kinda useless)
        EventHandler.unregisterClass(eventHandlerTest);
    }

    public void handleTest() {
        if (this.executable)
            System.out.println("Event system works!");
        else
            System.out.println(":(");
    }

    @EventTarget
    public void onEvent(EventTest eventTest) {
        this.executable = true;
    }

    public static class EventTest implements Event {
    }
}
