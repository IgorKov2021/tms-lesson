package org.example.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext configWebApplicationContext = new AnnotationConfigWebApplicationContext();
        configWebApplicationContext.scan("org.example");

        DispatcherServlet dispatcherServlet = new DispatcherServlet(configWebApplicationContext);
        ServletRegistration.Dynamic dispather = servletContext.addServlet("dispather", dispatcherServlet);
        dispather.setLoadOnStartup(1);
        dispather.addMapping("/");

    }
}
