package com.gsrk.employee.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.gsrk.employee.model.Employee;
import com.gsrk.employee.service.EmployeeService;
import com.gsrk.employee.util.JsontoObjectConversionUtil;

@RestController
@RequestMapping(value="/v1")
public class EmployeeController {
	private Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	public void saveEmployee(Employee employee) {
		logger.info("Employee Reuest Payload:",employee);
		//boolean response = employeeRegistrationSource.employeeRegistration().send(MessageBuilder.withPayload(employee).build());
		Employee emp = employeeService.saveEmployee(employee);
		logger.info("After Saving Employee into DB:{} " , emp);
		//logger.info("Response:",response);
		
		
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.GET)
	public List<Employee> findAll(){
		
		return employeeService.findAll();
	}
	@StreamListener(target = Sink.INPUT)
	public void processRegisterEmployees(String employee) {
		logger.info("Employee JSON String:{} " , employee);
		Employee emp=null;
		try {
			emp = JsontoObjectConversionUtil.convertJsonToEmployeeModel(employee);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("Employee JSON to Employee model :{} " , emp);
		if(emp==null) {
			logger.info("Employee obj is null,so we are not processing");
			return;
		}
		saveEmployee(emp);
	}

}
