package dao;

import exeption.NoClientFoundException;
import exeption.NoWorkerFoundException;
import model.ServiceForClient;
import model.Worker;
import model.WorkerTypes;

import java.util.List;

public interface WorkerDao {


    Worker create(Worker worker);

    Worker update(String firstName,String secondName,long salary,WorkerTypes workerTypes, long id,String login);

    List<Worker> findAll();

    Worker findById(long id) throws NoWorkerFoundException;

    Worker findByLogin (String login);

    Worker findBySecondName(String secondName)
            throws NoWorkerFoundException;

    boolean delete(Worker worker);

    List<Worker> workersByType(WorkerTypes workerType);

    List<ServiceForClient> findServiceForClientsFromWorker (String workersSecondName);



}
