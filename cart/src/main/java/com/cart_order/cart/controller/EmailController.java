package com.cart_order.cart.controller;

import com.cart_order.cart.Email;
import com.cart_order.cart.dto.MailProductDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/email")
public class EmailController {

    @Value("${gmail.username}")
    private String username;

    @Value("${gmail.password}")
    private String password;

    @PostMapping(value="/send/{email}")
    public String sendEmail(@RequestBody List<MailProductDto> mailProductDtos, @PathVariable("email") String email)  throws AddressException, MessagingException,IOException
    {

        Email emailMsg=new Email();
        emailMsg.setToAddress(email);
        emailMsg.setSubject("Shopping Bee : Order Details");
        String details="Thank you for ordering from SHOPPING BEE.Your order details are :\n";
        for(int i=0;i<mailProductDtos.size();i++)
        {
            details=details+" "+mailProductDtos.get(i).getProductName();
            details=details+" "+mailProductDtos.get(i).getQuantity();
            details=details+" "+mailProductDtos.get(i).getPrice();
            details=details+"\n";
        }
        emailMsg.setBody(details);
        System.out.println(emailMsg);
        sendMail(emailMsg);
        return "Email sent successfully";
    }

    private void sendMail(Email email) throws AddressException, MessagingException,IOException
    {
        Properties props=new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(username, false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getToAddress()));
        msg.setSubject(email.getSubject());
        msg.setContent(email.getBody(), "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("Tutorials point email", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
      //  MimeBodyPart attachPart = new MimeBodyPart();

//        attachPart.attachFile("");
//        multipart.addBodyPart(attachPart);
//        msg.setContent(multipart);
        Transport.send(msg);
    }
}
