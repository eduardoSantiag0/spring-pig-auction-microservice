#FROM maven:3.8.5-openjdk-17 AS build
#
#WORKDIR /app
#
#COPY pom.xml /app/
#
#COPY src /app/src
#
#RUN mvn clean install -e -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

#COPY --from=build /app/target/*.jar eureka-server.jar
COPY target/pig-auction-service-0.0.1-SNAPSHOT.jar /app/

EXPOSE 8081

#CMD ["java", "-jar", "eureka-server.jar"]
CMD ["java", "-jar", "pig-auction-service-0.0.1-SNAPSHOT.jar"]
