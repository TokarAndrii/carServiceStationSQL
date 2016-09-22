DROP DATABASE IF EXISTS tokarServiceStation;
CREATE DATABASE tokarServiceStation;

use tokarServiceStation;
DROP TABLE IF EXISTS clients;
DROP TABLE IF EXISTS workers;
DROP TABLE IF EXISTS services;
DROP TABLE IF EXISTS workers_clients;



CREATE TABLE clients(
id BIGINT AUTO_INCREMENT NOT NULL,
firstName VARCHAR(255) NOT NULL,
secondName VARCHAR(255) NOT NULL,
phoneNumber VARCHAR(10) UNIQUE,
email VARCHAR(255) NOT NULL UNIQUE,
driverLicenseNumber VARCHAR (255) NOT NULL UNIQUE,
pass VARCHAR (255) NOT NULL UNIQUE,
PRIMARY KEY (id)

);

CREATE TABLE workers(
id BIGINT AUTO_INCREMENT NOT NULL,
firstName VARCHAR(255) NOT NULL UNIQUE,
secondName VARCHAR(255) NOT NULL UNIQUE,
salary DOUBLE NOT NULL,
password VARCHAR (255) NOT NULL UNIQUE,
login VARCHAR (255) NOT NULL UNIQUE,
PRIMARY KEY (id),
workerTypes ENUM(MASTER_OF_REPAIR_1_KATEGORY, MASTER_OF_REPAIR_2_KATEGORY, MASTER_OF_REPAIR_3_KATEGORY,
                 WASHER_WORKER,SECRETARY, ADMINISTRATOR)
);

CREATE TABLE workers_clients(
/*id_workersClients BIGINT AUTO_INCREMENT,*/
worker_id BIGINT,
client_id BIGINT,
/*PRIMARY KEY (id_workersClients),*/
FOREIGN KEY (worker_id) REFERENCES workers (id),
FOREIGN KEY (client_id) REFERENCES clients(id)
);

CREATE TABLE services(
service_id BIGINT AUTO_INCREMENT NOT NULL UNIQUE,
serviceTypes ENUM(REPAIR_BODY_CAR, REPAIR_MOTOR, REPAIR_CHASSIS, REPAIR_BRAKE, REPAIR_CLUTCH,
                  REPAIR_GEARBOX, CHANGE_TIRES, CHANGE_CONSUMABLES, DIAGNOSTIC, WASH_CAR_OUTSIDE,
                  WASH_CAR_INSIDE, WASH_TOTAL, WARRANTY_SERVICE, OTRHER_KIND_REPAIRING),
storeGoodTypes ENUM(SPARE_PARTS, CONSUMABLES,SOUVENIRS,   TIRES),

startDate DATETIME,
finishDate DATETIME,
priceOfService DOUBLE NOT NULL,
client_id BIGINT,
FOREIGN KEY (client_id) REFERENCES clients(id),
FOREIGN KEY (worker_id) REFERENCES workers(id),
PRIMARY KEY (service_id)

);

