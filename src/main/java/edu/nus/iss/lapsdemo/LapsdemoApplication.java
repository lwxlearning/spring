package edu.nus.iss.lapsdemo;

import java.text.SimpleDateFormat;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.nus.iss.lapsdemo.model.Employee;
import edu.nus.iss.lapsdemo.model.LeaveRecord;
import edu.nus.iss.lapsdemo.repo.EmployeeRepository;

@SpringBootApplication
public class LapsdemoApplication implements CommandLineRunner{

	private EmployeeRepository eRepo;
	
	@Autowired
	public void seteRepo(EmployeeRepository eRepo) {
		this.eRepo = eRepo;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LapsdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Employee empA = new Employee();
		empA.setEmpName("lwx");
		empA.setPwd("a");
		LeaveRecord lr1 = new LeaveRecord();
		lr1.setReasonLeave("Sick of school");
		lr1.setLeaveFrom(df.parse("12/06/2019"));
		lr1.setLeaveTo(df.parse("15/06/2019"));
		LeaveRecord lr2 = new LeaveRecord();
		lr2.setReasonLeave("Will work for money");
		lr2.setLeaveFrom(df.parse("21/07/2019"));
		lr2.setLeaveTo(df.parse("28/07/2019"));
		empA.addLeave(lr1);
		empA.addLeave(lr2);
		eRepo.save(empA);
	}

}
