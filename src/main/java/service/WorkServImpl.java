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

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class WorkServImpl implements WorkerServ {
    private static final Logger LOGGER = Logger.getLogger(ClientServImpl.class);

    private Map<String, Worker> accessTokenMap = new ConcurrentHashMap<>();

    public static final int ACCESS_TOKEN_LENGHT = 12;

    @Autowired
    private WorkerDaoJPAImpl workerDaoJPA;

    public WorkServImpl() {
    }

    /*  public WorkServImpl() {
        Worker found = null;
        try {
            found = workerDaoJPA.findById(1);
        } catch (NoWorkerFoundException e) {
            e.printStackTrace();
        }
        if (found == null) {
            Admin admin = new Admin("admin", WorkerTypes.ADMINISTRATOR, "firstNameAdm", "secondNameAdm", 10000, "admin");
        }
        else {
            System.out.println("admin exist already in Data Base");
        }

*/


       /* Admin admin;
        Worker administrator = Admin.getInstance();
        if (administrator == null) {
            admin = new Admin();
        }

        Worker worker = workerDaoJPA.findBySecondName(admin.getSecondName());*/


    @Override
    public Worker register(String firstName, String secondName, long salary, WorkerTypes workerTypes,
                           String login, String pass) {
        Worker admin = new Worker(firstName, workerTypes, pass, login, salary, secondName);
        if (workerTypes == WorkerTypes.ADMINISTRATOR) {

            List<Worker> workerList = workerDaoJPA.workersByType(WorkerTypes.ADMINISTRATOR);

            if (workerList.size() != 0 && workerList != null) {
                return workerList.get(0);
            } else {
                String accessToken = StringUtils.generateRandomToken(ACCESS_TOKEN_LENGHT);
                accessTokenMap.put(accessToken, admin);
                return workerDaoJPA.create(admin);
            }

        }

        if (workerTypes != WorkerTypes.ADMINISTRATOR) {

            if (firstName != null && secondName != null && salary != 0 && workerTypes != null & login != null && pass != null) {
                Worker worker = new Worker(firstName, secondName, salary, workerTypes, login, pass);
                String accessToken = StringUtils.generateRandomToken(ACCESS_TOKEN_LENGHT);
                accessTokenMap.put(accessToken, worker);
                return workerDaoJPA.create(worker);
            } else {
                return null;
            }
        }

        return null;

    }


    @Override
    public String login(String login, String pass) {
        Worker worker = workerDaoJPA.findByLogin(login);
        if (worker.getPassword() == pass) ;
        String accessToken = StringUtils.generateRandomToken(ACCESS_TOKEN_LENGHT);

        accessTokenMap.put(accessToken, worker);

        return accessToken;
    }

    @Override
    public Worker update(String firstName, String secondName, long idOfWorker, long salary, String login,
                         WorkerTypes workerTypes, String loginOfAdmin, String passOfAdmin) {
        String acessToken = login(loginOfAdmin, passOfAdmin);
        Worker workerFromMap = accessTokenMap.get(acessToken);
        if (workerFromMap.getWorkerTypes() == WorkerTypes.ADMINISTRATOR) {

            Worker workerUpdated = workerDaoJPA.update(firstName, secondName, salary,
                    workerTypes, idOfWorker, login);
            String accessToken = StringUtils.generateRandomToken(ACCESS_TOKEN_LENGHT);
            accessTokenMap.put(accessToken, workerUpdated);
            return workerUpdated;
        }
        System.out.println("you have no rights to updating worker!!!");
        return null;
    }

    @Override
    public boolean delete(long idWorkerForDeleting, String loginOfAdmin, String passOfAdmin) {
        String accessToken = login(loginOfAdmin, passOfAdmin);
        Worker workerFromMap = accessTokenMap.get(accessToken);
        Worker workerForDeleting = null;
        if (workerFromMap.getWorkerTypes() == WorkerTypes.ADMINISTRATOR) {

            workerForDeleting = workerDaoJPA.findById(idWorkerForDeleting);

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
    public Worker getWorkerById(long workerId) {

        return workerDaoJPA.findById(workerId);
    }

    @Override
    public Worker getWorkerBySecondName(String workerSecondName, String login, String pass) {
        return null;
    }

    @Override
    public List<ServiceForClient> getServicesFromWorker(long workerId, String login, String pass) {
        return null;
    }

    public Worker getWorker(String accessToken) {
        return accessTokenMap.get(accessToken);
    }

   /* @Override
    public Worker registerAdmin(String firstName, String secondName, long salary, WorkerTypes workerTypes, String login, String pass, long id) {
        Worker found = null;
        try {
            found = workerDaoJPA.findById(1);
        } catch (NoWorkerFoundException e) {
            e.printStackTrace();
        }

        if (found == null) {
            if (firstName != null && secondName != null && salary != 0 && workerTypes == WorkerTypes.ADMINISTRATOR && login != null &&
                    pass != null & id != 0) {


                Admin adm = Admin.getInstance();
                adm.setId(1);
                String accessToken = StringUtils.generateRandomToken(ACCESS_TOKEN_LENGHT);

                accessTokenMap.put(accessToken, adm);

                return workerDaoJPA.create(adm);

            }
        }
        return null;
    }*/
}
