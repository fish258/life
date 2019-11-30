package nz.ac.massey.cs.sdc.assign1.s17140713;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class VelocityLayout extends Layout{
	String content;
	String convertContent;
	
	public VelocityLayout(String content) {
		super();
		this.content = content;
	}

	public void activateOptions() {
		// TODO Auto-generated method stub
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public String format(LoggingEvent event) {
		// TODO Auto-generated method stub
		File f = new File("template.vm");
		
		convertContent = content.replace("@", "$");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write(convertContent);
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		VelocityContext context = new VelocityContext();
		context.put("c", event.getLoggerName());
		context.put("d",event.toString());
		context.put("m", event.getMessage());
		context.put("p",event.getLevel());
		context.put("t",event.getThreadName());
		context.put("n","/n");
		StringWriter string1 = new StringWriter();
		Template temp = Velocity.getTemplate("template.vm");
		temp.merge(context, string1);
		return string1.toString();
	}
	
	@Override
	public boolean ignoresThrowable() {
		return false;
	}
	
}
