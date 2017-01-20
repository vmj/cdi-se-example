package fi.linuxbox.cdi.se.beans;

import javax.inject.*;

/**
 * An example class that uses field injection with an interface.
 * <p>
 *     An instance of this class gets injected into {@link App#onBootEvent(BootEvent, MyService)}
 *     event listener method by the CDI container.
 * </p>
 * @see LogGreeter
 */
public class MyService {
    @Inject
    private Greeter greeter;

    public void greet()
    {
        greeter.greet();
    }
}
