package com.gsrk.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableBinding(Sink.class)
public class EmployeeConsumerApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(EmployeeConsumerApplication.class, args);
    }
}
