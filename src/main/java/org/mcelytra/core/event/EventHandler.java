/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Represents an event handler.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EventHandler
{
    /**
     * Sets the priority of the handler.
     * @return The priority.
     */
    EventPriority priority() default EventPriority.NORMAL;

    /**
     * Sets whether the handler ignores the cancellation state of the event.
     * @return True if the handler ignores cancelled event, else false.
     */
    boolean ignore_cancelled() default false;
}
