package service;

import bean.Account;
import org.apache.tomcat.util.buf.Utf8Encoder;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.Random;


public class SendMail {



    public String getRandom(){
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d",number);

    }

    //send simble mail
    public boolean sendMail(Account acc, String code)
    {
    boolean check = false;
        String to = acc.getEmail();
        String from = "petshop.ltweb@gmail.com";
        String pass = "blxjhfybsiqkzeso";

        //create an instance of Properties Class
        Properties props = new Properties();

        /*  Specifies the IP address of your default mail server
     	      for e.g if you are using gmail server as an email sever
            you will pass smtp.gmail.com as value of mail.smtp host.
            As shown here in the code.
            Change accordingly, if your email id is not a gmail id
        */
        props.put("mail.smtp.host", "smtp.gmail.com");
        // below mentioned mail.smtp.port is optional
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        /* Pass Properties object(props) and Authenticator object
           for authentication to Session instance
        */

        Session session = Session.getInstance(props,new Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(from,pass);
            }
        });

        try {
            String random = getRandom();

            String user ="PETShop";
            String sub = "THAY ĐỔI MẬT KHẨU";
            String msg ="Chào "+ acc.getUser_name()  +", đây là mã dùng để xác thực tài khoản của bạn: " + code ;

            MimeMessage message = new MimeMessage(session);
            message.setHeader("Content-Type", "text/plain; charset=UTF-8");
            message.setFrom(new InternetAddress(user, "PET Shop"));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject(sub, "utf-8");
            message.setText(msg,"utf-8");

            /* Transport class is used to deliver the message to the recipients */

            Transport.send(message);
            check = true;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
