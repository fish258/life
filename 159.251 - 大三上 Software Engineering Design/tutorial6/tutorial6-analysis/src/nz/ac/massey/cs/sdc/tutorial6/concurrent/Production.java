package nz.ac.massey.cs.sdc.tutorial6.concurrent;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import nz.ac.massey.cs.sdc.tutorial6.websitebuilder.Student;

public class Production implements ProductionMBean {
	private static final int PRODUCER_COUNT = 2;
	private static final int CONSUMER_COUNT = 1;
	private static final int BUFFER_SIZE = 10;
	
	public Production() {
		super();
		// register mbean for monitoring
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer(); 
        try {
                ObjectName name = new ObjectName("nz.ac.massey.cs.sdc.tutorial6.concurrent:type=Production,id=1");
                mbs.registerMBean(this, name); 
        } catch (Exception x) {
                System.err.println("Registering mbean for monitoring failed");
        }
	}

	private List<Producer> producers = new ArrayList<Producer>();
	private List<Consumer> consumers = new ArrayList<Consumer>();
	private BlockingQueue <List<Student>> queue = new ArrayBlockingQueue<List<Student>>(BUFFER_SIZE);
	private Counter jobCounter = new Counter("processed jobs");
	
	public static void main(String[] args) {
		new Production().start();
	}

	public void start() {

		// start producers
		for (int i=1;i<=PRODUCER_COUNT;i++) {
			Producer producer = new Producer(queue);
			Thread thread = new Thread(producer);
			thread.setName("producer - " + i); // name to facilitate analysis with VisualVM or similar tool
			thread.start();
			producers.add(producer);
		}
		
		// start consumers
		for (int i=1;i<=CONSUMER_COUNT;i++) {
			Consumer consumer = new Consumer(queue,jobCounter);
			Thread thread = new Thread(consumer);
			thread.setName("consumer - " + i); // name to facilitate analysis with VisualVM or similar tool
			thread.start();
			consumers.add(consumer);
		}

	}

	@Override
	public int getBufferSize() {
		return queue.size();
	}
	@Override
	public int getMaxBufferSize() {
		return BUFFER_SIZE;
	}
	@Override
	public int getProcessedJobCount() {
		return jobCounter.getValue();
	}

	// this method can be invoked from a JMX monitor such as VisualVM !
	@Override
	public void stop() {
		// stop producers, let consumers finish all jobs in the buffer
		for (Producer producer:producers) {
			producer.stop();
		}
		// wait to see whether there are still jobs, if none left, stop consumers
		while (queue.size()>0) {
			// wait to give consumer a chance to finish
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}
		// now we can safely stop consumers
		for (Consumer consumer:consumers) {
			consumer.stop();
		}
		System.out.println("stopped production");
		System.exit(0);
	}

}
