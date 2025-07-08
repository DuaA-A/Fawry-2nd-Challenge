// package com.bookstore;

// import java.net.Authenticator;
// import java.net.PasswordAuthentication;
// import java.util.Properties;
// import javax.mail.*;
// import javax.mail.internet.*;


// import java.util.Properties;

// public class MailService {
//     private static final String fromEmail = "dodoati4599@gmail.com";
//     private static final String pass = "gomv ormp eojd dqbe";

//     public static void send(String toEmail, String messageText) {
//         Properties props = new Properties();
//         props.put("mail.smtp.auth", "true");
//         props.put("mail.smtp.starttls.enable", "true");
//         props.put("mail.smtp.host", "smtp.gmail.com");
//         props.put("mail.smtp.port", "587");

//         Session session = Session.getInstance(props, new Authenticator() {
//             protected PasswordAuthentication getPasswordAuthentication() {
//                 return new PasswordAuthentication(fromEmail, pass);
//             }
//         });
//         try {
//             Message message = new MimeMessage(session);
//             message.setFrom(new InternetAddress(FROM_EMAIL));
//             message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
//             message.setSubject("Quantum Bookstore: Your Book is Here!");
//             message.setText(messageText);

//             Transport.send(message);
//             System.out.println("Quantum book store: Email sent to " + toEmail);

//         } catch (MessagingException e) {
//             e.printStackTrace();
//             System.out.println("Quantum book store: Failed to send email.");
//         }

// }
