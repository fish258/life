package nz.ac.massey.cs.sdc.tutorial3;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Asd {
	 
	public static void main(String[] args) throws IOException {
		BasicConfigurator.configure();
		Logger loggerfile = Logger.getLogger("file");
		// TODO Auto-generated method stub
		loggerfile.addAppender(
				new org.apache.log4j.FileAppender(
				new org.apache.log4j.SimpleLayout(), "log11.txt"
				)
				);
//		loggerfile.setLevel(Level.WARN);
		loggerfile.debug("123");
		loggerfile.info("456");
	}

}
