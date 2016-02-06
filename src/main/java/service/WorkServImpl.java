package service;

import dao.WorkerDaoJPAImpl;
import exeption.NoWorkerFoundException;
import model.Admin;
import model.ServiceForClient;
import model.Worker;
import model.WorkerTypes;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class WorkServImpl implements WorkerServ {
    private static final Logger LOGGER = Logger.getLogger(ClientServImpl.class);

    private Map<String, Worker> accessWorkerTokenMap = new ConcurrentHashMap<>();

    public static final int ACCESS_TOKEN_LENGHT = 12;

    @Autowired
    private WorkerDaoJPAImpl workerDaoJPA;


    public WorkServImpl() {
        Worker administrator = Admin.getUniqueinstance();
    }


    @Override
    public Worker register(String firstName, String secondName, long salary, WorkerTypes workerTypes,
                           String login, String pass) {
        String acessToken = login(login, pass);
        Worker worker = accessWorkerTokenMap.get(acessToken);
        if (worker.getWorkerTypes() == WorkerTypes.ADMINISTRATOR) {
            System.out.println("starting registration of worker");
            LOGGER.info("starting registration of worker"+worker.toString());
            Worker newWorker = new Worker(firstName, secondName, salary, workerTypes);

            String randomToken = StringUtils.generateRandomToken(ACCESS_TOKEN_LENGHT);
            accessWorkerTokenMap.put(randomToken, newWorker);
            return workerDaoJPA.create(newWorker);

        } else {
            System.out.println("you have no rights to registering worker!!!");
            return null;
        }
    }

    @Override
    public String login(String login, String pass) {
        Worker worker = workerDaoJPA.findByLogin(login);
        if (worker.getPassword() == pass) ;
        String randomToken = StringUtils.generateRandomToken(ACCESS_TOKEN_LENGHT);

        accessWorkerTokenMap.put(randomToken, worker);

        return randomToken;
    }

    @Override
    public Worker update(String firstName, String secondName,long idOfWorker, long salary,String login,
                         WorkerTypes workerTypes, String loginOfAdmin, String passOfAdmin) {
        String  acessToken=login(loginOfAdmin,passOfAdmin);
        Worker workerFromMap=accessWorkerTokenMap.get(acessToken);
        if (workerFromMap.getWorkerTypes()==WorkerTypes.ADMINISTRATOR) {

            Worker workerUpdated = workerDaoJPA.update(firstName, secondName, salary,
                    workerTypes, idOfWorker, login);
            String randomToken = StringUtils.generateRandomToken(ACCESS_TOKEN_LENGHT);
            accessWorkerTokenMap.put(randomToken,workerUpdated);
            return workerUpdated;
        }
        System.out.println("you have no rights to updating worker!!!");
        return null;
    }

    @Override
    public boolean delete(long idWorkerForDeleting, String loginOfAdmin, String passOfAdmin) {
        String  acessToken=login(loginOfAdmin,passOfAdmin);
        Worker workerFromMap=accessWorkerTokenMap.get(acessToken);
        Worker workerForDeleting = null;
        if (workerFromMap.getWorkerTypes()==WorkerTypes.ADMINISTRATOR){
            try {
                workerForDeleting = workerDaoJPA.findById(idWorkerForDeleting);
            } catch (NoWorkerFoundException e) {
                e.printStackTrace();
            }
            workerDaoJPA.delete(workerForDeleting);
            return true;
        }

        System.out.println("you have no rights to deleting worker!!!");

        return false;
    }

    @Override
    public ServiceForClient openServiceForClient(long workerId, long clientId, ServiceForClient serviceForClient, String login, String pass) {
        return null;
    }

    @Override
    public boolean finishServiceForClient(long workerId, long clientId, ServiceForClient serviceForClient) {
        return false;
    }

    @Override
    public List<Worker> findAllworkers(String login, String pass) {
        return null;
    }

    @Override
    public Worker getWorkerById(long workerId, String login, String pass) {
        return null;
    }

    @Override
    public Worker getWorkerBySecondName(String workerSecondName, String login, String pass) {
        return null;
    }

    @Override
    public List<ServiceForClient> getServicesFromWorker(long workerId, String login, String pass) {
        return null;
    }
}
