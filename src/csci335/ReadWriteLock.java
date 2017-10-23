package csci335;

public class ReadWriteLock {
	private Object[] array = new Object[20]; // arbitrary size
	private boolean beingRead = false;
	private boolean beingWritten = false;
	private int numOccupied = 0;
	private int firstOccupied = 0;

	public void write(Object o) throws InterruptedException {
	
	}

	public Object read() throws InterruptedException {
		
		return array; //return statement so it doesn't declare error
	
	}
}
