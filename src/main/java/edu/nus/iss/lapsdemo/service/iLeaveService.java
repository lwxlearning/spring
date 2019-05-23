package edu.nus.iss.lapsdemo.service;

import edu.nus.iss.lapsdemo.model.Employee;
import edu.nus.iss.lapsdemo.model.LeaveRecord;

public interface iLeaveService {

	Employee authenticate(String empName, String pwd);

	boolean applyLeave(LeaveRecord l);

}