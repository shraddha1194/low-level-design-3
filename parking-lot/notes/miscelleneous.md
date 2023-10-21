#### Controllers
#### Services
Ideally service call should be singleton.

#### Dependency Injection in Spring
Problem - when calling different layers - How do we provide instance od one class to another class.
Controller uses Services, Services uses Repository

Spring apart from being web framework is also an IOC.
IOC - it will provide your dependencies

##### How it happens?

* Spring will create objects of classes with no dependency ex. repository
* It then creates Service object and inject Repository to it
* then at last controller

This whole process is called IOC (inversion of control) or Dependency Injection.

##### How does Spring know which object to create?
* Through component scanning - Tell spring what which classes we need to create object. Annotate with @Component.
* @RestController, @Service, @Repository all are extension of @Component
* In spring all objects are singleton unless specified

##### How Spring does injection?
There are three ways:
* Constructor Injection: Spring checks service constructor and finds Repository object ex. Service(Repository repo). Then spring will inject the object of the repository it created to this service class.
* Setter Injection: A a = new A(), a.set(B) - spring will automatically invoke the set method
* Autowired and Setter Injections are not preferred - because they are mutable, constructor injection is preferred since it creates immutable injections 
https://www.baeldung.com/mapstruct
