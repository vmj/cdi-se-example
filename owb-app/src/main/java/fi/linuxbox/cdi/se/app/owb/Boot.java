package fi.linuxbox.cdi.se.app.owb;

import fi.linuxbox.cdi.se.beans.*;
import org.apache.webbeans.config.*;
import org.apache.webbeans.spi.*;

/**
 * A simple boot process for OpenWebBeans based Java SE app.
 * <p>
 *     OpenWebBeans is configured with a properties file in <code>META-INF/openwebbeans</code> directory, which is
 *     optional, so there's not much needed in the main method.
 * </p>
 */
public class Boot {
    public static void main(final String[] args) {
        final ContainerLifecycle containerLifecycle = WebBeansContext.currentInstance().getService(ContainerLifecycle.class);

        containerLifecycle.startApplication(null);

        containerLifecycle.getBeanManager().fireEvent(new BootEvent());

        containerLifecycle.stopApplication(null);
    }
}
