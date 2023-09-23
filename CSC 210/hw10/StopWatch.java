package hw10;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class StopWatch {
	
	private Instant startTime;
	private Instant endTime;
	
	StopWatch(){
		startTime = Instant.now();
	}
	
	public void start() {
		startTime = Instant.now();
	}
	
	public void stop() {
		endTime = Instant.now();
	}
	
	public Instant getStartTime() {
		return startTime;
	}

	public Instant getEndTime() {
		return endTime;
	}

	public long timeElapsed() {
		return startTime.until(endTime, ChronoUnit.MILLIS);
	}
}
