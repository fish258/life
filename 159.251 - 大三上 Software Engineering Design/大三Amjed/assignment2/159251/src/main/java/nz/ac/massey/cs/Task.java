package nz.ac.massey.cs;

import java.io.Serializable;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

// This class models a Task item

public class Task implements Serializable {
    private String description;
	private boolean completed=false;
    private String name;
    private String project_title;
    private Date date;
    
    
    public Task() {
		super();
	}
	public Task(String name,String description,Date date,String project_title) {
        this.name = name;
        this.description = description;
        this.completed = false;
        this.date= date;
        this.project_title = project_title;
    }
    public boolean isComplete() {
        return completed;
    }
    public void setComplete(boolean complete) { 
    	this.completed = complete; 
    	}
    
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProject_title() {
		return project_title;
	}
	public void setProject_title(String project_title) {
		this.project_title = project_title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
    
    
}
