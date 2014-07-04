package com.todolist.intializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.todolist.config.DatabaseAppConfig;
import com.todolist.config.MailConfig;
import com.todolist.config.WebAppConfig;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		// TODO Auto-generated method stub
		// Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(WebAppConfig.class,DatabaseAppConfig.class,MailConfig.class);

        // Manage the lifecycle of the root application context
        container.addListener(new ContextLoaderListener(rootContext));

        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(WebAppConfig.class);
        
        DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherContext);

        MultipartConfigElement multipartConfigElement = new MultipartConfigElement("/temp", 1024*1024*5, 1024*1024*5, 1024*1024);

        ServletRegistration.Dynamic dispatcher = 
                container.addServlet("dispatcher", dispatcherServlet);
        dispatcher.setMultipartConfig(multipartConfigElement);
            dispatcher.setLoadOnStartup(1);
            dispatcher.addMapping("*.html");
	}
	 


}
