package nz.ac.massey.cs.sdc.assign1.s17140713;




import java.util.Collections;
import java.util.List;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;

public class MemAppender extends AppenderSkeleton{
	private List<LoggingEvent> MemAppenderList = null;       //store event 
	int maxSize;         
	int count=0;
	Layout l1;
	static MemAppender memInstance = null;
	
	private MemAppender(Layout layout, int maxSize, List client_list) {
		super();
		if (MemAppenderList==null) {
			this.MemAppenderList = client_list;
		}
		this.maxSize = maxSize;
		this.l1 = layout;
	}
	public void clear() {
		MemAppenderList.clear();
	}
	
	public static MemAppender getMemAppender(Layout layout, int maxSize,List client_list) {
		if (memInstance==null) {
			memInstance = new MemAppender(layout,maxSize,client_list);
		}
		return memInstance;
	}
	
	public int getDiscardedLogCount() {
		return count;
		}
	
	public List<LoggingEvent> getCurrentLogs(){
		return Collections.unmodifiableList(MemAppenderList);
	}
	
	public void close() {
		// TODO Auto-generated method stub
	}

	public boolean requiresLayout() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void append(LoggingEvent event) {
		// TODO Auto-generated method stub
		int n = MemAppenderList.size();
		if (n<maxSize) {
			MemAppenderList.add(event);
		}
		else {               //size> maxSize
			MemAppenderList.remove(0);
			MemAppenderList.add(event);
			count += 1;
		}
	}
}
