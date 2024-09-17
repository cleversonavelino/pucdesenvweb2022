FROM openjdk:17-jdk-alpine
MAINTAINER service-registry
COPY target/register-0.0.1-SNAPSHOT.jar register-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/register-0.0.1-SNAPSHOT.jar"]