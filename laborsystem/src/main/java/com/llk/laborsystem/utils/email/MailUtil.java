package com.llk.laborsystem.utils.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 推荐采用 163.com 电子邮箱，设置SMTP的授权密码比较简单
 *
 */
public class MailUtil {

    protected static String SmtpHost = "smtp.163.com";
    protected static String FromMail = "lilekang918@163.com";
    protected static String MailUserName = "lilekang918@163.com";
    protected static String MailUserPwd = "FZFAKXCQNMQMZKVZ";
    protected static String SmtpPort = "465";



    public static void sendText(String to, String subject, String content){

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", SmtpHost);
        props.put("mail.smtp.socketFactory.port", SmtpPort);

        // Get the Session object
        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(MailUserName, MailUserPwd);

                    }
                });


        try {
            // Create a default MimeMessage object
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(FromMail));

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // Set Subject
            message.setSubject(subject);

            // Put the content of your message
            message.setText(content);

            // Send message
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }



}

