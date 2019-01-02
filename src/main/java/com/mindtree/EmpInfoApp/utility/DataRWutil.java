package com.mindtree.EmpInfoApp.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;

import com.mindtree.EmpInfoApp.entity.Department;
import com.mindtree.EmpInfoApp.entity.Employee;
import com.mindtree.EmpInfoApp.exceptions.UtilException;

public class DataRWutil {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
	public static Employee readEmployeeData() throws UtilException {

		Employee emp = new Employee();
		
		try {
			System.out.println("Enter employee name : ");
			emp.setEmployeeName(bf.readLine());
			System.out.println("Enter employee email : ");
			emp.setEmail(bf.readLine());
			System.out.println("Enter employee DOB (YYYY-MM-DD) : ");
			emp.setDateOfBirth(Date.valueOf(bf.readLine()));
			System.out.println("Enter employee salary : ");
			emp.setSalary(Double.parseDouble(bf.readLine()));
			return emp;
		}catch(NumberFormatException e) {
			throw new UtilException("Invalid Input",e.getCause());
		}catch (IOException e) {
			throw new UtilException("Cannot read data",e.getCause());
		}catch(Exception e) {
			throw new UtilException("Cannot read data",e.getCause());
		}
	}
	
	public static Department readDepartment() throws UtilException {
		
		Department dept = new Department();
		try {
		System.out.println("Enter department no : ");
		dept.setDepartmentNo(Integer.parseInt(bf.readLine()));
		System.err.println("Enter department name : ");
		dept.setDepartmentName(bf.readLine());
		return dept;
		}catch(NumberFormatException e) {
			throw new UtilException("Invalid Input",e.getCause());
		}
		catch (IOException e) {
			throw new UtilException("Cannot read data",e.getCause());
		}
		
	}
	
	public static void displayEmployee(Employee emp) {
		
		System.out.format("%-16d%-16s%-32s%-16s%-16f%-16d",emp.getEmployeeNo(),emp.getEmployeeName(), emp.getEmail(), emp.getDateOfBirth(), emp.getSalary(), emp.getDepartment().getDepartmentNo());
		
	}
}