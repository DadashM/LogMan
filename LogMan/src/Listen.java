import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;

public class Listen{
	
	static final Logger log = Logger.getLogger(Listen.class);
	
	int delay = 7000;
	int period = 30000;
	static int count;
	Timer timer = new Timer();
	
	public Listen(MailSender mail, ScreenTaker screen) {
		startToListen(mail, screen);
	}
	
	
	public void startToListen(MailSender mail, ScreenTaker screen){

		final TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				log.info("Listen Thread started");
				//take screen
				screen.takeScreen();
				//send mail
				mail.sendWithAttachment(screen);
				log.info("Listen Thread finished");
			}
		};
		
		timer.schedule(task, delay, period);
		



				
	}
	
}
