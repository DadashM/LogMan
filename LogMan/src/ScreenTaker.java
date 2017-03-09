import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

public class ScreenTaker {
	
	static final Logger log = Logger.getLogger(ScreenTaker.class);

	String filePath = System.getProperty("user.home") + "\\AppData\\Local\\Logman\\" + "mada.jpg";
	String folderPath = System.getProperty("user.home") + "\\AppData\\Local\\Logman\\";
			
	File createFolder = new File(folderPath);
	
	
	public void takeScreen(){
		try {
			
			if (!createFolder.exists()) {
				createFolder.mkdir();
				log.info("Logman folder does't exist and is created");
			}
			log.info("Logman folder is exist");
			
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(image, "JPG", new File(filePath));
			log.info("Screen successfully captured");
		
		} catch (HeadlessException e) {
			log.error("HeadlessException error occurred : " + e.getMessage());
		} catch (AWTException e) {
			log.error("AWTException error occurred : " + e.getMessage());
		} catch (IOException e) {
			log.error("IOException error occurred : " + e.getMessage());
		}
	}
	
}
