package csci335;

public class Driver {

	public static void main(String[] args) {
		ReadWriteLock lock = new ReadWriteLock();
		Writer write = new Writer(lock);
		Reader read = new Reader(lock);
		Reader read1 = new Reader(lock);
		Reader read2 = new Reader(lock);
		Writer write1 = new Writer(lock);


		
		write.start();
		write1.start();
		read.start();
		read1.start();
		read2.start();
		
//		write.run();
//		read.run();
//		read1.run();
//		read2.run();
//		write1.run();
		
	}

}
