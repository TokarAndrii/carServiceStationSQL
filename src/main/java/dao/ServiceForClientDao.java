package dao;

import exeption.NoServiceTypeFoundException;
import model.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface ServiceForClientDao {

    ServiceForClient start(ServiceForClient serviceForClient, Worker worker, Client client);


    ServiceForClient finish(ServiceForClient serviceForClient);

    List<ServiceForClient> findAll();

    ServiceForClient findByID(long id) throws NoServiceTypeFoundException;

    List<ServiceForClient> findAllFromClient(long clientId);

    List<ServiceForClient> findAllFromWorker(String workerSecondName);

    List<ServiceForClient> findAllbyTime(Date dateFrom, Date dateTo);

    Long findServicesAmountForTime(Date dateFrom, Date dateTo);

    Long findServicesAmountByClientForTime(long clientId, Date dateFrom, Date dateTo);

    Long findServicecAmountByWorkerForTime(String workerSecondName, Date dateFrom, Date dateTo);

    ServiceForClient update(long idSFCtoBeUpdated, ServiceTypes serviceTypes, StoreGoodsTypes storeGoodsTypes, Date startDate,
                   Date finishDate, long priceOfService, Worker newWorker);
}
