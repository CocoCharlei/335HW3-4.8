package csci335;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;

public class FileEditor {

	private String fileName;
	
	private ReadWriteLock lock = new ReadWriteLock();
	
	public FileEditor (String fileName){
		//set file name to input
		this.fileName = fileName;
	}
	public void readFile(String threadName){
		try {
			//reader holds the file
			lock.readLock(threadName);
			FileInputStream fileReader = new FileInputStream(fileName);
			//sets info read from file to num
			int num = fileReader.read();
			//TODO make threadName variable to identify threads
			System.out.println("Reader " + threadName + " read " + num + " from file");
			lock.readUnlock(threadName);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public void writeFile(String threadName){
		try {
			//reader holds the file
			lock.writeLock(threadName);
			FileOutputStream fileWriter = new FileOutputStream(fileName);
			Random rand = new Random();
			int num = rand.nextInt(10);
			fileWriter.write(num);
			System.out.println("Writer " + threadName + " wrote " + num + " on file");
			lock.writeUnlock(threadName);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
