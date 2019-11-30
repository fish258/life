package nz.ac.massey.cs.sdc.tutorial6.websitebuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class WebSiteBuilderSampleApp {

	public static void main(String[] args) throws IOException {
		int STUDENT_COUNT = 10;
		List<Student> students = new ArrayList<Student>();
		for (int i=0;i<STUDENT_COUNT;i++) {
			students.add(StudentFactory.createRandomStudent());
		}
		File report = new File("students.html");
		PrintWriter out = new PrintWriter(new FileWriter(report));
		String webSiteContent = new WebSiteBuilder2().buildWebSite(students);
		out.println(webSiteContent);
		out.close();
	}

}
