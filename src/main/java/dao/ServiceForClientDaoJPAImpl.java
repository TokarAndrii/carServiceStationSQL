package dao;

import exeption.NoServiceTypeFoundException;
import model.ServiceForClient;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class ServiceForClientDaoJPAImpl implements ServiceForClientDao {

    @Autowired
    private EntityManagerFactory factory;

    public ServiceForClientDaoJPAImpl() {
    }

    public ServiceForClientDaoJPAImpl(EntityManagerFactory factory){
        this.factory=factory;
    }

    @Override
    public ServiceForClient start(ServiceForClient serviceForClient) {

        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(serviceForClient);
            transaction.commit();
            System.out.println("service for client " + serviceForClient.toString() + " starting!!");
        } catch (Exception e) {
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
