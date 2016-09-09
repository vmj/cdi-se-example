package fi.linuxbox.cdi.se.beans;

import javax.enterprise.context.*;
import javax.enterprise.event.*;
import org.slf4j.*;

/**
 * Just a logger for scope initialization/destruction.
 */
public class ContextListener {
    private static final Logger log = LoggerFactory.getLogger(ContextListener.class);

    public static void onRequestScopeInitialized(@Observes @Initialized(RequestScoped.class) Object ctx) {
        log("ServletRequest", ctx, "Request", "initialized");
    }

    public static void onRequestScopeDestroyed(@Observes @Destroyed(RequestScoped.class) Object ctx) {
        log("ServletRequest", ctx, "Request", "destroyed");
    }

    public static void onSessionScopeInitialized(@Observes @Initialized(SessionScoped.class) Object ctx) {
        log("HttpSession", ctx, "Session", "initialized");
    }

    public static void onSessionScopeDestroyed(@Observes @Destroyed(SessionScoped.class) Object ctx) {
        log("HttpSession", ctx, "Session", "destroyed");
    }

    public static void onApplicationScopeInitialized(@Observes @Initialized(ApplicationScoped.class) Object ctx) {
        log("ServletContext", ctx, "Application", "initialized");
    }

    public static void onApplicationScopeDestroyed(@Observes @Destroyed(ApplicationScoped.class) Object ctx) {
        log("ServletContext", ctx, "Application", "destroyed");
    }

    public static void onConversationScopeInitialized(@Observes @Initialized(ConversationScoped.class) Object ctx) {
        log(null, ctx, "Conversation", "initialized");
    }

    public static void onConversationScopeDestroyed(@Observes @Destroyed(ConversationScoped.class) Object ctx) {
        log(null, ctx, "Conversation", "destroyed");
    }

    private static void log(final String className, final Object ctx, final String scopeName, final String eventName) {
        final String ctxName = ctx != null ? ctx.getClass().getSimpleName() : "NULL";
        if (className == null) {
            log.debug(scopeName + " scope " + eventName);
        } else if (className.equals(ctxName)) {
            log.debug(scopeName + " scope " + eventName + " in a web app");
        } else {
            log.debug(scopeName + " scope " + eventName + " in a non-web app: " + ctxName);
        }
    }
}
