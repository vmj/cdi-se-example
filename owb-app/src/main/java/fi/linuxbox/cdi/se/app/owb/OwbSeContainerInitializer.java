package fi.linuxbox.cdi.se.app.owb;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.enterprise.inject.spi.Extension;
import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * OpenWebBeans does not support the CDI 2.0 {@link SeContainerInitializer} and {@link SeContainer}
 * interfaces.
 * <p>
 *     This is a minimal implementation that works for a Hello World app.
 * </p>
 * <p>
 *     An application gets an instance of this class from a static method
 *     {@link SeContainerInitializer#newInstance()}, which is implemented in CDI API and looks for a
 *     META-INF service <code>javax.enterprise.inject.se.SeContainerInitializer</code> (see resources
 *     in this module).
 * </p>
 */
public class OwbSeContainerInitializer extends SeContainerInitializer {

    /*
     * This is the only method that is implemented here.
     * @return
     */
    @Override
    public SeContainer initialize() {
        return new OwbSeContainer();
    }

    /*
     * Rest of these methods just return this.
     *
     * I.e. this implementation does not support any configuration.
     */
    @Override
    public SeContainerInitializer addBeanClasses(Class<?>[] classes) {
        return this;
    }

    @Override
    public SeContainerInitializer addPackages(Class<?>[] packageClasses) {
        return this;
    }

    @Override
    public SeContainerInitializer addPackages(boolean scanRecursively, Class<?>[] packageClasses) {
        return this;
    }

    @Override
    public SeContainerInitializer addPackages(Package... packages) {
        return this;
    }

    @Override
    public SeContainerInitializer addPackages(boolean scanRecursively, Package... packages) {
        return this;
    }

    @Override
    public SeContainerInitializer addExtensions(Extension... extensions) {
        return this;
    }

    @Override
    public SeContainerInitializer addExtensions(Class<? extends Extension>[] extensions) {
        return this;
    }

    @Override
    public SeContainerInitializer enableInterceptors(final Class<?>[] interceptorClasses) {
        return this;
    }

    @Override
    public SeContainerInitializer enableDecorators(final Class<?>[] decoratorClasses) {
        return this;
    }

    @Override
    public SeContainerInitializer selectAlternatives(Class<?>[] alternativeClasses) {
        return this;
    }

    @Override
    public SeContainerInitializer selectAlternativeStereotypes(Class<? extends Annotation>[] alternativeStereotypeClasses) {
        return this;
    }

    @Override
    public SeContainerInitializer addProperty(String key, Object value) {
        return this;
    }

    @Override
    public SeContainerInitializer setProperties(Map<String, Object> properties) {
        return this;
    }

    @Override
    public SeContainerInitializer disableDiscovery() {
        return this;
    }

    @Override
    public SeContainerInitializer setClassLoader(ClassLoader classLoader) {
        return this;
    }
}
