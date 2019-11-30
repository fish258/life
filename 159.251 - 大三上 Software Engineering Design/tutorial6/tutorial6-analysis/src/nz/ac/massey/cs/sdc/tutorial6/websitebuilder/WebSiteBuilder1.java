package nz.ac.massey.cs.sdc.tutorial6.websitebuilder;

import java.util.List;

public class WebSiteBuilder1 implements WebSiteBuilder {

	@Override
	public String buildWebSite(List<Student> students) {
		StringBuilder builder = new StringBuilder();
		
		builder.append("<html>\n")
		.append("<body>\n")
		.append("<h3>Student List</h3>\n")
		.append("<table border=\"1\">\n")
		.append("<tr><th>ID</th><th>FIRST NAME</th><th>NAME</th><th>DEGREE</th></tr>\n");
		
		for (Student s:students) {
			builder.append("<tr>")
			.append("<td>")
			.append(s.getId())
			.append("</td>")
				
			.append("<td>")
			.append(s.getFirstName())
			.append("</td>")
				
			.append("<td>")
			.append(s.getName())
			.append("</td>")
				
			.append("<td>")
			.append(s.getDegree())
			.append("</td></tr>\n");
		}
		
		builder.append("</table>\n")
		.append("</body>\n")
		.append("</html>\n");
		
		return builder.toString();
	}

}
