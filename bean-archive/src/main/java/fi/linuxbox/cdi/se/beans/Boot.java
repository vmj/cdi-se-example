package fi.linuxbox.cdi.se.beans;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

/**
 * CDI 2.0 standardized the how the CDI container is bootstrapped.
 * <p>
 *     The main function used to be container specific, but now it can be shared.
 * </p>
 */
public class Boot {
    public static void main(final String[] args) {
        SeContainer seContainer = SeContainerInitializer.newInstance().initialize();

        seContainer.getBeanManager().fireEvent(new BootEvent());

        seContainer.close();
    }
}
