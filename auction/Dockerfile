#FROM maven:3.8.5-openjdk-17 AS build
#
#WORKDIR /app
#
#COPY pom.xml /app/
#
#COPY src /app/src
#
#RUN #mvn clean install -e -DskipTests
#RUN mvn clean package -e -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

#COPY --from=build /app/target/*.jar auction-ms.jar
COPY target/pig-auction-service-0.0.1-SNAPSHOT.jar /app/


EXPOSE 8083

CMD ["java", "-jar", "pig-auction-service-0.0.1-SNAPSHOT.jar"]
