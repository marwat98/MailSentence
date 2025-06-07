package AbstractClasses;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public abstract class EmailSendClass {
    protected final String myEmail;
    protected final String sendEmail;
    protected final String hostAdress;
    protected final String password;
    protected final Properties props = new Properties();

    public EmailSendClass(String myEmail,String sendEmail, String hostAdress, String password){
        this.myEmail = myEmail;
        this.sendEmail = sendEmail;
        this.hostAdress = hostAdress;
        this.password = password;
    }
    // methos which add key and value to put method of Properties class
    public void addProperty(String key, String value) {
        props.put(key, value);
    }
    // method which get session instance and apply email and password needed to veryfication with email post api
    public Session getSessionInstance(){
        return Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myEmail,password);
            }
        });
    }
}
