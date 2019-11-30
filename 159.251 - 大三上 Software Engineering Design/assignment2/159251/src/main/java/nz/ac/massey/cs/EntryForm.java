package nz.ac.massey.cs;


import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

// form with two fields for adding a task item

public class EntryForm extends Form<Void> {

    private RequiredTextField nameField;
    private RequiredTextField descriptionField;
    private RequiredTextField dateField;
    private RequiredTextField ptField;


    public EntryForm(String id) {
        super(id);
        nameField = new RequiredTextField("name", Model.of(""));
        descriptionField = new RequiredTextField("description", Model.of(""));
        dateField = new RequiredTextField("date", Model.of(""));
        ptField = new RequiredTextField("project_title", Model.of(""));
        
        add(nameField);
        add(descriptionField);
        add(dateField);
        add(ptField);			// put field into form        
    }
    public static Date stringToDate(String time){ 	// convert string date to Date date
        SimpleDateFormat formatter; 
        int tempPos=time.indexOf("AD") ; 
        time=time.trim() ; 
        formatter = new SimpleDateFormat ("yyyy.MM.dd G"); 
        if(tempPos>-1){ 
          time=time.substring(0,tempPos)+ 
               "公元"+time.substring(tempPos+"AD".length()); 
          formatter = new SimpleDateFormat ("yyyy.MM.dd G"); 
        } 
        tempPos=time.indexOf("-"); 
        if(tempPos>-1&&(time.indexOf(" ")<0)){ 
          formatter = new SimpleDateFormat ("yyyyMMdd"); 
        } 
        else if((time.indexOf("/")>-1) &&(time.indexOf(" ")>-1)){ 
          formatter = new SimpleDateFormat ("yyyy/MM/dd"); 
        } 
        else if((time.indexOf("-")>-1) &&(time.indexOf(" ")>-1)){ 
          formatter = new SimpleDateFormat ("yyyy-MM-dd"); 
        } 
        else if((time.indexOf("/")>-1) &&(time.indexOf("am")>-1) ||(time.indexOf("pm")>-1)){ 
          formatter = new SimpleDateFormat ("yyyy-MM-dd"); 
        } 
        else if((time.indexOf("-")>-1) &&(time.indexOf("am")>-1) ||(time.indexOf("pm")>-1)){ 
          formatter = new SimpleDateFormat ("yyyy-MM-dd a"); 
        } 
        ParsePosition pos = new ParsePosition(0); 
        java.util.Date ctime = formatter.parse(time, pos); 

        return ctime; 
    } 

    public static  Integer stringToInteger(String Intid){ //string格式的id转化为integer格式
    	Integer it = Integer.valueOf(Intid);
    	return it;
    }

    // adds the task when the form is submitted (by clicking the Add button)
    protected void onSubmit() {
        super.onSubmit();
        
        String name = (String)nameField.getDefaultModelObject();
        String description = (String)descriptionField.getDefaultModelObject();
        String stringDate = (String)dateField.getDefaultModelObject();
        String project_title = (String)ptField.getDefaultModelObject();
        // get content
        
        descriptionField.clearInput();
        descriptionField.setModelObject(null);
        nameField.clearInput();
        nameField.setModelObject(null);
        dateField.clearInput();
        dateField.setModelObject(null);
        ptField.clearInput();
        ptField.setModelObject(null);
        

        WicketApplication app = (WicketApplication) this.getApplication();
        TaskList collection = app.getTaskList();
        collection.addTask(new Task(name,description,stringToDate(stringDate),project_title));
        //add tasks with appropriate format into collection
    }
}
