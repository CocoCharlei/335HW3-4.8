package csci335;

public class Driver {

	public static void main(String[] args) {
		FileEditor fe = new FileEditor("File.txt");
		ReadWriteLock lock = new ReadWriteLock();
		Writer write = new Writer("W0", fe);
		Reader read = new Reader("R0", fe);
		Reader read1 = new Reader("R1", fe);
		Reader read2 = new Reader("R2", fe);
		Writer write1 = new Writer("W1", fe);


		
		write.start();
		read.start();
		read1.start();
		write1.start();
		read2.start();
		
//		write.join();
//		read.join();
//		read1.run();
//		read2.run();
//		write1.run();
		
	}

}
