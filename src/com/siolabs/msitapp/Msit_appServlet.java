package com.siolabs.msitapp;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;
import com.siolabs.msitapp.oauth.MySpreadsheetIntegration;
import com.siolabs.msitapp.resources.MarksJsonResource;


public class Msit_appServlet extends Application {
	
	
	
	
	
	@Override
	public Restlet createInboundRoot() {
		// Create a router Restlet that routes each call to a new Resource
		System.out.print("Reached router");
		Router router = new Router(getContext());
		router.attach("/student/{enrollmentNo}/marks", MarksJsonResource.class);
		router.attachDefault(MarksJsonResource.class);
		
		return router;
	}
	
	
	
	
	
	
}
