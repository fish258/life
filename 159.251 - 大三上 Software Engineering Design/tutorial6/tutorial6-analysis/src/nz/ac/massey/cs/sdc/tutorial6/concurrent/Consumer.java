package nz.ac.massey.cs.sdc.tutorial6.concurrent;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import nz.ac.massey.cs.sdc.tutorial6.websitebuilder.Student;
import nz.ac.massey.cs.sdc.tutorial6.websitebuilder.WebSiteBuilder1;

/**
 * A consumer takes lists of student instances and prints them by converting them into html document.
 * It implements Runnable to enable multiple producers to run in parallel using threads.
 */
public class Consumer implements Runnable {

	private BlockingQueue <List<Student>> queue = null;
	private Counter counter = null;
	private boolean stopped = false;
	
	public Consumer(BlockingQueue<List<Student>> queue,Counter counter) {
		super();
		this.queue = queue;
		this.counter = counter;
	}
	
	public void stop() {
		stopped = true;
	}

	@Override
	public void run() {
		//synchronized (Producer.class) {
		while (!stopped) {
			try {
				List<Student> list = queue.take();
				new WebSiteBuilder1().buildWebSite(list);
				counter.increase();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		//}
	}
	
	

}
