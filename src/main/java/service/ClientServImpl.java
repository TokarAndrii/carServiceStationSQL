package service;

import dao.ClientDaoJPAImpl;
/*import dao.WorkerDao;*/
import exeption.NoClientFoundException;
import model.Client;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import util.StringUtils;
import validator.Validator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ClientServImpl implements ClientServ {
    private static final Logger LOGGER = Logger.getLogger(ClientServImpl.class);

    private Map<String, Client> accessTokenMap = new ConcurrentHashMap<>();
    public static final int ACCESS_TOKEN_LENGHT = 12;

    @Autowired
    private ClientDaoJPAImpl clientDaoJPA;

   /* private WorkerDao workerDao;*/

    private Client client;


    private Validator<Client> clientValidator;

    public ClientServImpl() {
    }

    public ClientServImpl(/*WorkerDao workerDao,*/ Validator<Client> clientValidator) {
        /*this.workerDao = workerDao;*/
        this.clientValidator = clientValidator;
    }

    @Override
    public Client register(String firstName, String secondName, String phoneNumber,
                           String email, String driverLicenseNumber, String pass) {
        if(firstName!=null&secondName!=null&phoneNumber!=null&driverLicenseNumber!=null&pass!=null){
            Client client = new Client(firstName, secondName, phoneNumber,
                    email, driverLicenseNumber, pass);
            LOGGER.info("Client made "+client);

            String accessToken = StringUtils.generateRandomToken(ACCESS_TOKEN_LENGHT);

            accessTokenMap.put(accessToken, client);

            return clientDaoJPA.create(client);
        }
        LOGGER.info("client dont made!!!");
        return null;
    }


    public String login(String email, String pass, String driverLicenseNumber) {
        try {
            client = clientDaoJPA.findByEmail(email);
        } catch (NoClientFoundException e) {
            e.printStackTrace();
        }

        if (!pass.equals(client.getPass()) &&
                !driverLicenseNumber.equals(client.getDriverLicenseNumber())) {
            //System.out.println("wrong pass,email or driverlicense number!!!");
            LOGGER.info("wrong pass,email or driverlicense number!!!");
            return null;
        } else {
            String accessToken = StringUtils.generateRandomToken(ACCESS_TOKEN_LENGHT);
            accessTokenMap.put(accessToken, client);
            LOGGER.info("Client "+client+" in system!!1");

            return accessToken;
        }
    }

    @Override
    public Client update(String phoneNumber, String email, String driverLicenseNumber, String pass) {
        String accessToken = login(email, pass, driverLicenseNumber);

        Client client = accessTokenMap.get(accessToken);

        long id = client.getId();


        clientDaoJPA.update(email, pass, driverLicenseNumber,
                phoneNumber, id);
        LOGGER.info("Client " +client+" updated!!!");

        return client;
    }

    @Override
    public boolean delete(String email, String pass, String driverLicenseNumber) {

        String accessToken = login(email, pass, driverLicenseNumber);

        Client client = accessTokenMap.get(accessToken);


        clientDaoJPA.delete(client);
        //System.out.println("client deleted (info from clientServ)!!!");
        LOGGER.info("Client "+client+" deleted!!!");


        return true;
    }

    @Override
    public Client getClient(String accessToken) {

        return accessTokenMap.get(accessToken);
    }

    @Override
    public Client getClient(long id) {

        Client found = null;

        try {
           found= clientDaoJPA.findById(id);
        } catch (NoClientFoundException e) {
            e.printStackTrace();
        }

        LOGGER.info("Client "+found+" found!!");
        return found;
    }
}

