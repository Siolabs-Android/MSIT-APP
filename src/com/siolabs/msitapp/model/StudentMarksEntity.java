package com.siolabs.msitapp.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class StudentMarksEntity {

	@Id
	public Long id;
	
	@Index
	public long enrollmentNo;
	
	public int semNo;
	
	public int sessional;
	
	
	public HashMap<String, Float> marks;
	
	
	//default constructor for objectify
	public StudentMarksEntity(){}

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


	public int getSemNo() {
		return semNo;
	}

	public void setSemNo(int semNo) {
		this.semNo = semNo;
	}


	public int getSessional() {
		return sessional;
	}

	public void setSessional(int sessional) {
		this.sessional = sessional;
	}

	public HashMap<String, Float> getMarks() {
		return marks;
	}

	public void setMarks(HashMap<String, Float> marks) {
		this.marks = marks;
	}
	
	@Override
	public String toString(){
		String s = "";
		
		s += "Enrollment No :" + this.enrollmentNo +"\n";
		s += "semester : " + this.semNo + "\n";
		s += "sessional : " + this.sessional +" \n";
		s += "Marks \n";
		
		Iterator it = marks.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry pairs = (Map.Entry)it.next();
			s += pairs.getKey() + " = " + pairs.getValue() + "\n";
		}
		
		
		
		return s;
	}
	
	
	
	
}
