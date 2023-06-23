package com.am.preguntas_backend;

import com.am.preguntas_backend.resources.Clientes;
import com.am.preguntas_backend.resources.Preguntas;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Configures Jakarta RESTful Web Services for the application.
 * @author Juneau
 */
@ApplicationPath("api")
public class JakartaRestConfiguration extends Application {
        @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> classes = new HashSet<>();
        classes.add(Clientes.class); 
        return classes;
    }     
}
