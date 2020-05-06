package de.slx.clientbase.module;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by joshua
 * in Client
 * at 05.05.2020
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ModuleManifest {

    String name();

    int keyBind() default 0;

    Module.ModuleCategory category();
}
