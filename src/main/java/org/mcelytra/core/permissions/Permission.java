package org.mcelytra.core.permissions;

import org.aperlambda.lambdacommon.resources.ResourceName;
import org.aperlambda.lambdacommon.utils.ResourceNameable;
import org.jetbrains.annotations.NotNull;

public class Permission implements ResourceNameable
{
    private final ResourceName id;
    private String description;

    public Permission(ResourceName id)
    {
        this.id = id;
    }

    @Override
    public @NotNull ResourceName get_resource_name()
    {
        return this.id;
    }
}
