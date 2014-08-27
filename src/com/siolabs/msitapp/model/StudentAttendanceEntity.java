package com.siolabs.msitapp.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;


@Entity
public class StudentAttendanceEntity {
	
	@Id
	public long id; 
	
	public long enrollmentNo;
	
	public String subjectName;
	
	public int semNo;
	
	public String month;
	
	public float attendance;
	
	//constructor for objectify
	public StudentAttendanceEntity() {
		
	}
	
	public StudentAttendanceEntity(long enrollmentNo, String sub, int sem, String mon, float attendance ){
		
		this.enrollmentNo = enrollmentNo;
		this.subjectName = sub;
		this.semNo = sem;
		this.month = mon;
		this.attendance = attendance;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getEnrollmentNo() {
		return enrollmentNo;
	}

	public void setEnrollmentNo(long enrollmentNo) {
		this.enrollmentNo = enrollmentNo;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getSemNo() {
		return semNo;
	}

	public void setSemNo(int semNo) {
		this.semNo = semNo;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public float getAttendance() {
		return attendance;
	}

	public void setAttendance(float attendance) {
		this.attendance = attendance;
	}
	
	

}
