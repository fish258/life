package nz.ac.massey.cs.sdc.tutorial6.concurrent;

public interface ProductionMBean {
	public int getBufferSize();
	public int getMaxBufferSize();
	public int getProcessedJobCount();
	public void stop();
}
