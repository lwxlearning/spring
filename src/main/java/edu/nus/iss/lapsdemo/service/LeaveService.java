package edu.nus.iss.lapsdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.nus.iss.lapsdemo.model.Employee;
import edu.nus.iss.lapsdemo.model.LeaveRecord;
import edu.nus.iss.lapsdemo.repo.EmployeeRepository;
import edu.nus.iss.lapsdemo.repo.LeaveRepository;

@Service
public class LeaveService implements iLeaveService {
	
	@Autowired
	private EmployeeRepository eRepo;
	
	@Autowired
	private LeaveRepository lRepo;
	
	
	@Transactional
	public Employee authenticate(String empName, String pwd) {
		List<Employee> elist = eRepo.findByEmpNameAndPwd(empName, pwd);
		return elist.get(0);
	}
	
	@Transactional
	public boolean applyLeave(LeaveRecord l) {
		lRepo.save(l);
		return true;
	}
}
