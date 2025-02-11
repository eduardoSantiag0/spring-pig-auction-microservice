#RUN mvn clean package -e -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/bid-0.0.1-SNAPSHOT.jar /app/

EXPOSE 8083

CMD ["java", "-jar", "bid-0.0.1-SNAPSHOT.jar"]
