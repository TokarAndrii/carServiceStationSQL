package model;


import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "services")
public class ServiceForClient extends IdEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ServiceTypes serviceTypes;

    @Column(nullable = false)
    private Time timeToDo;

    @Column(nullable = false)
    private Date startDate;

    @Column
    private Date finishDate;

    @Column(nullable = false)
    private long priceOfService;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;


    @Column
    @ManyToMany(mappedBy = "services")
    @JoinTable(name = "clients_workers", joinColumns = @JoinColumn(name = "worker_id"),
            inverseJoinColumns = @JoinColumn(name = "serviceForClient_id"))
    private List<Worker> workers;


    public ServiceForClient() {
    }

    public ServiceForClient(ServiceTypes serviceTypes, Time timeToDo,
                            Date startDate, long priceOfService, Client client) {
        this.serviceTypes = serviceTypes;
        this.timeToDo = timeToDo;
        this.startDate = startDate;
        this.priceOfService = priceOfService;
        this.client = client;
    }

    public ServiceTypes getServiceTypes() {
        return serviceTypes;
    }

    public void setServiceTypes(ServiceTypes serviceTypes) {
        this.serviceTypes = serviceTypes;
    }

    public Time getTimeToDo() {
        return timeToDo;
    }

    public void setTimeToDo(Time timeToDo) {
        this.timeToDo = timeToDo;
    }

    public long getPriceOfService() {
        return priceOfService;
    }

    public void setPriceOfService(long priceOfService) {
        this.priceOfService = priceOfService;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public boolean addWorker(Worker worker) {
        if (worker != null) {
            workers.add(worker);
            return true;
        }
        return false;
    }

    public boolean removeWorker(Worker worker) {
        if (worker != null && workers.contains(worker)) {
            workers.remove(worker);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ServiceForClient{" +
                "serviceTypes=" + serviceTypes +
                ", timeToDo=" + timeToDo +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", priceOfService=" + priceOfService +
                ", client=" + client +
                '}';
    }

}
