package model;

import javax.persistence.*;
import java.util.List;
//TO DO enum types of workers

@Entity
@Table(name = "workers")
public class Worker  extends IdEntity {
    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String secondName;

    @Column(nullable = false)
    private long salary;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private WorkerTypes workerTypes;


    @OneToMany(mappedBy = "worker", fetch = FetchType.EAGER)
    private List<ServiceForClient> serviceForClients;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "workers_clients",
            joinColumns = {@JoinColumn(name = "worker_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "client_id", referencedColumnName = "id")})
    private List<Client> clientList;


    public Worker() {
    }

    public Worker(String firstName, String secondName, long salary, WorkerTypes workerTypes,String login,
                  String password) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.salary = salary;
        this.workerTypes = workerTypes;
        this.login=login;
        this.password=password;
    }

    public Worker(String firstName,  WorkerTypes workerTypes, String password, String login, long salary,
                  String secondName) {
        this.firstName = firstName;
        this.serviceForClients = serviceForClients;
        this.workerTypes = workerTypes;
        this.password = password;
        this.login = login;
        this.salary = salary;
        this.secondName = secondName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public WorkerTypes getWorkerTypes() {
        return workerTypes;
    }

    public void setWorkerTypes(WorkerTypes workerTypes) {
        this.workerTypes = workerTypes;
    }

    public List<ServiceForClient> getServiceForClients() {
        return serviceForClients;
    }

    public void setServiceForClients(List<ServiceForClient> serviceForClients) {
        this.serviceForClients = serviceForClients;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", salary=" + salary +
                ", workerTypes=" + workerTypes +
                '}';
    }



}
