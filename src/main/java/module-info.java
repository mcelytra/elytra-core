module org.mcelytra.core {
    exports org.mcelytra.core;
    exports org.mcelytra.core.entity;
    exports org.mcelytra.core.inventory;
    exports org.mcelytra.core.permissions;
    exports org.mcelytra.core.tag;

    requires org.mcelytra.chat;
    requires org.aperlambda.lambdacommon;
    requires org.apache.logging.log4j;
    requires java.desktop;

    requires bungeecord.chat;
    requires authlib;
    requires annotations;
    requires gson;
}
