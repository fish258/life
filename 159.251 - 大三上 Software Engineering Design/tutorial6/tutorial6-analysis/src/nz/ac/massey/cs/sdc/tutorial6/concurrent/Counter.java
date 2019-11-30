package nz.ac.massey.cs.sdc.tutorial6.concurrent;

public class Counter {

	private int value = 0;
	private String name = null;
	private long timestamp = System.currentTimeMillis();
	private static final int LOG_INTERVAL = 100000;
	
	public Counter(String name) {
		super();
		this.name = name;
	}

	
	public synchronized void increase () {
		value++;
		if (value%LOG_INTERVAL==0) {
			long now = System.currentTimeMillis();
			long diff = now-timestamp;
			timestamp = now;
			System.out.println(name+": it took " + diff + " ms to process " + LOG_INTERVAL + " jobs");
			
		}
	}
	public synchronized int getValue() {
		return value;
	}

}
