package nz.ac.massey.cs;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxCheckBox;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.resource.ResourceReference;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.View;

public class TasksPage extends WebPage{


	private static final long serialVersionUID = 1L;
		
	@SuppressWarnings({ "serial", "unchecked" })
	public TasksPage() {
		add(new EntryForm("entryForm"));
        
        Form listForm = new Form("listForm");
        
        add(listForm);
       
		Date now = new Date();
		Label dateTimeLabel = new Label("datetime", now.toString());
		add(dateTimeLabel);

		WicketApplication app = (WicketApplication) this.getApplication();
		TaskList collection = app.getTaskList();
		List<Task> tasks = collection.getTasks();             					// all tasks
		
		List<Task> copy =new ArrayList<Task>();               // create a backup list
		List<Task> all_tasks =new ArrayList<Task>();		  // to copy all appeared tasks(create for write tasks.xml)
		List<Task> clearList =new ArrayList<Task>(); 		  // create a list contain cleared tasks
		
		PropertyListView taskListView =
				new PropertyListView("task_list", tasks) {
					private static final long serialVersionUID = 1L;

					@Override
					protected void populateItem(ListItem item) {

						item.add(new Label("name"));
						item.add(new Label("description"));						
						item.add(new Label("project_title"));
						item.add(new Label("date"));
						
						item.add(new AjaxCheckBox("completed") {
							@Override
							protected void onUpdate(AjaxRequestTarget ajaxRequestTarget) {
								}
							});
						}
					};
					
		// selectAll button function 
		add(new Link<Void>("selectAll") {          //wicket:id
			@Override
			public void onClick() {
				for(Task t: tasks) {
					t.setComplete(true);
				}
			}
		});
		
		// clear button function
		add(new Link<Void>("clear") {
			@Override
			public void onClick() {
					
					Iterator<Task> it = tasks.iterator();
					
					 while (it.hasNext()) {
						             Task t = it.next();
						            if (t.isComplete()) {
						                it.remove();
						                copy.remove(t);
						                clearList.add(t);
						            	}
						            }
					 }
			});

		// completed button function
		add(new Link<Void>("completed"){
       	 @Override 
       	 
       	 public void onClick() {
       		 if(copy.size()>0) {
       			 for(Task t:copy) {
       				 tasks.add(t);					// add items in Task to tasks
       				 }
       			 }
       		 for  ( int i=0 ;i<tasks.size()-1 ;i++ )  {			//  delete duplicated data
       			 for  ( int j = tasks.size()-1 ;j>i; j--)  {
       			  if  (tasks.get(j).equals(tasks.get(i)))  {
       			   tasks.remove(j);
       			   }
       			  }
       			 }                   
       		 // ensure tasks intact every time
       		 Iterator<Task> completed = tasks.iterator();
       		 while (completed.hasNext()) {
		             Task t = completed.next();
		            if (t.isComplete()==false) {		//remove completed task
		            	copy.add(t);
		                completed.remove();
		                  }
		            }
       		 }
       	 });
		
		// active button function
		add(new Link<Void>("active"){
       	 @Override 
       	 
       	 public void onClick() {
       		 if(copy.size()>0) {
       			 for(Task t:copy) {
       				 tasks.add(t);							//	add items in 'copy' to tasks
       			 }
       		 }
       		 for ( int i=0 ;i<tasks.size()-1 ;i++ ){		//  remove duplicated items
       			 for ( int j=tasks.size()-1 ;j>i; j-- )  {
       			  if (tasks.get(j).equals(tasks.get(i))){
       			   tasks.remove(j);
       			   } 
       			  } 
       			 }											
       		 
       		 // ensure tasks intact every time
       		 Iterator<Task> active = tasks.iterator();
       		 while (active.hasNext()) {
		             Task t = active.next();
		            if (t.isComplete()==true) {
		            	copy.add(t);  				//if t is completed -> remove t. copy is completed tasks
		            	active.remove();
		            	} 
		            }
       		 }
       	 });
		
		// all button function
        add(new Link<Void>("all"){
       	 @Override 
       	 
       	 public void onClick() {
       		 if(copy.size()>0) {
       			 for(Task t:copy) {
       				 tasks.add(t);						//	add items in 'copy' to tasks
       			 }
       		 }
       		 for  ( int i=0 ;i<tasks.size()-1 ;i++ )  {
       			 for  ( int j=tasks.size()-1 ;j>i; j-- )  {
       			  if  (tasks.get(j).equals(tasks.get(i)))  {
       			   tasks.remove(j);
       			     } 
       			    }
       			  }
       	 }	         
          });
        
        Label countLabel = new Label("activeCount",new PropertyModel(collection,"ActiveCount"));
        add(countLabel);
        
        Label environmentLabel=new Label("environment",System.getProperty("wicket.configuration"));
        add(environmentLabel);
        
     // refresh_count button function
        add(new Link<Void>("refresh_count") {
        	public void onClick() {
				}
			}
        );
        
     // ToXML button function
        add(new Link<Void>("ToXML") {
			@Override
			public void onClick() {
				
				if(tasks.size()>0) {
	       			 for(Task t:tasks) {
	       				 all_tasks.add(t);					// add items in Task to tasks
	       				 }
	       			 }
				
				if(copy.size()>0) {
	       			 for(Task t:copy) {
	       				all_tasks.add(t);					// add items in Task to tasks
	       				 }
	       			 }

	       		 for  ( int i=0 ;i<all_tasks.size()-1 ;i++ )  {			//  delete duplicated data
	       			 for  ( int j = all_tasks.size()-1 ;j>i; j--)  {
	       			  if  (all_tasks.get(j).equals(all_tasks.get(i)))  {
	       				all_tasks.remove(j);
	       			   }
	       			  }
	       			 }

				if(clearList.size()>0) {
	       			 for(Task t:clearList) {
	       				 all_tasks.add(t);					// add items in Task to tasks
	       				 }
	       			 }
				XMLEncoder e = null;
				try {
					e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Tasks.xml")));
					e.writeObject(all_tasks);				// write into xml file
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
				e.close();
			}
		});
        
        // loadfile button function
        add(new Link<Void>("loadfile") {    //  Import the tasks from the todo list(for example: alice\Data.md) text file into your application
			@Override
			public void onClick() {
				
				try {
					String[] words = new String[100];
					BufferedReader br = new BufferedReader(new FileReader("data\\files\\alice\\Data.md"));
					
					String ptitle = br.readLine(); //# Data
					String type = br.readLine();  //## Tasks
					String line = null; 
					while ((line = br.readLine()) != null){
						Task newtask = new Task();
						
						words = line.split(" ");
						if(words[0].equals("[X]") ) {		//length of words is 5				
						newtask.setComplete(true);
						newtask.setName(words[1]);
						newtask.setDescription(words[2]+" due:");
						newtask.setProject_title(words[3]);
						String[] timelist = words[4].split(":");	// ["due","nnnn-nn-nn"]
						newtask.setDate(EntryForm.stringToDate(timelist[1]));
						}
						else { 								// length of words is 6
							newtask.setComplete(false);
							newtask.setName(words[2]);
							newtask.setDescription(words[3]+" due:");
							newtask.setProject_title(words[4]);
							String[] timelist = words[5].split(":");	// ["due","nnnn-nn-nn"]
							newtask.setDate(EntryForm.stringToDate(timelist[1]));
						}
	
						tasks.add(newtask);
//						for  ( int i=0 ;i<tasks.size()-1 ;i++ )  {
//			       			 for  ( int j=tasks.size()-1 ;j>i; j-- )  {
//			       			  if  (tasks.get(j).equals(tasks.get(i)))  {
//			       			   tasks.remove(j);
//			       			     } 
//			       			    }
//			       			  }
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});

		listForm.add(taskListView);
	}
}