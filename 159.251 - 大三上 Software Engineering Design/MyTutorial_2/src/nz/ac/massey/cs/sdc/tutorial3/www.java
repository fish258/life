package nz.ac.massey.cs.sdc.tutorial3;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class www {
	public  static void main(String[] args) throws SecurityException, IOException { 
	final Logger logger = Logger.getLogger("org.jediael.crawl.MyCrawler");  
	logger.setLevel(Level.INFO);      
	  
	FileHandler fileHandler = new FileHandler("1.txt");  
	fileHandler.setLevel(Level.INFO);  
	  
	logger.addHandler(fileHandler);  
	  
	logger.info("Begin Crawling, Good Luck!"); 
}}
