package dao;

import exeption.NoServiceTypeFoundException;
import model.Client;
import model.ServiceForClient;
import model.StoreGoodsTypes;
import model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Component("serviceForClientDaoJPA")
public class ServiceForClientDaoJPAImpl implements ServiceForClientDao {

    @Autowired
    private EntityManagerFactory factory;

    public ServiceForClientDaoJPAImpl() {
    }

    public ServiceForClientDaoJPAImpl(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public ServiceForClient start(ServiceForClient serviceForClient, Worker worker, Client client) {


        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        long clientId = client.getId();
        Client client2=manager.find(Client.class, clientId);



        long workerId = worker.getId();
        Worker worker2=manager.find(Worker.class,workerId);

        List<ServiceForClient> serviceForClients = new LinkedList<>();
        serviceForClients.add(serviceForClient);
        worker2.setServiceForClients(serviceForClients);

        List<Client> clientsList = new LinkedList<>();
        clientsList.add(client2);
        worker2.setClientList(clientsList);

        List<Worker> workersList = new LinkedList<>();
        workersList.add(worker2);
        client2.setWorkerList(workersList);

        List<ServiceForClient> forClientList = new LinkedList<>();
        forClientList.add(serviceForClient);
        client2.setServices(forClientList);

        serviceForClient.setWorker(worker2);
        serviceForClient.setClient(client2);





        try {
            transaction.begin();
            manager.merge(client2);
            manager.merge(worker2);

            manager.persist(serviceForClient);
            transaction.commit();
            System.out.println("service for client " + serviceForClient.toString() + " starting!!");
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }


        return serviceForClient;
    }

    @Override
    public ServiceForClient finish(ServiceForClient serviceForClient) {

        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();

            manager.persist(serviceForClient);
            transaction.commit();
            System.out.println("service for client " + serviceForClient.toString() + " finished!!");
        } catch (Exception e) {
            transaction.rollback();
        }


        return serviceForClient;
    }

    @Override
    public List<ServiceForClient> findAll() {
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("SELECT c FROM ServiceForClient c");
        List<ServiceForClient> serviceForClients = query.getResultList();

        return serviceForClients;
    }

    @Override
    public ServiceForClient findByID(long id) throws NoServiceTypeFoundException {

        EntityManager manager = factory.createEntityManager();
        ServiceForClient serviceForClient = manager.find(ServiceForClient.class, id);
        return serviceForClient;
    }

    @Override
    public List<ServiceForClient> findAllFromClient(long clientId) {
        EntityManager manager = factory.createEntityManager();
        Query query =
                manager.createQuery("SELECT '*' FROM ServiceForClient  WHERE Client.id=:clientId");
        List<ServiceForClient> allServicesFromClient = query.getResultList();


        return allServicesFromClient;
    }

    @Override
    public List<ServiceForClient> findAllFromWorker(String workerSecondName) {
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("SELECT '*' FROM ServiceForClient  " +
                "WHERE Worker.secondName=:workerSecondName");

        List<ServiceForClient> servicesFromWorker = query.getResultList();

        return servicesFromWorker;
    }

    @Override
    public List<ServiceForClient> findAllbyTime(Date dateFrom, Date dateTo) {
        return null;
    }

    @Override
    public Long findServicesAmountForTime(Date dateFrom, Date dateTo) {
        return null;
    }

    @Override
    public Long findServicesAmountByClientForTime(long clientId, Date dateFrom, Date dateTo) {
        return null;
    }

    @Override
    public Long findServicecAmountByWorkerForTime(String workerSecondName, Date dateFrom, Date dateTo) {
        return null;
    }


}
