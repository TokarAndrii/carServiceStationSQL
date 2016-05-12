/*
package model;


import javax.persistence.*;
import java.sql.Time;

@Entity
@Table// TODO fix this class with references
public class WorkDairy extends IdEntity {
    @Column
    private Client clients;// where is ManyToOne it is not just column, this relation
    @Column
    private Worker workers;
    @Column
    private ServiceForClient services;
    @Column
    private Time timeStartService;

    public WorkDairy() {
    }

    public WorkDairy(Client clients, Worker workers, ServiceForClient services, Time timeStartService) {
        this.clients = clients;
        this.workers = workers;
        this.services = services;
        this.timeStartService = timeStartService;
    }

    public Client getClients() {
        return clients;
    }

    public Worker getWorkers() {
        return workers;
    }

    public ServiceForClient getServices() {
        return services;
    }

    public Time getTimeStartService() {
        return timeStartService;
    }


    public void setClients(Client clients) {
        this.clients = clients;
    }

    public void setWorkers(Worker workers) {
        this.workers = workers;
    }

    public void setServices(ServiceForClient services) {
        this.services = services;
    }

    public void setTimeStartService(Time timeStartService) {
        this.timeStartService = timeStartService;
    }
}
*/
