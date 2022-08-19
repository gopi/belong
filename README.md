# belong provider - implementations for those API to get Phone Numbers

## Service Overview
We are a Telecom operator. In our database, we are starting to store phone numbers associated
to customers (1 customer : N phone numbers) and we will provide interfaces to manage them.
We need to provide the below capabilities:
 - get all phone numbers
 - get all phone numbers of a single customer
 - Activate a phone number

## API will be used to for following endpoints:

- get all phone numbers
- get all phone numbers of a single customer
- activate a phone number

## Installation / Local Development

The app relies on the following to run:

- REST
- Spring Boot
- Maven
- Java 8
- Swagger
- Lombok


setup:

- Install and mange locally on your machine

### To Run from the Command line

```maven commands
### To build
mvn clean install

### To Run test cases
mvn test

```
Swagger-url
http://localhost:8080/swagger-ui.html#