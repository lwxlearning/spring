package edu.nus.iss.lapsdemo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class LeaveRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lid;
	private String reasonLeave;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date leaveFrom;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date leaveTo;
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	public LeaveRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getReasonLeave() {
		return reasonLeave;
	}
	public void setReasonLeave(String reasonLeave) {
		this.reasonLeave = reasonLeave;
	}
	public Date getLeaveFrom() {
		return leaveFrom;
	}
	public void setLeaveFrom(Date leaveFrom) {
		this.leaveFrom = leaveFrom;
	}
	public Date getLeaveTo() {
		return leaveTo;
	}
	public void setLeaveTo(Date leaveTo) {
		this.leaveTo = leaveTo;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "LeaveRecord [lid=" + lid + ", reasonLeave=" + reasonLeave + ", leaveFrom=" + leaveFrom + ", leaveTo="
				+ leaveTo + ", employee=" + employee + "]";
	}
	
}
