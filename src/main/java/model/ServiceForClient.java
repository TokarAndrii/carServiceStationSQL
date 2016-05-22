package model;


import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "services")
public class ServiceForClient extends IdEntity {

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private ServiceTypes serviceTypes;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private StoreGoodsTypes storeGoodsTypes;

    @Column(nullable = false)
    private Date startDate;

    @Column
    private Date finishDate;

    @Column(nullable = false)
    private long priceOfService;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "worker_id", referencedColumnName = "id")
    private Worker worker;


    public ServiceForClient() {
    }


    public ServiceForClient(StoreGoodsTypes storeGoodsTypes, Date startDate, Date finishDate,
                            long priceOfService, Client client, Worker worker) {
        this.storeGoodsTypes = storeGoodsTypes;

        this.startDate = startDate;
        this.finishDate = finishDate;
        this.priceOfService = priceOfService;
        this.client = client;
        this.worker = worker;
    }

    public ServiceForClient(ServiceTypes serviceTypes, Date startDate, Date finishDate, long priceOfService, Client client, Worker worker) {
        this.serviceTypes = serviceTypes;

        this.startDate = startDate;
        this.finishDate = finishDate;
        this.priceOfService = priceOfService;
        this.client = client;
        this.worker = worker;
    }

    public StoreGoodsTypes getStoreGoodsTypes() {
        return storeGoodsTypes;
    }

    public void setStoreGoodsTypes(StoreGoodsTypes storeGoodsTypes) {
        this.storeGoodsTypes = storeGoodsTypes;
    }

    public ServiceTypes getServiceTypes() {
        return serviceTypes;
    }

    public void setServiceTypes(ServiceTypes serviceTypes) {
        this.serviceTypes = serviceTypes;
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

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
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


    @Override
    public String toString() {
        return "ServiceForClient{" +
                "serviceTypes=" + serviceTypes +
                ", storeGoodsTypes=" + storeGoodsTypes +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", priceOfService=" + priceOfService +
                '}';
    }


}
