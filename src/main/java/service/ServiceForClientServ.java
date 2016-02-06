package service;

import model.Client;
import model.ServiceForClient;
import model.ServiceTypes;
import model.Worker;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface ServiceForClientServ {

    ServiceForClient orderService(ServiceTypes serviceTypes, Time timeToDo,
                                      Date startDate, long priceOfService, Client client,long workerId);

    boolean finishService(ServiceForClient serviceForClient, Date dateFinish,long workerId);

    List<ServiceForClient> findAllForPeriod(Date dateFrom, Date dateTo);

    List<ServiceForClient> findAllFromClientForPeriod(Client client,Date dateFrom,Date dateTo);

    List<ServiceForClient> findAllByWorkerForPeriod (Worker worker,Date dateFrom,Date dateTo);

    ServiceForClient findById (long idServiceForClient);

    long totalValueOfSFCforPeriod (Date dateFrom, Date dateTo);


}
