package com.lukas.latihanjpa;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lukas.latihanjpa.dao.EmployeeDAO;
import com.lukas.latihanjpa.model.Employee;

@Configuration
public class Action {

	@Autowired // memanggil ulang tanpa inisiasi lagi
	EmployeeDAO employeeDAO;

	@Bean
	public List<Employee> getAll() {
		List<Employee> employees = employeeDAO.getAll();

		for (Employee employee : employees) {
			System.out.println("ID : " + employee.getId());
			System.out.println("Name : " + employee.getName());
			System.out.println("Address : " + employee.getAddres());
			System.out.println("DOB : " + employee.getDob());
			System.out.println("=======================================");
		}

		return employees;
	}

	@Bean
	public Employee getById() {
		Employee employee = employeeDAO.getById(10);

		System.out.println("Get By ID = 11");
		System.out.println("ID : " + employee.getId());
		System.out.println("Name : " + employee.getName());
		System.out.println("Address : " + employee.getAddres());
		System.out.println("DOB : " + employee.getDob());
		System.out.println("=======================================");

		return employee;

	}

	@Bean
	public boolean save() {
		try {
			Employee employee = new Employee();

			employee.setId(5);
			employee.setName("baba");
			employee.setAddres("MANCHASTER CITY");

			String dateString = "2019-07-01";
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);

			employee.setDob(date);
			;

			employeeDAO.update(employee);
			System.out.println("Data Berhasil Tersimpan");

			return true;
		} catch (Exception e) {
			System.out.println("Data Gagal Tesimpan");
			return true;
		}
	}

	public boolean delete() {
		try {
			employeeDAO.delete(5);
			System.out.println("data berhasil dihapus");
			return true;
		} catch (Exception e) {
			System.out.println("data gagal dihapus");
			e.printStackTrace();
			return false;
		}

	}

	public List<Employee> getByName(){
		List<Employee> Employees = employeeDAO.getByName("baba");
				
				for (Employee employee : Employees) {
					System.out.println("ID : " + employee.getId());
					System.out.println("Name : " + employee.getName());
					System.out.println("Address : " + employee.getAddres());
					System.out.println("DOB : " + employee.getDob());
					System.out.println("=======================================");
				}

				return Employees;
	}
}
