package com.mindtree.EmpInfoApp.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

import com.mindtree.EmpInfoApp.entity.Department;
import com.mindtree.EmpInfoApp.entity.Employee;
import com.mindtree.EmpInfoApp.exceptions.AppExceptions;
import com.mindtree.EmpInfoApp.exceptions.ServiceExceptions;
import com.mindtree.EmpInfoApp.exceptions.UtilException;
import com.mindtree.EmpInfoApp.service.DepartmentService;
import com.mindtree.EmpInfoApp.service.EmployeeService;
import com.mindtree.EmpInfoApp.service.serviceImpl.DepartmentServiceImpl;
import com.mindtree.EmpInfoApp.service.serviceImpl.EmployeeServiceImpl;
import com.mindtree.EmpInfoApp.utility.DataRWutil;

public class MainApplication {

	public static EmployeeService ES = new EmployeeServiceImpl();
	public static DepartmentService DS = new DepartmentServiceImpl();
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws AppExceptions {

		System.out.println("***************************************************************************");
		System.out.println("********************************WELCOME************************************");
		System.out.println("***************************************************************************");
		System.out.println("");
		while (true) {
			System.out.println("1 - Department data handling\n2 - Employee data handling\n3 - Exit");
			System.out.println("Enter your choice");
			try {
				int choice = Integer.valueOf(bf.readLine());

				switch (choice) {
				case 1:
					showDepartmentMenu();
					break;
				case 2:
					showEmployeeMenu();
					break;
				case 3:
					System.out.println("Bye...");
					System.exit(0);
					
				default : System.out.println("Enter Valid input");
				}

			} catch (IOException e) {
				e.printStackTrace();
			}catch(Exception e) {
				throw new AppExceptions(e.getCause());
			}
		}
	}

	private static void showEmployeeMenu() throws AppExceptions {
		System.out.println("***************************************************************************");
		System.out.println("*****************************Employee Menu*********************************");
		System.out.println("***************************************************************************");
		System.out.println("");
		while (true) {
			System.out.println(
					"1 - Add Employee\n2 - Get Employee By Id\n3 - Delete Employee\n4 - Update Employee\n5 - Go back to previous menu\n6 - Exit");
			System.out.print("Enter your choice : ");
			try {
				int choice = Integer.valueOf(bf.readLine());
				switch (choice) {
				case 1:
					Employee employee = DataRWutil.readEmployeeData();
					int id = ES.addNewEmployee(employee);
					System.out.print("Employee added with id : " + id);
					break;

				case 2:
					System.out.print("Enter employee number whose details are needed : ");
					int empId = Integer.valueOf(bf.readLine());
					Employee emp = ES.getEmployeeById(empId);
					System.out.println("*****************************************************************************");
					System.out.format("%-16s%-16s%-16s%-16s%-16s%-16s", "EmployeeNo", "EmployeeName", "Email",
							"Date of birth", "Salary", "DepartmentNo");
					System.out.println("*****************************************************************************");
					DataRWutil.displayEmployee(emp);
					System.out.println("*****************************************************************************");
					break;

				case 3:
					System.out.print("Enter employee number whose details need to be deleted : ");
					int Id = Integer.valueOf(bf.readLine());
					System.out.println(ES.delteEmployeeById(Id));
					break;
				case 4:
					System.out.print("Enter employee no whose details must be updated : ");
					int i = (Integer.parseInt(bf.readLine()));
					Employee e = DataRWutil.readEmployeeData();
					e.setEmployeeNo(i);
					System.out.println(ES.updateExistingEmployee(e));
					break;

				case 5:
					return;

				case 6:
					System.out.println("Bye...");
					System.exit(0);
					
				default : System.out.println("Enter Valid input");
				}
			} catch (IOException e) {
				throw new AppExceptions("Cannot read choice", e.getCause());
			} catch (UtilException e) {
				throw new AppExceptions(e.getMessage(), e.getCause());
			} catch (ServiceExceptions e) {
				throw new AppExceptions(e.getMessage(), e.getCause());
			}catch(Exception e) {
				throw new AppExceptions(e.getCause());
			}
		}

	}

	private static void showDepartmentMenu() throws AppExceptions {

		System.out.println("***************************************************************************");
		System.out.println("*****************************Department Menu*********************************");
		System.out.println("***************************************************************************");
		System.out.println("");
		while (true) {
			System.out.println(
					"1 - Add Department\n2 - Add Employee to a department\n3 - Delete Employee from a department\n4 - Get all employees\n5 - Go back to previous menu\n6 - Exit");
			System.out.print("Enter your choice : ");

			try {
				int choice = Integer.parseInt(bf.readLine());
				switch (choice) {
				case 1:
					Department dept = DataRWutil.readDepartment();
					System.out.println(DS.addNewDepartment(dept));
					break;

				case 2:
					System.out.print("Enter employee no whose department has to be updated : ");
					int i = (Integer.parseInt(bf.readLine()));
					System.out.print("Enter Department no where employee has to be added : ");
					int departmentNo = Integer.parseInt(bf.readLine());
					System.out.println(DS.addEmpToDept(ES.getEmployeeById(i), departmentNo));
					break;

				case 3:
					System.out.print("Enter employee no who has to be removed : ");
					int j = (Integer.parseInt(bf.readLine()));
					System.out.print("Enter Department no where employee has to be removed : ");
					int deptNo = Integer.parseInt(bf.readLine());
					System.out.println(DS.addEmpToDept(ES.getEmployeeById(j), deptNo));
					break;

				case 4:
					Set<Employee> employee = DS.getAllEmployees();
					System.out.println("********************************************************************************************************************");
					System.out.format("%-16s%-16s%-32s%-16s%-16s%-16s", "EmployeeNo", "EmployeeName", "Email", "Date of birth", "Salary", "DepartmentNo");
					System.out.println("");
					System.out.println("********************************************************************************************************************");
					employee.forEach(e -> {
						DataRWutil.displayEmployee(e);
						System.out.println("");
					});
					System.out.println("********************************************************************************************************************");
					break;

				case 5:
					return;

				case 6:
					System.out.println("Bye...");
					System.exit(0);
				
				default : System.out.println("Enter Valid input");

				}
			} catch (IOException e) {
				throw new AppExceptions("Cannot read choice", e.getCause());
			} catch (UtilException e) {
				throw new AppExceptions(e.getMessage(), e.getCause());
			} catch (ServiceExceptions e) {
				throw new AppExceptions(e.getMessage(), e.getCause());
			}catch(Exception e) {
				throw new AppExceptions(e.getCause());
			}
		}
	}

}