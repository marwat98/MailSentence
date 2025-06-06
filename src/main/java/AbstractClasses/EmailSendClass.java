package AbstractClasses;

import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public abstract class EmailSendClass {
    protected final String myEmail;
    protected final String sendEmail;
    protected final String hostAdress;
    Properties props = new Properties();


    public EmailSendClass(String myEmail,String sendEmail, String hostAdress){
        this.myEmail = myEmail;
        this.sendEmail = sendEmail;
        this.hostAdress = hostAdress;
    }

    public Properties getConfigureMail(String stmpHostName, String serwerMail){
        return (Properties) props.put(stmpHostName,serwerMail);
    }
    public Session getSessionInstance(Authenticator authenticator){
        return Session.getInstance(props,)
    }


}
