package csci335;

public class Reader extends Thread{
	private String threadName;
	private FileEditor fileEditor;
	
//	Reader(String name){
//		readThread = name; //allow to create instance of thread
//	}
	public Reader(String name, FileEditor fe){
		fileEditor = fe;
		//give same version of class to all threads
		threadName = name;
	}
	
	public void run(){
		fileEditor.readFile(threadName);
	}
	
	
}
