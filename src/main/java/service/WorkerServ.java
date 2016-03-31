package service;

import model.Client;
import model.ServiceForClient;
import model.Worker;
import model.WorkerTypes;

import java.util.List;

public interface WorkerServ {

    Worker register (String firstName, String secondName, long salary, WorkerTypes workerTypes,String login, String pass);

    String login(String login, String pass);

    Worker update(String firstName, String secondName,long idOfWorker,
                  long salary,String login, WorkerTypes workerTypes,String loginOfAdmin,
                  String passOfAdmin);

    boolean delete(long idWorker,String login, String pass);

    ServiceForClient openServiceForClient(long workerId, long clientId,ServiceForClient serviceForClient,
                                          String login, String pass);

    boolean finishServiceForClient(long workerId,long clientId, ServiceForClient serviceForClient);

    List<Worker> findAllworkers (String login, String pass);

    Worker getWorkerById (long workerId,String login, String pass);

    Worker getWorkerBySecondName(String workerSecondName, String login, String pass);

    List<ServiceForClient> getServicesFromWorker (long workerId,String login, String pass);
    
    Worker getWorker(String accessToken);

   // Worker registerAdmin(String firstName, String secondName, long salary, WorkerTypes workerTypes,String login, String pass,long id);
}
