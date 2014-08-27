package com.siolabs.msitapp.oauth;
import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.SpreadsheetFeed;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.data.spreadsheet.WorksheetFeed;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;
import com.siolabs.msitapp.model.StudentMarksEntity;
import static com.siolabs.msitapp.model.OfyService.ofy;

public class MySpreadsheetIntegration {
	
    String USERNAME ="//ENTER USer name here//";
    String PASSWORD = "//ENTER PASSWORD HERE//";
    public String data = "";

 public MySpreadsheetIntegration()
      throws AuthenticationException, MalformedURLException, IOException, ServiceException, URISyntaxException {

	 //start the spreadsheet integration
    SpreadsheetService service = new SpreadsheetService("MySpreadsheetIntegration");
    service.setProtocolVersion(SpreadsheetService.Versions.V3);
    
    //authorize
    service.setUserCredentials(USERNAME, PASSWORD);
    
    // Define the URL to request.  This should never change.
    URL SPREADSHEET_FEED_URL = new URL(
        "https://spreadsheets.google.com/feeds/spreadsheets/private/full");

    // Make a request to the API and get all spreadsheets.
    SpreadsheetFeed feed = service.getFeed(SPREADSHEET_FEED_URL, SpreadsheetFeed.class);
    List<SpreadsheetEntry> spreadsheets = feed.getEntries();

   
    //get the first spreadsheet
    SpreadsheetEntry spreadsheet = spreadsheets.get(0);
   
    // Iterate through all of the spreadsheets returned
    for (SpreadsheetEntry sp : spreadsheets) {
      // Print the title of this spreadsheet to the screen
      data += sp.getTitle().getPlainText();
    }
    
    WorksheetFeed worksheetFeed = service.getFeed(
            spreadsheet.getWorksheetFeedUrl(), WorksheetFeed.class);
        List<WorksheetEntry> worksheets = worksheetFeed.getEntries();
        WorksheetEntry worksheet = worksheets.get(0);

        // Fetch the list feed of the worksheet.
        URL listFeedUrl = new URI(worksheet.getListFeedUrl().toString()
        	    + "").toURL();
        ListFeed listFeed = service.getFeed(listFeedUrl, ListFeed.class);

        // Iterate through each row, printing its cell values.
        for (ListEntry row : listFeed.getEntries()) {
          // Print the first column's cell value
          System.out.print(row.getTitle().getPlainText() + "\t");
          // Iterate over the remaining columns, and print each cell value
          
          StudentMarksEntity entity = new StudentMarksEntity();
          
          HashMap<String, Float> marks = new HashMap<String, Float>();
          
        
          for (String tag : row.getCustomElements().getTags()) {
        	  
        	if(tag.equalsIgnoreCase("semester"))
        		entity.setSemNo(Integer.parseInt(row.getCustomElements().getValue(tag)));
        	if(tag.equalsIgnoreCase("sessional"))
        		entity.setSessional(Integer.parseInt(row.getCustomElements().getValue(tag)));
        	if(tag.equalsIgnoreCase("enrollmentno"))
        		entity.setEnrollmentNo(Long.parseLong(row.getCustomElements().getValue(tag)));
        	
        	//subject1
        	if(tag.equalsIgnoreCase("subject1"))
        	{
        		String subName = row.getCustomElements().getValue(tag);
        		Float mark = Float.parseFloat(row.getCustomElements().getValue("marks"));
        		marks.put(subName, mark);
        	}
        	
        	//subject2
        	if(tag.equalsIgnoreCase("subject2"))
        	{
        		String subName = row.getCustomElements().getValue(tag);
        		Float mark = Float.parseFloat(row.getCustomElements().getValue("marks_2"));
        		marks.put(subName, mark);
        	}
        	
        	//subject3
        	if(tag.equalsIgnoreCase("subject3"))
        	{
        		String subName = row.getCustomElements().getValue(tag);
        		Float mark = Float.parseFloat(row.getCustomElements().getValue("marks_3"));
        		marks.put(subName, mark);
        	}
        	
        	//subject4
        	if(tag.equalsIgnoreCase("subject4"))
        	{
        		String subName = row.getCustomElements().getValue(tag);
        		Float mark = Float.parseFloat(row.getCustomElements().getValue("marks_4"));
        		marks.put(subName, mark);
        	}
        	
        	//subject5
        	if(tag.equalsIgnoreCase("subject5"))
        	{
        		String subName = row.getCustomElements().getValue(tag);
        		Float mark = Float.parseFloat(row.getCustomElements().getValue("marks_5"));
        		marks.put(subName, mark);
        	}
        	
        		
            System.out.print(tag + " " + row.getCustomElements().getValue(tag) + "\t");
          }
          System.out.println();
          
          entity.setMarks(marks);
          //now save the entity
          ofy().save().entity(entity);
          
          
        }


    }
    // TODO: See other portions of this guide for code to put here...
  }
