package com.siolabs.msitapp.resources;

import static com.siolabs.msitapp.model.OfyService.ofy;

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.siolabs.msitapp.model.StudentMarksEntity;

public class MarksJsonResource  extends ServerResource {

	
	@Get("json")
	public String getMarks() throws JSONException{
		
		//get the enrollment no here
		String enrollmentNo = (String)getRequest().getAttributes().get("enrollmentNo");
		
		
		System.out.println(enrollmentNo);
		
		//now query the database to get the get the entity with the marks
		StudentMarksEntity data = ofy().load().type(StudentMarksEntity.class).filter("enrollmentNo", Long.parseLong(enrollmentNo)).first().now();
		
		//check the data value
		if(data != null){
			//show the data here 
			
			System.out.println(data.toString());
			
		}
		
		/*
		 * Now create the json object here
		 */
		
		JSONObject obj = new JSONObject();
		obj.put("enrollmentNo", data.getEnrollmentNo());
		obj.put("semester", data.getSemNo());
		obj.put("sessional", data.getSessional());
		obj.put("marks", data.getMarks());
		
				
		return obj.toString() ;
	}
	
}
