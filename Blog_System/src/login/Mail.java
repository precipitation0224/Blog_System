package login;

import java.io.IOException;
import java.util.Date;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	public static String emailAccount = "Sry_Blog@163.com";
	public static String emailPassword = "tp52006211999";
	public static String emailSMTPHost = "smtp.163.com";
	public static String receiveMailAccount = "";
	public static  MimeMessage creatMimeMessage(Session session,String sendMail,String receiveMail,String html) throws MessagingException, IOException {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(sendMail, "你的博客小助手", "UTF-8"));
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "", "UTF-8"));
		message.setSubject("邮箱验证","UTF-8");
		message.setContent(html,"text/html;charset=UTF-8");
		message.setSentDate(new Date());
		message.saveChanges();
		return message;
	} 
}
