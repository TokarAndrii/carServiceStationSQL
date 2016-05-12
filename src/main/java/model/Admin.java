package model;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;

@Component
@Entity
public class Admin extends Worker {
    private static final Logger LOGGER = Logger.getLogger(Admin.class);


    //private volatile static Admin uniqueinstance;

    @Column(insertable = false, updatable = false)
    private String password;

    @Column(insertable = false, updatable = false)
    private WorkerTypes workerTypes;

    @Column(insertable = false, updatable = false)
    private String firstName;

    @Column(insertable = false, updatable = false)
    private String secondName;

    @Column(insertable = false, updatable = false)
    private long salary;

    @Column(insertable = false, updatable = false)
    private String login;

    public Admin() {
    }

  /*  public Admin(String password, WorkerTypes workerTypes, String firstName, String secondName, long salary, String login) {
        this.password = password;
        this.workerTypes = workerTypes;
        this.firstName = firstName;
        this.secondName = secondName;
        this.salary = salary;
        this.login = login;
        setId(1);
    }*/

   /* public Admin(String firstName, String secondName,long salary) {
        LOGGER.trace("inside admin constructor");
        System.out.println("inside admin constructor");

        workerTypes = WorkerTypes.ADMINISTRATOR;
        System.out.println(workerTypes.toString()+" worker types inside admin constructor");
        firstName = "testAdminFirstName";
        System.out.println(firstName.toString()+" first name inside admin constructor");
        secondName = "testAdminSecondName";
        System.out.println(secondName.toString()+" second name inside admin constructor");
        password = "admin";
        System.out.println(password.toString()+" pass inside admin constructor");
        login = "admin";
        System.out.println(login.toString()+" login inside admin constructor");
        salary = 10000;
        System.out.println(salary+" slalry inside admin constructor");
    }
*/

    /*public static Admin getInstance() {
        if (uniqueinstance == null) {
            synchronized (Admin.class) {
                if (uniqueinstance == null) {
                    uniqueinstance = new Admin();
                    System.out.println("create new Admin");
                    LOGGER.trace("inside getUniqueInstance method");
                }
            }
        }
        return uniqueinstance;
    }*/

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public WorkerTypes getWorkerTypes() {
        return workerTypes;
    }

    @Override
    public void setWorkerTypes(WorkerTypes workerTypes) {
        this.workerTypes = workerTypes;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getSecondName() {
        return secondName;
    }

    @Override
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public long getSalary() {
        return salary;
    }

    @Override
    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "password='" + password + '\'' +
                ", workerTypes=" + workerTypes +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", salary=" + salary +
                ", login='" + login + '\'' +
                '}';
    }
}
