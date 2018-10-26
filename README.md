# spring-cloud-stream-employee-consumer

Spring Cloud Stream - Consume Message from RabbitMQ

Register a Stream App with the App Registry using the Spring Cloud Data Flow Shell

Please run the below steps: app register --name employee-service-app --type app --uri 

app register --name employee-consumer-app --type app --uri maven://com.gsrk.employee:employee-consumer:jar:0.0.1-SNAPSHOT
stream create --name emp-consumer-app-log-data --definition 'employee-consumer-app'
stream deploy --name emp-consumer-app-log-data
