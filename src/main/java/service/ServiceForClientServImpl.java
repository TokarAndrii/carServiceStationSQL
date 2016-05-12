package service;

import dao.ServiceForClientDaoJPAImpl;
import dao.WorkerDao;
import exeption.NoWorkerFoundException;
import model.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import util.StringUtils;

import java.sql.Time;
import java.util.ArrayList;
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

    private ArrayList<Worker> workers;

    private WorkerServ workerServ;


    public static final int ACCESS_TOKEN_LENGHT = 12;

    public ServiceForClientServImpl() {
    }

    /*public ServiceForClientServImpl(WorkerDao workerDao) {
        this.workerDao = workerDao;
    }*/

    @Override
    public ServiceForClient orderService(ServiceTypes serviceTypes, StoreGoodsTypes storeGoodsTypes,
                                         Date startDate, Date finishDate, long priceOfService, Client client, List workersID) {
        if (serviceTypes == null && storeGoodsTypes == null) {
            System.out.println("Enter serviceTypes or storeGoodsTypes, because now all of them null!!!!! ");
            return null;
        } else if (serviceTypes == null && storeGoodsTypes != null) {
            if (workersID != null && workersID.size() != 0) {
                for (int i = 0; i < workersID.size(); i++) {
                    int workerId = (int) workersID.get(i);
                    Worker worker = workerServ.getWorkerById(workerId);
                    workers.add(worker);
                }
                ServiceForClient serviceForClient = new ServiceForClient(storeGoodsTypes,
                        startDate, finishDate, priceOfService, client, workers);
                String randomToken = StringUtils.generateRandomToken(ACCESS_TOKEN_LENGHT);
                accessTokenMap.put(randomToken, serviceForClient);

                serviceForClientDaoJPA.start(serviceForClient);

                return serviceForClientDaoJPA.start(serviceForClient);
            }


        } else if (storeGoodsTypes == null && serviceTypes != null) {
           /* if (workersID != null && workersID.size() != 0) {
                for (int i = 0; i < workersID.size(); i++) {
                    int workerId = (int) workersID.get(i);
                    Worker worker = workerServ.getWorkerById(workerId);
                    workers.add(worker);
                }
            }*/
            ServiceForClient serviceForClient = new ServiceForClient(serviceTypes,
                    startDate, finishDate, priceOfService, client, workers);
            String randomToken = StringUtils.generateRandomToken(ACCESS_TOKEN_LENGHT);
            accessTokenMap.put(randomToken, serviceForClient);
            //serviceForClientDaoJPA.start(serviceForClient);

            LOGGER.info(serviceForClient.toString() +" after start() in ServiceForClientServ");
            return serviceForClientDaoJPA.start(serviceForClient);


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
        return null;
    }

    @Override
    public long totalValueOfSFCforPeriod(Date dateFrom, Date dateTo) {
        return 0;
    }
}
