# simplemessaging
Simple messaging application, REST API (Spring Boot) to send and receive a message through Kafka, storing anonymous messages in MySQL

## Requirements
*A Kafka cluster and a topic exclusive to the application
*A MySQL server with the following table created:
```create table messages(id int unsigned auto_increment not null,message varchar(32000) not null,date_created timestamp default now(), primary key (id));```
*JRE 1.8
*Apache Maven

## Install and execution
1. Clone the repository
2. In the simplemessage folder run maven to build and package:
    $ mvm clean package spring-boot:repackage
3. Update file src/main/resources/config.properties with the following information:
    * Kafka server and topic
    * MySQL host, database, user and password
4. Start application
    $ java -jar target\simplemessaging-0.0.1-SNAPSHOT.jar

## Test
Send message (in a msg.json file)
$ curl -X PUT http://localhost:8080/message -d @msg.json -H "Content-Type: application/json"

Read message
$ curl -X GET http://localhost:8080/message

## Sample file
```
{
    "business_id": "1SWheh84yJXfytovILXOAQ",
    "name": "Arizona Biltmore Golf Club",
    "address": "2818 E Camino Acequia Drive",
    "city": "Phoenix",
    "state": "AZ",
    "postal_code": "85016",
    "latitude": 33.5221425,
    "longitude": -112.0184807,
    "stars": 3.0,
    "review_count": 5,
    "is_open": 0,
    "attributes": {
        "GoodForKids": "False"
    },
    "categories": "Golf, Active Life",
    "hours": {
        "Tuesday": "9:0-21:0",
        "Wednesday": "9:0-21:0",
        "Thursday": "9:0-21:0",
        "Friday": "9:0-19:0",
        "Saturday": "9:0-16:0"
    }
}
```
