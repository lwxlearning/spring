package edu.nus.iss.lapsdemo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.nus.iss.lapsdemo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	public List<Employee> findByEmpNameAndPwd(String empName, String pwd);
}
