package com.apis.rest.test.common;

import com.sun.jersey.api.core.ClassNamesResourceConfig;
import com.sun.jersey.spi.container.servlet.WebComponent;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import com.sun.jersey.test.framework.spi.container.TestContainerFactory;
import com.sun.jersey.test.framework.spi.container.grizzly2.web.GrizzlyWebTestContainerFactory;

/**
 * @author SLA
 * @version 1.0
 */
public abstract class AcceptanceTest extends JerseyTest {

    @Override
    protected WebAppDescriptor configure() {
        return new WebAppDescriptor.Builder()
                .initParam(WebComponent.RESOURCE_CONFIG_CLASS,ClassNamesResourceConfig.class.getName())
                .initParam(ClassNamesResourceConfig.PROPERTY_CLASSNAMES,getResources()).build();
    }

    @Override
    public TestContainerFactory getTestContainerFactory() {
        return new GrizzlyWebTestContainerFactory();
    }

    protected abstract String getResources();

}
