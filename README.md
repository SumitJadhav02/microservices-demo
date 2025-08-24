# microservices-demo
Spring Boot Microservices: Eureka + Feign + JPA

# Spring Boot Microservices: Eureka + Feign + JPA

A small microservices system:
- **Service Registry (Eureka)** – service discovery (:8761)
- **User Service** – CRUD + aggregates Ratings & Hotels via Feign (:8081)
- **Hotel Service** – CRUD (:8082)
- **Rating Service** – CRUD (:8083)

## Tech
Spring Boot, Spring Cloud Netflix (Eureka), OpenFeign, Spring Data JPA, MySQL (or H2), Lombok.

## Architecture

flowchart LR
  Client --> UserService
  subgraph Discovery
    Eureka[Eureka Server]
  end
  UserService <--Feign--> RatingService
  UserService <--Feign--> HotelService
  UserService --- Eureka
  RatingService --- Eureka
  HotelService --- Eureka



Run locally

Start Eureka (service-registry) first → open http://localhost:8761/.

Start Hotel Service (:8082)

Start Rating Service (:8083)

Start User Service (:8081)

Copy application.properties.example to application.properties in each service and set your DB creds/ports.

Sample endpoints

Eureka Dashboard: GET http://localhost:8761/

User Service:

POST http://localhost:8081/users

GET http://localhost:8081/users

GET http://localhost:8081/users/{userId}

GET http://localhost:8081/users/{userId}/ratings

PUT http://localhost:8081/users/{userId}

DELETE http://localhost:8081/users/{userId}

Hotel Service:

GET http://localhost:8082/hotels

GET http://localhost:8082/hotels/{hotelId}

Rating Service:

GET http://localhost:8083/ratings

GET http://localhost:8083/ratings/users/{userId}

![Ureka Registry](https://github.com/user-attachments/assets/1c53cb37-4c58-4fb3-a89f-a5be38814641)

