package fi.linuxbox.cdi.se.beans;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

/**
 * CDI 2.0 standardized how the CDI container is bootstrapped.
 * <p>
 *     The main function used to be container specific, but now it can be shared.
 * </p>
 * <p>
 *     This main-function brings up the CDI container, and then fires a
 *     CDI event for the {@link App} class.  The event is synchronous.
 *     When the <code>fireEvent</code> function returns, the container is closed
 *     and the application exits.
 * </p>
 */
public class Boot {
    public static void main(final String[] args) {
        // newInstance() looks up a META-INF service that implements the SeContainerInitializer
        // interface and loads that.  There can only be one.
        SeContainer seContainer = SeContainerInitializer.newInstance().initialize();

        // Fire synchronous event that triggers the code in App class.
        seContainer.getBeanManager().fireEvent(new BootEvent());

        seContainer.close();
    }
}
