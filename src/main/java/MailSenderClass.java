import java.io.File;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class MailSenderClass {
 static void sendAttach(String message, String subject, String to, String from) {


		String host="smtp.gmail.com";
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES "+properties);
	
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");

		Session session=Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {				
				return new PasswordAuthentication("*******@gmail.com", "*******");
			}
		});
		
		session.setDebug(true);

		MimeMessage m = new MimeMessage(session);
		
		try {

		m.setFrom(from);

		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

		m.setSubject(subject);

		String path="*****";

		MimeMultipart mimeMultipart = new MimeMultipart();
		MimeBodyPart textMime = new MimeBodyPart();
		
		MimeBodyPart fileMime = new MimeBodyPart();
		
		try {
			
			textMime.setText(message);
			
			File file=new File(path);
			fileMime.attachFile(file);

			mimeMultipart.addBodyPart(textMime);
			mimeMultipart.addBodyPart(fileMime);

		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
		m.setContent(mimeMultipart);

		Transport.send(m);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

 static void sendEmail(String message, String subject, String to, String from) {

		String host="smtp.gmail.com";

		Properties properties = System.getProperties();
		System.out.println("PROPERTIES "+properties);

		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");

		Session session=Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {				
				return new PasswordAuthentication("*******@gmail.com", "******");
			}

		});
		
		session.setDebug(true);

		MimeMessage m = new MimeMessage(session);
		
		try {

		m.setFrom(from);

		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	
		m.setSubject(subject);

		m.setText(message);

		Transport.send(m);

		}catch (Exception e) {
			e.printStackTrace();
		}
			
	}
}
	

