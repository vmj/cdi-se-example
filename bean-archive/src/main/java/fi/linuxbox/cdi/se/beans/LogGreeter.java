package fi.linuxbox.cdi.se.beans;

import org.slf4j.*;

/**
 * An example implementation of an interface.
 */
public class LogGreeter implements Greeter {
    private final Logger log = LoggerFactory.getLogger(LogGreeter.class);

    @Override
    public void greet() {
        log.info("Hello World!");
    }
}
