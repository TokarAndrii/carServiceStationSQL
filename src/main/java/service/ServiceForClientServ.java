package service;

import model.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface ServiceForClientServ {

    ServiceForClient orderService(ServiceTypes serviceTypes, StoreGoodsTypes storeGoodsTypes,
                                  Date startDate,Date finishDate, long priceOfService, Client client, List workersId);



    boolean finishService(ServiceForClient serviceForClient, Date dateFinish,long workerId);

    List<ServiceForClient> findAllForPeriod(Date dateFrom, Date dateTo);

    List<ServiceForClient> findAllFromClientForPeriod(Client client,Date dateFrom,Date dateTo);

    List<ServiceForClient> findAllByWorkerForPeriod (Worker worker,Date dateFrom,Date dateTo);

    ServiceForClient findById (long idServiceForClient);

    long totalValueOfSFCforPeriod (Date dateFrom, Date dateTo);


}
