package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client extends IdEntity {
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String secondName;
    @Column(nullable = false)
    private String phoneNumber;
    @Column
    private String email;
    @Column(nullable = false)
    private String driverLicenseNumber;

    @Column
    @OneToMany(mappedBy = "client")
    private List<ServiceForClient> services;

    private String pass;


    public Client() {
    }


    public Client(String firstName, String secondName,
                  String phoneNumber, String email,
                  String driverLicenseNumber, String pass) {

        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.driverLicenseNumber = driverLicenseNumber;
        this.pass = pass;
    }

    public List<ServiceForClient> getServices() {
        return services;
    }

    public void setServices(List<ServiceForClient> services) {
        this.services = services;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setSecondtName(String secondtName) {
        this.secondName = secondtName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {

        this.driverLicenseNumber = driverLicenseNumber;
    }

    public boolean addService(ServiceForClient serviceForClient) {
        if (serviceForClient != null) {
            services.add(serviceForClient);
            return true;
        }
        return false;
    }

    public boolean removeService(ServiceForClient serviceForClient) {
        if (services.contains(serviceForClient) && serviceForClient != null) {
            services.remove(serviceForClient);
            return true;
        }
        return false;
    }

    @Override

    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", secondtName='" + secondName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", driverLicenseNumber='" + driverLicenseNumber + '\'' +
                '}';
    }
}
