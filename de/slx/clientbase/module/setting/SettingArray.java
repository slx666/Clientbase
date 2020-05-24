package de.slx.clientbase.module.setting;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by joshua
 * in Client
 * at 06.05.2020
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SettingArray {

    //Array of modes for example
    String[] value();
}
