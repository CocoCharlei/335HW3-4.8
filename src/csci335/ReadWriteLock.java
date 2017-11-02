package csci335;

public class ReadWriteLock {
	private Object[] array = new Object[20]; //Array of arbitrary size
	private int readHold = 0; //tell number readers holding
	private int writeHold = 0; //tell number writers hold
	private int index_in = 0;
	private int index_out = 0;
	
	public synchronized void writer(Object o) throws InterruptedException{
		
		while (readHold > 0 || writeHold > 0){
			wait(); //waits when object in use
		}
		writeHold++; //inc writers hold
		System.out.println("writer is holding");
		//stores object at index in array
		array[index_in] = o;
		//change index_in to next index
		index_in = (++index_in)% array.length;
		writeHold--;
		System.out.println("writer no longer holding");
		notifyAll(); //wake up when available to use
	}
	
	public synchronized Object reader() throws InterruptedException{
		
		while (writeHold > 0){
			wait(); //waits when writer using
		}
		readHold++; 
		System.out.println("reader is holding");
		//return object in array at index
		Object output = array[index_out];
		//increment index to be read
		index_out = (++index_out) % array.length;
		readHold--;
		System.out.println("reader release");
		if (readHold == 0){
			notifyAll(); //allow to use when no writer using
		}
		//returns value read
		return output;
	}
}
