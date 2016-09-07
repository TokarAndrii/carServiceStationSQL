package service;

import dao.ServiceForClientDaoJPAImpl;
import dao.WorkerDao;
import exeption.NoServiceTypeFoundException;
import exeption.NoWorkerFoundException;
import model.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import util.StringUtils;

import java.sql.Time;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ServiceForClientServImpl implements ServiceForClientServ {
    @Autowired
    private ServiceForClientDaoJPAImpl serviceForClientDaoJPA;

    @Autowired
    private WorkerDao workerDao;

    private static final Logger LOGGER = Logger.getLogger(ServiceForClientServImpl.class);

    private Map<String, ServiceForClient> accessTokenMap = new ConcurrentHashMap<>();


    private Worker worker;

    private WorkerServ workerServ;

    private Client client;

    private ClientServ clientServ;


    public static final int ACCESS_TOKEN_LENGHT = 12;

    public ServiceForClientServImpl() {
    }

    private ServiceForClient serviceForClient = null;

    @Override
    public ServiceForClient orderService(ServiceTypes serviceTypes, StoreGoodsTypes storeGoodsTypes, Date startDate,
                                         Date finishDate, long priceOfService, Client client, Worker worker) {


        if (serviceTypes == null && storeGoodsTypes == null) {

            LOGGER.info("Enter serviceTypes or storeGoodsTypes, because now all of them are null!!!!! ");
            return null;
        } else if (serviceTypes == null && storeGoodsTypes != null) {

            ServiceForClient serviceForClient = new ServiceForClient(storeGoodsTypes,

                    startDate, finishDate, priceOfService, client, worker);

            return serviceForClientDaoJPA.start(serviceForClient, worker, client);


        } else if (storeGoodsTypes == null && serviceTypes != null) {

            ServiceForClient serviceForClient = new ServiceForClient(serviceTypes,
                    startDate, finishDate, priceOfService, client, worker);


            return serviceForClientDaoJPA.start(serviceForClient, worker, client);


        }

        LOGGER.info("serviceTypes and storeGoodsTypes both have values, choose just one of them!!!");
        return null;
    }

    @Override
    public boolean finishService(ServiceForClient serviceForClient, Date dateFinish, long workerId) {
        return false;
    }

    @Override
    public List<ServiceForClient> findAllForPeriod(Date dateFrom, Date dateTo) {
        return null;
    }

    @Override
    public List<ServiceForClient> findAllFromClientForPeriod(Client client, Date dateFrom, Date dateTo) {
        return null;
    }

    @Override
    public List<ServiceForClient> findAllByWorkerForPeriod(Worker worker, Date dateFrom, Date dateTo) {
        return null;
    }

    @Override
    public ServiceForClient findById(long idServiceForClient) {

        ServiceForClient found = null;

        try {
            found = serviceForClientDaoJPA.findByID(idServiceForClient);
        } catch (NoServiceTypeFoundException e) {
            e.printStackTrace();
        }


        LOGGER.info("Service for client with id =" + idServiceForClient + " found!!! " + found.toString());
        return found;
    }

    @Override
    public long totalValueOfSFCforPeriod(Date dateFrom, Date dateTo) {
        return 0;
    }


    @Override
    public boolean addRelatives(Worker worker, Client client, ServiceForClient serviceForClient) {
        List<ServiceForClient> serviceForClients = new LinkedList<>();
        serviceForClients.add(serviceForClient);
        worker.setServiceForClients(serviceForClients);

        List<Client> clientList = new LinkedList<>();
        clientList.add(client);
        worker.setClientList(clientList);

        List<Worker> workerList = new LinkedList<>();
        workerList.add(worker);
        client.setWorkerList(workerList);

        List<ServiceForClient> forClientList = new LinkedList<>();
        forClientList.add(serviceForClient);
        client.setServices(forClientList);

        serviceForClient.setWorker(worker);
        serviceForClient.setClient(client);


        return false;
    }

    @Override
    public ServiceForClient updateServiceForClient(ServiceTypes serviceTypes, StoreGoodsTypes storeGoodsTypes,
                                                   Date startDate, Date finishDate, long priceOfService, Worker worker) {
        return null;
    }
}
