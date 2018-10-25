package com.gsrk.employee.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gsrk.employee.model.Employee;

public class JsontoObjectConversionUtil {

	public static Employee convertJsonToEmployeeModel(String jsonString) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();

		Employee emp = mapper.readValue(jsonString, Employee.class);
		
		return emp;
	}
	
}
