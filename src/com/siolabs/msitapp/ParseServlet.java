package com.siolabs.msitapp;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;
import com.siolabs.msitapp.oauth.MySpreadsheetIntegration;

@SuppressWarnings("serial")
public class ParseServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		MySpreadsheetIntegration obj = null;
		
		try {
			obj = new MySpreadsheetIntegration();
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setContentType("text/plain");
		resp.getWriter().println(obj.data);
	}
	
	
}
