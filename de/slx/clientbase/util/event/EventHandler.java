package de.slx.clientbase.util.event;

import de.slx.tests.EventHandlerTest;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

/**
 * Created by joshua
 * in Client
 * at 04.05.2020
 * Examples located at {@link EventHandlerTest}
 * The {@link EventTarget} annotation function can be removed.
 * As of right now it's kinda useless.
 */
public class EventHandler {

    private static final List<Object> REGISTERED_CLASSES = new CopyOnWriteArrayList<>();

    /**
     * Register a class to the event handler
     * It will only add classes that are actually using events...
     *
     * @param classObject The class
     */
    public static void registerClass(Object classObject) {
        Arrays.stream(classObject.getClass().getDeclaredMethods())
                .filter(method -> method.getParameterCount() == 1)
                .filter(method -> Event.class.isAssignableFrom(method.getParameterTypes()[0]))
                .filter(method -> method.isAnnotationPresent(EventTarget.class))
                .forEach(method -> REGISTERED_CLASSES.add(classObject));
    }

    /**
     * Invokes methods that are using the given event
     *
     * @param event The event
     */
    public static void call(Event event) {
        REGISTERED_CLASSES.forEach(o -> Arrays.stream(o.getClass().getDeclaredMethods())
                .filter(method -> method.getParameterCount() == 1)
                .filter(method -> event.getClass() == method.getParameterTypes()[0])
                .filter(method -> method.isAnnotationPresent(EventTarget.class))
                .forEach(method -> {
                    try {
                        method.invoke(o, event);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }));
    }

    /**
     * Unregisters the given class
     *
     * @param classObject The class
     */
    public static void unregisterClass(Object classObject) {
        IntStream.range(0, REGISTERED_CLASSES.size())
                .filter(value -> REGISTERED_CLASSES.get(value) == classObject)
                .forEach(REGISTERED_CLASSES::remove);
    }
}
