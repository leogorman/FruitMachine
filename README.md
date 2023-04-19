# FruitMachine
Fruit Machine full stack application written in Angular + Spring Boot

How to set up and run:
1) Spring Boot Application
   2) Open SpringApp/ as a Spring Boot application
   3) Set project JDK to 17 
   3) Run mvn clean install to install dependencies and build project
   3) Run SpringApp/src/main/java/com/phorest/fruitmachine/FruitmachineApplication.java to start application
   4) Application should now be running on http://localhost:8080/
   5) To run integration tests, navigate to SpringApp/src/test/java/com/phorest/fruitmachine/FruitMachineIntegrationTests.java

2) Angular Application
   3) If you don't have the Angular CLI installed, follow the instructions here - https://angular.io/cli
   4) Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.
   4) Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. You should now be able to spin on the fruit machine and reset if your balance runs out. You should  also see your balance being increased by 1000 if the jackpot is won. 
