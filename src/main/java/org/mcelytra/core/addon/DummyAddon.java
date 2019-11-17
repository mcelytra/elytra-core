/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.addon;

public abstract class DummyAddon extends Addon
{
    private AddonLoader loader = new DummyAddonLoader();

    @Override
    public AddonLoader get_loader()
    {
        return loader;
    }
}
