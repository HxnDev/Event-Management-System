package sample;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class emailClass {

    private static String start = "<body style=\"background-color:mintcream;\"> <h1 style = \"color:firebrick;text-align:center\">A.S.H Event Planners </h1><p style = \"color:black;font-family:calibri;font-size:120%\">Dear User,</p> <p style = \"color:black;font-family:calibri;font-size:120%\"> ";
    private static String temp;
    private static String temp2 = "</p> <p style = \"color:black;font-family:calibri;font-size:120%\">Thank you for using A.S.H Planners.</p> <h1 style = \"color:firebrick;font-family:calibri;text-align:center\">Have a great day. :) </h1> </body>";
    private static String finalstring;

    private static Properties props;
    private static String username;
    private static String password;

    public static void setProps(Properties props) {
        emailClass.props = props;
    }
    public static Properties getProps() {
        return props;
    }

    public static String getUsername() {
        return username;
    }
    public static void setUsername(String username) {
        emailClass.username = username;
    }

    public static String getPassword() {
        return password;
    }
    public static void setPassword(String password) {
        emailClass.password = password;
    }

    public static void init(Properties prop, String name, String pass) {
        props = prop;
        username = name;
        password = pass;

        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        // Get a Properties object
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.store.protocol", "pop3");
        props.put("mail.transport.protocol", "smtp");
    }

    public static void sendEmail(String subject, String msg_to_send, String receiver) {

        temp = start + msg_to_send;
        finalstring = temp + temp2;
        try {
            Session session = Session.getDefaultInstance(props, new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    }
            );

            session.setDebug(false);

            // new message
            Message msg = new MimeMessage(session);
            // sender email address
            msg.setFrom(new InternetAddress(username));
            // receiver email address
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(receiver, false));

            // email subject
            msg.setSubject(subject);
            // email text
            msg.setContent(finalstring, "text/html");
            // email date
            msg.setSentDate(new Date());

            // send email
            Transport.send(msg);

            System.out.println("Message sent.");

        } catch (MessagingException e) {
            System.out.println("Error, cause: " + e);
        }
    }
}