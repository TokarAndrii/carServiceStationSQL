package service;

import dao.ServiceForClientDaoJPAImpl;
import dao.WorkerDao;
import exeption.NoWorkerFoundException;
import model.Client;
import model.ServiceForClient;
import model.ServiceTypes;
import model.Worker;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import util.StringUtils;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ServiceForClientServImpl implements ServiceForClientServ {
    @Autowired
    private ServiceForClientDaoJPAImpl serviceForClientDaoJPA;

    @Autowired
    private WorkerDao workerDao;

    private static final Logger LOGGER = Logger.getLogger(ServiceForClientServImpl.class);

    private Map<String, ServiceForClient> accessTokenMap = new ConcurrentHashMap<>();

    public static final int ACCESS_TOKEN_LENGHT = 12;

    public ServiceForClientServImpl() {
    }

    /*public ServiceForClientServImpl(WorkerDao workerDao) {
        this.workerDao = workerDao;
    }*/

    @Override
    public ServiceForClient orderService(ServiceTypes serviceTypes, Time timeToDo,
                                             Date startDate, long priceOfService, Client client,long workerId) {

        ServiceForClient serviceForClient = new ServiceForClient(serviceTypes,timeToDo,
                startDate,priceOfService,client);
        String  randomToken=StringUtils.generateRandomToken(ACCESS_TOKEN_LENGHT);
        accessTokenMap.put(randomToken, serviceForClient);

        try {
            Worker worker=workerDao.findById(workerId);
            serviceForClient.addWorker(worker);
        } catch (NoWorkerFoundException e) {
            System.out.println("wrong worker id'");
            e.printStackTrace();
        }
        serviceForClientDaoJPA.start(serviceForClient);

        return serviceForClientDaoJPA.start(serviceForClient);
    }

    @Override
    public boolean finishService(ServiceForClient serviceForClient, Date dateFinish,long workerId) {
        Worker worker = null;
        serviceForClient.setFinishDate(dateFinish);


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
        return null;
    }

    @Override
    public long totalValueOfSFCforPeriod(Date dateFrom, Date dateTo) {
        return 0;
    }
}
