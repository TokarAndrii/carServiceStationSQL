package listener;

import model.Admin;
import model.WorkerTypes;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.WorkServImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SpringContextInitListener implements ServletContextListener {
    /*private WorkServImpl workServ;*/
    private static final Logger LOGGER = Logger.getLogger(SpringContextInitListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        String spingLocation = servletContext.getInitParameter("spring-context-location");
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(spingLocation);
        servletContext.setAttribute("spring-context", applicationContext);


        WorkServImpl workServ = applicationContext.getBean(WorkServImpl.class);


        String appName = servletContext.getInitParameter("app-url");

        servletContext.setAttribute("APP_NAME", appName);
        LOGGER.trace("start make admin listener");
        Admin admin = applicationContext.getBean(Admin.class);
        LOGGER.trace(admin.toString() + " admin from bean ");


       /* Admin adminInstance=admin.getInstance();*/
        //LOGGER.trace("after unique instance");



       /* String login = admin.getLogin();
        System.out.println(login.toString()+"from listener");
        LOGGER.trace(login.toString() + " it is login of admin");
        String pass = admin.getPassword();
        System.out.println(pass.toString());
        LOGGER.trace(pass.toString() + " it is pass");

        String firstName = admin.getFirstName();
        System.out.println(firstName.toString());
        LOGGER.trace(firstName.toString() + "it is first name");
        String secondName = admin.getSecondName();
        System.out.println(secondName.toString());
        LOGGER.trace(secondName.toString() + " it is secondName");
        long salary = admin.getSalary();
        System.out.println(salary+" it is a salary of admin");

        System.out.println("listener start register admin");



        workServ.register(firstName, secondName, salary, WorkerTypes.ADMINISTRATOR, login, pass);
        LOGGER.info(admin.toString() + " created");
        System.out.println("admin created in listener");*/


        String firstName = applicationContext.getBean(Admin.class).getFirstName();
        String secondName = applicationContext.getBean(Admin.class).getSecondName();
        WorkerTypes workerTypes = applicationContext.getBean(Admin.class).getWorkerTypes();
        long salary = applicationContext.getBean(Admin.class).getSalary();
        String pass = applicationContext.getBean(Admin.class).getPassword();
        String login = applicationContext.getBean(Admin.class).getLogin();
        workServ.register(firstName, secondName, salary, workerTypes, login, pass);
        //workServ.register(firstName, secondName, salary, WorkerTypes.ADMINISTRATOR, login, pass);
        LOGGER.info(admin.toString() + " created");
        System.out.println("admin created in listener");


    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
