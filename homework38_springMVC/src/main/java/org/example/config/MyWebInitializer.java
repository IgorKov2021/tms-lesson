package org.example.config;

import org.springframework.context.ApplicationContextAware;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.lang.annotation.Annotation;


public class MyWebInitializer implements WebApplicationInitializer {


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext configWebApplicationContext = new AnnotationConfigWebApplicationContext();
        configWebApplicationContext.scan("org.example");

        DispatcherServlet dispatcherServlet = new DispatcherServlet(configWebApplicationContext);
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispather",dispatcherServlet);
        dynamic.setLoadOnStartup(1);
        dynamic.addMapping("/");

    }
}
