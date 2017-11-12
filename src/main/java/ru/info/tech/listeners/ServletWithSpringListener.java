package ru.info.tech.listeners;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Sulaymon on 15.10.2017.
 */
public class ServletWithSpringListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("context/context.xml");
        servletContextEvent.getServletContext().setAttribute("context", context);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
