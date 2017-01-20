package fi.linuxbox.cdi.se.app.owb;

import org.apache.webbeans.config.WebBeansContext;
import org.apache.webbeans.spi.ContainerLifecycle;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.util.TypeLiteral;
import java.lang.annotation.Annotation;
import java.util.Iterator;

/**
 * OpenWebBeans does not support the CDI 2.0 {@link javax.enterprise.inject.se.SeContainerInitializer}
 * and {@link SeContainer} interfaces.
 * <p>
 *     This is a minimal implementation that works for a Hello World app.
 * </p>
 * <p>
 *     An instance of this class is returned from {@link OwbSeContainerInitializer#initialize()} method.
 * </p>
 * @see OwbSeContainerInitializer
 */
public class OwbSeContainer implements SeContainer {
    private boolean running = true;

    public OwbSeContainer() {
        final ContainerLifecycle service = WebBeansContext.currentInstance().getService(ContainerLifecycle.class);
        service.startApplication(null);
    }

    @Override
    public void close() {
        final ContainerLifecycle service = WebBeansContext.currentInstance().getService(ContainerLifecycle.class);
        service.stopApplication(null);
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public BeanManager getBeanManager() {
        final ContainerLifecycle service = WebBeansContext.currentInstance().getService(ContainerLifecycle.class);
        return service.getBeanManager();
    }

    @Override
    public Instance<Object> select(Annotation... qualifiers) {
        return null;
    }

    @Override
    public boolean isUnsatisfied() {
        return false;
    }

    @Override
    public boolean isAmbiguous() {
        return false;
    }

    @Override
    public void destroy(Object instance) {

    }

    @Override
    public <U extends Object> Instance<U> select(TypeLiteral<U> subtype, Annotation... qualifiers) {
        return null;
    }

    @Override
    public <U extends Object> Instance<U> select(Class<U> subtype, Annotation... qualifiers) {
        return null;
    }

    @Override
    public Iterator<Object> iterator() {
        return null;
    }

    @Override
    public Object get() {
        return null;
    }
}
