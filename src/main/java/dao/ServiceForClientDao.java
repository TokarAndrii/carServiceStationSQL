package dao;

import exeption.NoServiceTypeFoundException;
import model.Client;
import model.ServiceForClient;
import model.Worker;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface ServiceForClientDao {

    ServiceForClient start(ServiceForClient serviceForClient);

    ServiceForClient finish(ServiceForClient serviceForClient);
    List<ServiceForClient>  findAll();

    ServiceForClient findByID(long id) throws NoServiceTypeFoundException;

    List<ServiceForClient> findAllFromClient(long clientId);

    List<ServiceForClient> findAllFromWorker(String workerSecondName);

    List<ServiceForClient> findAllbyTime (Date dateFrom, Date dateTo);

    Long findServicesAmountForTime (Date dateFrom, Date dateTo);

    Long findServicesAmountByClientForTime (long clientId, Date dateFrom, Date dateTo);

    Long findServicecAmountByWorkerForTime (String workerSecondName, Date dateFrom, Date dateTo);

}
