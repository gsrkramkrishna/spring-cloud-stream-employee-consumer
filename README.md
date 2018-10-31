# spring-cloud-stream-employee-consumer : Spring Cloud Stream - Consume Message from RabbitMQ

# Apache Kafka Please use the below configuration:

1.  Add below Dependency:

        <dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-stream-kafka</artifactId>
		</dependency>
        
2.  Please download Kafka and follow the below steps. Reference link: https://kafka.apache.org/quickstart

Go to the Apache Kafka downloads page and download the https://kafka.apache.org/download the 2.12 kafka_2.12-0.10.2.1.tgz
Next unzip it to a particular location-
We will now start Apache Kafka-
This Kafka installation comes with an inbuilt zookeeper. Zookeeper is mainly used to track the status of nodes present in Kafka cluster and also to keep track of Kafka topics, messages, etc.
Open a command prompt and start the Zookeeper-
C:\kafka_2.12-0.10.2.1>.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties


Open a new command prompt and start the Apache Kafka-
C:\kafka_2.12-0.10.2.1>.\bin\windows\kafka-server-start.bat .\config\server.properties


# Deploying Spring Cloud Data Flow Local Serve. Please floow th below steps.

1.  Download the Spring Cloud Data Flow Server and Shell apps:
    I am using 1.7.0 version in my local. Please download RabittMq and install it in your local machine.
http://repo.spring.io/release/org/springframework/cloud/spring-cloud-dataflow-server-local/

2.  Launch the Data Flow Server.

3.  Data Flow Server is a Spring Boot application, Launch Data Flow Server: java -jar "jar name"
    Ex: java -jar spring-cloud-dataflow-server-local-1.7.0.BUILD.jar
    
    https://user-images.githubusercontent.com/32461306/47600301-d25ad200-d9dc-11e8-8c28-6e8adbaa90df.PNG
     
4.  Launch the shell: java -jar "jar name"
    Ex: java -jar spring-cloud-dataflow-shell-1.7.0.BUILD.jar
    
    https://user-images.githubusercontent.com/32461306/47600330-4c8b5680-d9dd-11e8-837d-fea88ea81b2a.PNG)

5.  Register a Stream App with the App Registry using the Spring Cloud Data Flow Shell.Please run the below steps:
    
6.  app register --name employee-consumer-app --type app --uri maven://com.gsrk.employee:employee-consumer:jar:0.0.1-SNAPSHOT

7.  stream create --name emp-consumer-app-log-data --definition 'employee-consumer-app'

8.  stream deploy --name emp-consumer-app-log-data




