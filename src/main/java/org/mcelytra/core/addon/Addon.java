/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.addon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aperlambda.lambdacommon.utils.Nameable;

/**
 * Represents an addon.
 */
public abstract class Addon implements Nameable
{
    private boolean enabled = false;
    private Logger  logger = LogManager.getLogger(get_name());

    /**
     * Gets the namespace of the addon.
     * <p>
     * A namespace is a modid.
     *
     * @return The namespace.
     */
    public String get_namespace()
    {
        return this.get_name().toLowerCase().replace(' ', '_');
    }

    public abstract void on_enable();

    public abstract void on_disable();

    public abstract AddonLoader get_loader();

    /**
     * Gets the addon logger.
     *
     * @return The addon logger.
     */
    public Logger get_logger()
    {
        return this.logger;
    }

    /**
     * Checks whether or not the addon is enabled.
     *
     * @return True if the addon is enabled, else false.
     */
    public final boolean is_enabled()
    {
        return this.enabled;
    }

    protected final void set_enabled(boolean enabled)
    {
        if (this.enabled != enabled) {
            this.enabled = enabled;
            if (this.enabled)
                this.on_enable();
            else
                this.on_disable();
        }
    }
}
