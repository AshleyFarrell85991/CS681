
public class Main {

	public static void main(String[] args) {
		File file = new File();
		Editor editor = new Editor(file);
		AutoSaver autosaver = new AutoSaver(file);
		
	Thread threadeditor = new Thread(editor);
	Thread threadautosaver = new Thread(autosaver);
	
	threadeditor.start();
	threadautosaver.start();
	try {
System.out.println("Threads executing w/ delay");

		Thread.sleep(2000);

	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	
	editor.setDone();
	autosaver.setDone();
	
		
		
	}

}
