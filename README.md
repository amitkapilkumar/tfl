# tfl : Schedule at Great Portland Street Station (Stop G and H)

## Web UI endpoint

http://localhost:8080/display.html

## API / endpoint

- viewing schedule at Stop G http://localhost:8080/schedule/greatportlandstreet/G
- viewing schedule at Stop H http://localhost:8080/schedule/greatportlandstreet/H

## Installation / Deployment

Repo has executable jar file buses-0.0.1-SNAPSHOT.jar which can be executed as **java -jar buses-0.0.1-SNAPSHOT.jar**
Then webpage cane be viewed over the link http://localhost:8080/display.html

As sa samplle file Capture.PNG is attached which is a screenshot of UI.

In order to make any changes, src and build.gradle needs to imported as gradle project.

## Application overview
The API is developed using Spring-Boot web. The repo consists of gradle file, src folder and test folder(inside src/test).
code has unit test as well as application test (SpringBootTest)

## Technology / tools used
- JDK 1.8
- SpringBoot
- Mockito
- Junit 4 
- Gradle
- HTML
- CSS
- JQuery / JavaScript
