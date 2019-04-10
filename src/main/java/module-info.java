module org.mcelytra.core {
    exports org.mcelytra.core;
    exports org.mcelytra.core.inventory;

    requires org.mcelytra.chat;
    requires org.aperlambda.lambdacommon;
    requires java.desktop;

    requires bungeecord.chat;
    requires authlib;
    requires annotations;
    requires gson;
}
