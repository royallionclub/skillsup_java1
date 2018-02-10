package ua.dp.skillsup.reflection.reflection_hw;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;


import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class Executor {

    public static void execute(String packageName) {
        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
        Set<Class<?>> allClasses = reflections.getSubTypesOf(Object.class);

        for (Class clazz : allClasses) {
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Execute.class)) {
                    try {
                        method.invoke(clazz.newInstance(), parameterMatcher(method));
                    } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static String parameterMatcher(Method method)
    {
        String systemParameter = "";
        Annotation annotations[][] = method.getParameterAnnotations();

        for (Annotation annotation[] : annotations)
        {
            for (Annotation parameterAnnotation : annotation)
            {
                String param;
                if (parameterAnnotation instanceof Env)
                {
                    Env env = (Env) parameterAnnotation;
                    param = env.value();
                    systemParameter = System.getenv(param);
                }
            }
        }
        return systemParameter;
    }

    public static void main(String[] args) {
        Executor.execute("ua.dp.skillsup.reflection");
    }


}
