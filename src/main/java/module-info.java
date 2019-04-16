module org.mcelytra.core {
    exports org.mcelytra.core;
    exports org.mcelytra.core.entity;
    exports org.mcelytra.core.inventory;
    exports org.mcelytra.core.network;
    exports org.mcelytra.core.network.packets;
    exports org.mcelytra.core.permissions;
    exports org.mcelytra.core.tag;

    requires java.desktop;
    requires org.mcelytra.chat;
    requires org.aperlambda.lambdacommon;
    requires org.jetbrains.annotations;
    requires org.apache.logging.log4j;
    requires io.netty.all;

    requires bungeecord.chat;
    requires authlib;
    requires gson;
}
