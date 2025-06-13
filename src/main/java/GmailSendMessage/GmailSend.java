package GmailSendMessage;

import AbstractClass.EmailSendClass;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class GmailSend extends EmailSendClass {

    public GmailSend(String myEmail, String sendEmail, String hostAdress, String password) {
        super(myEmail, sendEmail, hostAdress, password);
    }

    @Override
    public void addProperty(String key, String value) {
        super.addProperty(key, value);
    }

    public void gmailPuts(){
        addProperty("mail.smtp.host", "smtp.gmail.com");
        addProperty("mail.smtp.port", "465");
        addProperty("mail.smtp.auth", "true");
        addProperty("mail.smtp.socketFactory.port", "465");
        addProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    }
    @Override
    public Session getSessionInstance() {
        return super.getSessionInstance();
    }
    public void sendMail() {
        try {
            MimeMessage message = new MimeMessage(getSessionInstance());
            message.setFrom(new InternetAddress(myEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendEmail));
            message.setSubject("Topic");
            message.setText("Text");

            Transport.send(message);
            System.out.println("Email sent successfully.");

        } catch (MessagingException mex) {
            System.out.println("Send failed, exception: " + mex);
        }
    }
}

