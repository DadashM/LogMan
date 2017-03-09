
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

public class MailSender {
	
	static final Logger log = Logger.getLogger(MailSender.class);
	
	public void sendWithAttachment(ScreenTaker screen) {
		
		Date date = new Date();
		SimpleDateFormat smp = new SimpleDateFormat("dd.MM.YYYY");

		final String username = "dadashmemmedli92@gmail.com";
		final String password = "MadinaDadash19911992!@";

		// Attach file=====================================
		String file = screen.filePath;
		String fileName = "Image - " + Listen.count++;
		//=================================================

		String from = "testnetlight@gmail.com";
		String to = "dadashmemmedli@hotmail.com";

		String host = "smtp.gmail.com";
		int port = 587;

		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);

	    Session session = Session.getInstance(props, new Authenticator()
	    {
	      protected PasswordAuthentication getPasswordAuthentication()
	      {
	        return new PasswordAuthentication(username, password);
	      }
	    });

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			
			//Edit this section==============================================
			message.setSubject("Unauthorized Access");
			message.setText(smp.format(date));
			//===============================================================

			MimeBodyPart messageBodyPart = new MimeBodyPart();

			Multipart multipart = new MimeMultipart();

			messageBodyPart = new MimeBodyPart();

			DataSource source = new FileDataSource(file);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(fileName);
			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);

			Transport.send(message);
			log.info("E-mail successfully sent");
		} catch (Exception e) {
			log.error("Error while sending e-mail : " + e.getMessage());
		}
	}
}
