package fi.linuxbox.cdi.se.beans;

import org.slf4j.*;

/**
 * An example implementation of an interface.
 * <p>
 *     An instance of this class gets injected into {@link MyService} instance field
 *     by the CDI container.
 * </p>
 */
public class LogGreeter implements Greeter {
    private final Logger log = LoggerFactory.getLogger(LogGreeter.class);

    @Override
    public void greet() {
        log.info("Hello World!");
    }
}
