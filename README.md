# Opinionated Java Spring template
This repo holds two small projects, a service discovery and a generic REST microservice.
The service discovery is a simple Eureka server which allows to the microservice client to talk to other microservices without knowing the real URL. Look a the other features the microservice offers out of the box.

# Usage
Import the two projects and run boot. Import the postman collection into postman and from there you can ping the APIs.

# Features
* Spring MVC with annotations
* Basic data persistence
* In Mem database for development (Apache Derby)
* Postman collection
* Load balancing/Sevice discovery - Handled by Eureka (https://spring.io/guides/gs/service-registration-and-discovery/)
* Fault tollerance/Resilience [TODO] - Circuit breaker/ Hystrix (https://spring.io/guides/gs/circuit-breaker/) https://dzone.com/articles/libraries-for-microservices-development
* Security [TODO]
* Tests [TODO]
* Exceptions handing [TODO]
* Docker [TODO]
* Travis CI [TODO]
