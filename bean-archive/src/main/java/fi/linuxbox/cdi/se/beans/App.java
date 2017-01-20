package fi.linuxbox.cdi.se.beans;

import javax.enterprise.event.*;

/**
 * Main entry point to this example.
 * <p>
 *     The {@link Boot} class in this example fires the {@link BootEvent} CDI event
 *     after initializing the container.
 *     This event listener can already use injection (parameter injection in this case).
 * </p>
 */
public class App {
    public void onBootEvent(@Observes BootEvent ignored, MyService service) {
        service.greet();
    }
}
