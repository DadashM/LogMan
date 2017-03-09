import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class MyKeyListener implements NativeKeyListener {
	
	static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(MyKeyListener.class);
	
	int keyCode;
	
	public MyKeyListener() {
		initiliaze();
	}
	
	public void initiliaze(){
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            log.error("There was a problem registering the native hook : " + ex.getMessage());
            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(this);
		
		// Clear previous logging configurations.
		LogManager.getLogManager().reset();

		// Get the logger for "org.jnativehook" and set the level to off.
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.OFF);
	}
	
	@Override
	public void nativeKeyPressed(NativeKeyEvent arg0) {
				if (arg0.getKeyCode() == NativeKeyEvent.VC_SHIFT_L) {
					keyCode = arg0.getKeyCode();
				} else if (arg0.getKeyCode() == NativeKeyEvent.VC_D) {
					keyCode += arg0.getKeyCode();
					if (keyCode == 74) {
						log.info("Program Exited with ADMIN");
						System.exit(1);
					}
				}
				
		
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent arg0) {
		keyCode = 0;
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
