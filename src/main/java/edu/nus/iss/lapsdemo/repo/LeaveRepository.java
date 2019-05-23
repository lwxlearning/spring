package edu.nus.iss.lapsdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.nus.iss.lapsdemo.model.LeaveRecord;

@Repository
public interface LeaveRepository extends JpaRepository<LeaveRecord, Integer>{

}
