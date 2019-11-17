/*
 * Copyright © 2019 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of mcelytra.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package org.mcelytra.core.util;

import org.mcelytra.core.Server;
import org.mcelytra.core.entity.EntityPlayer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class VarStringUtils
{
    public static String apply(String input, Server server)
    {
        return apply(input, make_context(server));
    }

    public static String apply(String input, VarStringContext context)
    {
        return context.apply(input);
    }

    public static VarStringContext make_context(Server server)
    {
        VarStringContext context = new VarStringContext();
        context.register("server_name", server::get_name);
        context.register("max_players", () -> String.valueOf(server.get_max_players()));
        context.register("online_count", () -> String.valueOf(server.get_online_players()));
        context.register("version", server::get_mc_version);
        context.register("bedrock_version", server::get_mc_bedrock_version);
        context.register("brand", server::get_brand);
        return context;
    }

    public static VarStringContext make_context(EntityPlayer player) {
        VarStringContext context = make_context(player.get_server());
        context.register("player_name", player::get_name);
        context.register("player_uuid", () -> player.get_unique_id().toString());
        context.register("player_ping", () -> String.valueOf(player.get_ping()));
        context.register("player_brand", player::get_brand);
        context.register("player_address", () -> player.get_address().toString());
        return context;
    }

    public static class VarStringContext
    {
        private final Map<String, Supplier<String>> suppliers = new HashMap<>();

        public void register(String var_name, Supplier<String> supplier)
        {
            suppliers.put(var_name, supplier);
        }

        public String apply(String input)
        {
            for (Map.Entry<String, Supplier<String>> entry : suppliers.entrySet()) {
                String var_name = entry.getKey();
                Supplier<String> supplier = entry.getValue();
                String var_f = "${" + var_name + "}";
                if (input.contains(var_f))
                    input = input.replace(var_f, supplier.get());
            }
            return input;
        }

        public VarStringContext copy()
        {
            VarStringContext clone = new VarStringContext();
            this.suppliers.forEach(clone::register);
            return clone;
        }
    }
}
