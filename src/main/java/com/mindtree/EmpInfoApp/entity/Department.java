package com.mindtree.EmpInfoApp.entity;

import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="department")
public class Department {
	
	@Id
	private int departmentNo;
	private String departmentName;
	@OneToMany(targetEntity=Employee.class,mappedBy="department")
	@Cascade(CascadeType.DELETE)
	private Set<Employee> employee;

	public Department() {
	}

	public int getDepartmentNo() {
		return departmentNo;
	}

	public void setDepartmentNo(int departmentNo) {
		this.departmentNo = departmentNo;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Set<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}

}
