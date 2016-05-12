package listener;

import model.Admin;
import model.Worker;
import model.WorkerTypes;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.WorkServImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SpringContextInitListener implements ServletContextListener {
    private WorkServImpl workServ;
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


        String firstName = applicationContext.getBean(Admin.class).getFirstName();
        System.out.println(firstName + " first name in listener");
        String secondName = applicationContext.getBean(Admin.class).getSecondName();
        System.out.println(secondName + " second name in listener");
        WorkerTypes workerTypes = applicationContext.getBean(Admin.class).getWorkerTypes();
        System.out.println(workerTypes + " worker types in listener");
        long salary = applicationContext.getBean(Admin.class).getSalary();
        System.out.println(salary + " salary in listener");
        String pass = applicationContext.getBean(Admin.class).getPassword();
        System.out.println(pass + " pass in listener");
        String login = applicationContext.getBean(Admin.class).getLogin();
        System.out.println(login + " login in listener");
        long id = 1;
        System.out.println(id + " id in listener");
        Worker worker = workServ.register(firstName, secondName, salary, workerTypes, login, pass);
        //System.out.println(worker.toString() + " admin from lisrener");


        //workServ.registerAdmin()


/*

        String firstName = applicationContext.getBean(Admin.class).getFirstName();
        System.out.println(firstName+" first name in listener");
        String secondName = applicationContext.getBean(Admin.class).getSecondName();
        System.out.println(secondName+" second name in listener");
        WorkerTypes workerTypes = applicationContext.getBean(Admin.class).getWorkerTypes();
        System.out.println(workerTypes+" worker types in listener");
        long salary = applicationContext.getBean(Admin.class).getSalary();
        System.out.println(salary+" salary in listener");
        String pass = applicationContext.getBean(Admin.class).getPassword();
        System.out.println(pass+" pass in listener");
        String login = applicationContext.getBean(Admin.class).getLogin();
        System.out.println(login+" login in listener");
        long id = 1;
        System.out.println(id+" id in listener");


        workServ.registerAdmin(firstName,secondName,salary,workerTypes,login,pass,id);
*/
/*
        LOGGER.info(admin.toString() + " created");
        System.out.println("admin created in listener");*/


    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
