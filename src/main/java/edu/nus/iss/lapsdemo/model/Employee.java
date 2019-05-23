package edu.nus.iss.lapsdemo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String empName;
	private String pwd;
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	Set<LeaveRecord> leaveSet = new HashSet<LeaveRecord>();
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Set<LeaveRecord> getLeaveSet() {
		return leaveSet;
	}
	public void addLeave(LeaveRecord leave) {
		leaveSet.add(leave);
	}
	public void removeLeave(LeaveRecord leave) {
		leaveSet.remove(leave);
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", pwd=" + pwd + ", leaveSet=" + leaveSet + "]";
	}
	
	
	
}
