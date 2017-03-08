import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

public class Listen{
	
	int delay = 5000;
	
	public Listen() {
		startToListen();
	}
	
	
	public void startToListen(){
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				
			}
			
		}, delay);
		
	}
	
}
