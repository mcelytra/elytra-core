/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.addon;

import org.jetbrains.annotations.NotNull;
import org.mcelytra.core.event.Event;
import org.mcelytra.core.event.EventHandler;
import org.mcelytra.core.event.Listener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public abstract class AddonLoader
{
    public abstract @NotNull Addon load_addon(@NotNull Addon addon_file);

    public @NotNull Map<Class<? extends Event>, Set<RegisteredListener>> create_registered_listeners(@NotNull Addon addon, @NotNull Listener listener) {
        HashMap<Class<? extends Event>, Set<RegisteredListener>> regl = new HashMap<>();
        Set<Method> methods;
        try {
            Method[] public_methods = listener.getClass().getMethods();
            Method[] private_methods = listener.getClass().getDeclaredMethods();
            methods = new HashSet<>(public_methods.length + private_methods.length, 1.0F);
            methods.addAll(Arrays.asList(public_methods));
            methods.addAll(Arrays.asList(private_methods));
        } catch (NoClassDefFoundError e) {
            addon.get_logger().error("Addon " + addon.get_name() + " has failed to register event for " + listener.getClass() + " because " + e.getMessage() + " does not exist.");
            return regl;
        }

        methods.stream()
                // Avoid event duplication.
                .filter(method -> !method.isBridge() && !method.isSynthetic())
                .forEach(method -> {
                    final EventHandler eh = method.getAnnotation(EventHandler.class);
                    if (eh == null)
                        return;

                    final Class<?> check_class;
                    if (method.getParameterTypes().length != 1 || !Event.class.isAssignableFrom(check_class = method.getParameterTypes()[0])) {
                        addon.get_logger().error(addon.get_name() + " attempted to register an invalid EventHandler, method signature \"" + method.toGenericString() + "\" in " + listener.getClass());
                        return;
                    }
                    final Class<? extends Event> event_class = check_class.asSubclass(Event.class);
                    method.setAccessible(true);

                    Set<RegisteredListener> event_set = regl.computeIfAbsent(event_class, a -> new HashSet<>());

                    EventExecutor executor = (l, event) -> {
                        if (!event_class.isAssignableFrom(event.getClass()))
                            return;
                        try {
                            method.invoke(l, event);
                        } catch (InvocationTargetException e) {
                            throw new RuntimeException(e.getCause());
                        } catch (Throwable t) {
                            throw new RuntimeException(t);
                        }
                    };

                    event_set.add(new RegisteredListener(listener, eh.priority(), addon, executor, eh.ignore_cancelled()));
                });

        return regl;
    }
}
