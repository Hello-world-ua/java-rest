package com.lena.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.server.ServerProperties;

@javax.ws.rs.ApplicationPath("library")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.lena.rest.BookMessageBodyReader.class);
        resources.add(com.lena.rest.BooksMessageBodyWriter.class);
        resources.add(com.lena.rest.BooksResource.class);
        resources.add(com.lena.rest.Library.class);
    }
    
    @Override
    public Map<String, Object> getProperties() {
        Map<String,Object> properties = new HashMap<String,Object>();
        properties.put(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        return properties;
    }
}
