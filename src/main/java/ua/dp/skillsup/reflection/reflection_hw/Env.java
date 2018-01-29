package ua.dp.skillsup.reflection.reflection_hw;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
public @interface Env {
    String value();
}
