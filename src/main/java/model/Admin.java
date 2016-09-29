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
