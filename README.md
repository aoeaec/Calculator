# Calculator
Calculator application with backend in Spring boot and Front end in Angular4


________About the software__________ 

This software is constitutes of a backend and a frontend module. Backend module is written in Java ( Spring Boot ) and requires a user to Install a latest version of JDK and minimum jdk version required is jdk 1.8. 
The front end is developed in Angular4. The build tool Maven 3.0.5.

_Pre-requisites_ 

1 - Minimum version JDK 1.8(if you don't have JDK then get the latest version from the Oracle site) 
2 - 128 MB RAM 
3 - Pentium IV CPU (Now-a-days its an old age processor you don't need to worry about it.) 
4 - Minimum version of Maven required is 3.0.5. This could be found on Apache Maven website.
5 - No need to install Node, NPM or Angular. It will be installed as build process

____Features____ 
1 - Works on Mac, Windows and Linux.(Tested and ran successfully) 
2 - Simplistic, easy to install using Maven build tool.
3 - Cross Platform software(as shown in above) 
4 - Shows the process output in the console area. 
5 - Its a free software (I'm releasing it under Creative Commons Attribution-NonCommercial 4.0 International License.) 

__Installation__



Step 1 : Start backend Server.

From the top level directory of our project, run:
1. mvn clean install
	Step 1 will build the project, download all dependencies for backend and frontend modules.
2.cd backend
3.mvn spring-boot:run
This will run the backend server.

Step 2: Start Angular Application
From the top level directory of our project
1. cd frontend\src\main\frontend
2. npm start 

Angular application will start on port 4200 ( http://localhost:4200)



__Plan for next release__

1. Provide GUI for entering operator and operands.

__More Information__
More Information can be found at https://github.com/aoeaec/Calculator


