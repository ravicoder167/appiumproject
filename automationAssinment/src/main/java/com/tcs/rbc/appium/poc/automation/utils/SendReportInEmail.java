package com.tcs.rbc.appium.poc.automation.utils;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.tcs.rbc.appium.poc.automation.pageobject.PageObjectBase;

public class SendReportInEmail extends PageObjectBase {
   public static void sendMail() {
      

      Properties props = new Properties();
      props.put("mail.smtp.host", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", "smtp.gmail.com");
      props.put("mail.smtp.port", "587");
      props.put("mail.smtp.auth", "true");
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(testConfigModel.getExecutionConfig().getProperty(Constants.USERID), testConfigModel.getExecutionConfig().getProperty(Constants.MAIL_PASSWORD));
            }
         });

      try {
         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress(testConfigModel.getExecutionConfig().getProperty(Constants.SENDER)));
         message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(testConfigModel.getExecutionConfig().getProperty(Constants.RECIPIENT)));
         message.setSubject("Execution Report");
         BodyPart messageBodyPart = new MimeBodyPart();
         messageBodyPart.setText("Please find attached execution Report");
         Multipart multipart = new MimeMultipart();
         multipart.addBodyPart(messageBodyPart);
         messageBodyPart = new MimeBodyPart();
         String filename = testConfigModel.getExecutionConfig().getProperty(Constants.TEST_RESULT_PATH)+".zip";
         try {
			Zip.zipFolder(testConfigModel.getExecutionConfig().getProperty(Constants.TEST_RESULT_PATH), filename);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         DataSource source = new FileDataSource(filename);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(filename);
         multipart.addBodyPart(messageBodyPart);
         message.setContent(multipart);
         Transport.send(message);

         System.out.println("Sent message successfully....");
  
      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
   }
}
