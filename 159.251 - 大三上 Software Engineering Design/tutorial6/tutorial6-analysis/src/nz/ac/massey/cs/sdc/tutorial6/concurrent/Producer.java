package nz.ac.massey.cs.sdc.tutorial6.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

import nz.ac.massey.cs.sdc.tutorial6.websitebuilder.Student;
import nz.ac.massey.cs.sdc.tutorial6.websitebuilder.StudentFactory;

/**
 * A producer produces lists of random student instances for processing.
 * It implements Runnable to enable multiple producers to run in parallel using threads.
 */
public class Producer implements Runnable {
	
	public static final int MAX_LIST_SIZE = 100;
	private BlockingQueue <List<Student>> queue = null;
	private boolean stopped = false;
	
	public Producer(BlockingQueue<List<Student>> queue) {
		super();
		this.queue = queue;
	}
	
	public void stop() {
		stopped = true;
	}

	@Override
	public void run() {
		while (!this.stopped) {
			List<Student> list = new ArrayList<Student>();
			int size = (new Random().nextInt(MAX_LIST_SIZE-1))+1; // make sure it isn't 0
			for (int i=0;i<size;i++) { 
				Student s = StudentFactory.createRandomStudent();
				list.add(s);
			}
			
			try {
				queue.put(list);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
