package listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by tokarAndrii on 11.01.16.
 */
public class SpringContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        String springLocation = servletContext.getInitParameter("spring-context-location");
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(springLocation);
        servletContext.setAttribute("spring-context", applicationContext);
        String appName = servletContext.getInitParameter("app-url");
        servletContext.setAttribute("APP_NAME", appName);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
