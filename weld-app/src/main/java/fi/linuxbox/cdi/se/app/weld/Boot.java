package fi.linuxbox.cdi.se.app.weld;

import fi.linuxbox.cdi.se.beans.*;
import javax.enterprise.event.*;
import javax.enterprise.inject.spi.*;
import javax.inject.*;
import org.jboss.weld.environment.se.*;
import org.jboss.weld.environment.se.events.*;

/**
 * A simple boot process for a Weld SE based app.
 * <p>
 *     There's two ways to boot a Weld app:
 * </p>
 * <ul>
 *     <li>via <code>StartMain.main()</code> method that is provided by Weld SE and listening for Weld specific
 *         <code>ContainerInitialized</code> CDI event (and making sure that the event listener is in a bean archive)</li>
 *     <li>or by instantiating Weld container manually in our own main function</li>
 * </ul>
 * <p>
 *     This class demonstrates both, and uses a flag to distinguish which happens to be used.  Without the flag,
 *     the <code>BootEvent</code> would be fired twice when using a custom main function.
 * </p>
 */
@Singleton
public class Boot {
    private static boolean customMainUsed = false;

    /**
     * In order to use the <code>StartMain.main()</code> and booting via the <code>ContainerInitiazed</code> event,
     * make sure the <code>build.gradle</code> has the following <code>mainClassName</code> setting enabled:
     *
     *     mainClassName = 'org.jboss.weld.environment.se.StartMain'
     *
     * This JAR also contains the <code>beans.xml</code> file in the resource, and is thus considered a bean archive by
     * Weld.
     */
    public void boot(@Observes ContainerInitialized event, BeanManager bm) {
        if (!customMainUsed)
            bm.fireEvent(new BootEvent());
    }

    /**
     * This is an alternative way to boot a Weld SE app.
     * <p>
     *     This allows for more control over the configuration.  And also, this is a bit faster.
     * </p>
     */
    public static void main(String[] args) {
        customMainUsed = true;

        /* in this app, auto-discovery is virtually as fast as manually selecting packages. */
        Weld weld = new Weld()
                .disableDiscovery()
                .packages(BootEvent.class);

        WeldContainer container = weld.initialize();

        container.event().select(BootEvent.class).fire( new BootEvent() );

        container.shutdown();
    }
}
