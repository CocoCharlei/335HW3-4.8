package csci335;

public class Writer extends Thread {
	private String writeThread;
	//instance of lock class
	private final ReadWriteLock lock;
	
	public Writer(ReadWriteLock lock){
		//give same version of class to all threads
		this.lock = lock;
	}
	public void run(){
		try {
			//calls lock with value 3
			lock.writer(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
