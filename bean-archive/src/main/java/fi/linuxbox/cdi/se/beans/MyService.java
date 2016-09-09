package fi.linuxbox.cdi.se.beans;

import javax.inject.*;

/**
 * An example class that uses field injection with an interface.
 */
public class MyService {
    @Inject
    private Greeter greeter;

    public void greet()
    {
        greeter.greet();
    }
}
