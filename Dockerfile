FROM openjdk:8
ADD target/employee-consumer-0.0.1-SNAPSHOT.jar employee-consumer.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "employee-consumer.jar"]
