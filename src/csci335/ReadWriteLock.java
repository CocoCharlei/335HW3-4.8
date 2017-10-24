package csci335;

public class ReadWriteLock {
	private Object[] array = new Object[20]; //Array of arbitrary size
	private int readHold = 0; //tell number readers holding
	private int writeHold = 0; //tell number writers hold
	
	public synchronized void producer(Object o) throws InterruptedException{
		while (readHold == 0 && writeHold == 0){
			notifyAll(); //wake up when available to use
		}
		while (readHold > 0 || writeHold > 0){
			wait(); //waits when object in use
		}
	}
	
	public synchronized Object consumer() throws InterruptedException{
		
		while (writeHold == 0){
			notifyAll(); //allow to use when no writer using
		}
		while (writeHold > 0){
			wait(); //waits when writer using
		}
		return array[readHold+writeHold]; //returns object in array at index of however many threads hold it
	}
}
