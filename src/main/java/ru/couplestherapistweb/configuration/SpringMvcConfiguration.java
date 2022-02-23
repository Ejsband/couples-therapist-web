package ru.couplestherapistweb.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.ContentVersionStrategy;
import org.springframework.web.servlet.resource.VersionResourceResolver;

@EnableWebMvc
@Configuration
@PropertySource("classpath:web.properties")
public class SpringMvcConfiguration implements WebMvcConfigurer {

    @Value( "${pathPattern}" )
    private String pathPattern;

    @Value( "${resourceHandler}" )
    private String resourceHandler;

    @Value( "${resourceLocation}" )
    private String resourceLocation;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        VersionResourceResolver versionResourceResolver = new VersionResourceResolver();
        versionResourceResolver.addVersionStrategy(new ContentVersionStrategy(), pathPattern);
        registry.addResourceHandler(resourceHandler).addResourceLocations(resourceLocation);

    }
}
