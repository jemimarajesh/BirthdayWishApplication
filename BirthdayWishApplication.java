package com.amdocs;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class BirthdayWishApplication 
{
	
	public static void main(String[] args) throws Exception {
		
		ExcelReader excelReader = new ExcelReader();
		
		ArrayList<Employee> employeeDetails = excelReader.readInput();
		
		PhPSendEmail phPSendEmail;
		
		if(employeeDetails.size()==0) {
			
			Employee employee = new Employee();
			employee.setEmail("mudipallissaikumar@gmail.com");
			employee.setName("Admin");
			employeeDetails.add(employee);
			
			phPSendEmail = new PhPSendEmail(employeeDetails);
		}else {
			phPSendEmail = new PhPSendEmail(employeeDetails);
		}
		
		phPSendEmail.sendEmail();
	}

}
