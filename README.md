# Read Me First

### Pre-requisites

* Docker
* Java version 13

### Steps to run the application
Please follow the following instructions carefully to run this MicroService:
* First run the instance of Postgresql db through Docker , if It's not already running.
````
docker run --name tgDb -p 5432:5432 -e POSTGRES_DB=tarabut -e POSTGRES_PASSWORD=tarabut123 -d postgres
````
* As you have cloned this project, go to the root directory of this project.
* Firstly clean the project, using the command:
   ````
  ./gradlew clean
  ````
* Now build the project using the below command, it will compile the code, run the junit tests and  create the jar in the folder build/libs/
  ````
  ./gradlew build
  ````
  
* Create the Docker image based on the Dockerfile placed in the root of project
  ````
  docker build -t tg-createupdate .
  ````
* Run the application by running the Docker image created in the previous step.
  ````
  docker run -p 8090:8080 tg-createupdate
  ````
  It will start the applicantion at port 8080. 

# Sample Request and Response

### Request
* ### Create Customer
````
curl --location --request POST 'http://localhost:8080/customer' \
--header 'Content-Type: application/stream+json' \
--data-raw '{ 
  "customerName":"anku3r",
  "userName":"ankur8889",
  "marketingPreference":"SMS"
}'
````
If successful it will give HTTP status 201 else it will give 500.

* ### Update Customer
  #### Request
 ````
 curl --location --request PATCH 'http://localhost:8080/customer/ankur8889' \
--header 'Content-Type: application/stream+json' \
--data-raw '{ 
  "customerName":"Mukule11",
  "userName":"ankur8889",
  "marketingPreference":"EMAIL"
}'
````
If successful it will give HTTP status 204 else it will give 400, if customer does not exist.


# Technologies Used
* Java 13
* Spring Boot
* Postgresql
* REST APIs
* Junit5
* Entity created in DB:  Customer
