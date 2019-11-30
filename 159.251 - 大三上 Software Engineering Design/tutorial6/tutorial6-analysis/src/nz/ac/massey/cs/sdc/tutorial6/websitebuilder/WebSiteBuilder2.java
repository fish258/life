package nz.ac.massey.cs.sdc.tutorial6.websitebuilder;

import java.util.List;

public class WebSiteBuilder2 implements WebSiteBuilder {

	public String buildWebSite(List<Student> students) {

		String site = "<html>\n";
		site=site+"<body>\n";
		site=site+"<h3>Student List</h3>\n";
		site=site+"<table border=\"1\">\n";
		site=site+"<tr><th>ID</th><th>FIRST NAME</th><th>NAME</th><th>DEGREE</th></tr>\n";
		
		for (Student s:students) {
			site=site+"<tr>";
			site=site+"<td>";
			site=site+s.getId();
			site=site+"</td>";
				
			site=site+"<td>";
			site=site+s.getFirstName();
			site=site+"</td>";
				
			site=site+"<td>";
			site=site+s.getName();
			site=site+"</td>";
				
			site=site+"<td>";
			site=site+s.getDegree();
			site=site+"</td></tr>\n";
		}
		
		site=site+"</table>\n";
		site=site+"</body>\n";
		site=site+"</html>\n";
		
		return site;
	}

}
