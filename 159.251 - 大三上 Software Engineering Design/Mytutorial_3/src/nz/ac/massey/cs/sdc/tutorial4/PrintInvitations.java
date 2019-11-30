 package nz.ac.massey.cs.sdc.tutorial4;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class PrintInvitations {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileWriter out = new FileWriter("letter1.txt");
		VelocityContext context = new VelocityContext();
		XMLDecoder d = new XMLDecoder(new BufferedInputStream(new FileInputStream("friends.xml"))); //read the data
		ArrayList result = (ArrayList) d.readObject();
		d.close();

		for (Object person : result) {
			Person p0 = (Person) person;
			Template template = Velocity.getTemplate("letter.vm");    
			context.put("person", p0);                                     //bind student to p0
			template.merge(context, out);
			System.out.println(context);
		}
		out.close();
	}

}
