package com.lukas.latihanjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lukas.latihanjpa.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@PersistenceContext  //menjembatani antara object dengan db
	EntityManager entityManager;
	
	@Override
	public List<Employee> getAll() {
		return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
	}

	@Override
	public Employee getById(int id) {
		return entityManager.find(Employee.class, id);
	}
	@Transactional
	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		
	}
	@Transactional
	@Override
	public void update (Employee employee) {
		entityManager.merge(employee);
	}
	
	@Transactional
	@Override
	public void delete (int id) {
		Employee employee = getById(id);
		entityManager.remove(employee);	
	}

	@Override
	public List<Employee> getByName(String name){
//		return entityManager.createNativeQuery("SELECT*FROM employee WHERE name LIKE?0", Employee.class)
		
		return entityManager.createQuery("Select e from Employee e where e.name like ?0", Employee.class)
		.setParameter(0,"%" + name + "%")
		.getResultList();

	}
}
