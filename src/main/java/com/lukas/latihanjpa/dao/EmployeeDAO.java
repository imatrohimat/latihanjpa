package com.lukas.latihanjpa.dao;

import java.util.List;

import com.lukas.latihanjpa.model.Employee;

public interface EmployeeDAO {
	public List <Employee> getAll();
	public Employee getById(int id);
	public void save(Employee employee);
	public void update(Employee employee);
	public void delete(int id);
	List<Employee> getByName(String name);
}
