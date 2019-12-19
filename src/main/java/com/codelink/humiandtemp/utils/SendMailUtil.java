package com.codelink.humiandtemp.utils;


import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class SendMailUtil {
    private static String sendEmailAccount;
    private static String sendEmailPassword;
    private static String sendEmailSMTPHost;
    private static String receviceMailAccount;
    static {
        try {
            Properties pro = new Properties();
            InputStream is = SendMailUtil.class.getClassLoader().getResourceAsStream("mail.properties");
            pro.load(is);
            sendEmailAccount = pro.getProperty("sendEmailAccount");
            sendEmailPassword = pro.getProperty("sendEmailPassword");
            sendEmailSMTPHost = pro.getProperty("sendEmailSMTPHost");
            receviceMailAccount = pro.getProperty("receviceMailAccount");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void sendMail() throws MessagingException, UnsupportedEncodingException{
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol","smtp");
        props.setProperty("mail.smtp.host",sendEmailSMTPHost);
        props.setProperty("mail.smtp.auth","true");
        Session session = Session.getInstance(props);
        session.setDebug(true);
        MimeMessage message = createMimeMessage(session,sendEmailAccount,receviceMailAccount);
        Transport transport = session.getTransport();
        transport.connect(sendEmailAccount,sendEmailPassword);
        transport.sendMessage(message,message.getAllRecipients());
        transport.close();
    }

    private static MimeMessage createMimeMessage(Session session, String myEmailAccount, String receviceMailAccount) throws UnsupportedEncodingException, MessagingException{
        //创建一封邮件
        MimeMessage message = new MimeMessage(session);
        //2.设置参数
        message.setFrom(new InternetAddress(myEmailAccount,"李豪杰","utf-8"));
        message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(receviceMailAccount,"系统管理员","UTF-8"));
        message.setSubject("工作","UTF-8");
        message.setContent("<table style=\"width: 538px; background-color: #393836;\" align=\"center\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "\t<tbody><tr>\n" +
                "\t\t<td style=\"height: 65px; background-color: #171a21; border-bottom: 1px solid #4d4b48; padding: 0px;\">\n" +
                "\t\t\t<div width=\"538\" height=\"65\" style=\"font-size: 30px;color: #ffffff;text-align: center\">温湿度监测中心</div>\n" +
                "        </td>\n" +
                "\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td bgcolor=\"#17212e\">\n" +
                "\t\t\t<table width=\"470\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"padding-left: 5px; padding-right: 5px; padding-bottom: 10px;\">\n" +
                "\t\t\t\t<tbody><tr bgcolor=\"#17212e\">\n" +
                "\t\t\t\t\t<td style=\"padding-top: 32px; padding-bottom: 16px;\">\n" +
                "\t\t\t\t\t<span style=\"font-size: 24px; color: #66c0f4; font-family: Arial, Helvetica, sans-serif; font-weight: bold;\">\n" +
                "\t\t\t\t\t\t亲爱的系统管理员：\n" +
                "\t\t\t\t\t</span><br>\n" +
                "\t\t\t\t\t</td>\n" +
                "\t\t\t\t</tr>\n" +
                "     \t\t\t<tr>\n" +
                "\t\t\t\t\t<td style=\"padding-top: 12px; padding-bottom: 24px;\">\n" +
                "\t\t\t\t\t<span style=\"padding-top: 12px; font-size: 18px; color: #c6d4df; font-family: Arial, Helvetica, sans-serif; font-weight: normal;\">\n" +
                "\t\t\t\t\t\t<p>\n" +
                "\t\t\t\t\t\t\t这是一封系统自动发送的提示邮件，请在收到后立即处理\n" +
                "\t\t\t\t\t\t</p>\n" +
                "\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t</td>\n" +
                "\t\t\t\t</tr>\n" +
                "                <tr bgcolor=\"#121a25\">\n" +
                "\t\t\t\t\t<td style=\"padding: 20px; font-size: 12px; line-height: 17px; color: #c6d4df; font-family: Arial, Helvetica, sans-serif;\">\n" +
                "\t\t\t\t\t\t<table width=\"420\" cellspacing=\"4\" style=\" font-size: 11px; color: #c6d4df; font-family: Arial, Helvetica, sans-serif; align: left  \" x-western=\"x-western\">\n" +
                "\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t<h1 style=\"color: #ff0000;text-align: center\"> 系统警告：温度太高请立即处理</h1>\n" +
                "\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t</table>\n" +
                "\t\t\t\t\t</td>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t\t<tr>\n" +
                "                \t<td style=\"font-size: 12px; line-height: 17px; color: #6d7880; padding-top: 16px; padding-bottom: 12px;\">\n" +
                "\t\t\t\t\t</td>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t\t<tr>\n" +
                "\t\t\t\t\t<td style=\"font-size: 12px; color: #6d7880; padding-top: 16px;\">\n" +
                "\n" +
                "\t\t\t\t\t</td>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t</tbody></table>\n" +
                "\t\t</td>\n" +
                "\t</tr>\n" +
                "\t<tr>\n" +
                "\t\t<td style=\"height: 65px; background-color: #171a21; border-bottom: 1px solid #4d4b48; padding: 0px;\">\n" +
                "\t\t\t<div width=\"538\" height=\"65\" style=\"color: #ffffff;text-align: center;font-size: 18px\">发送时间：2019年3月15日20:12:59</div>\n" +
                "\t\t</td>\n" +
                "\t</tr>\n" +
                "\n" +
                "</tbody></table>","text/html;charset=UTF-8");
        message.setSentDate(new Date());
        message.saveChanges();
        return message;
    }
}

