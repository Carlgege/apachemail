package com.ikentop.demo.apachemail;

import org.apache.commons.mail.*;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;

import java.net.URL;

/**
 * @author : Huqiao
 * @since : 2017/10/12
 */
public class ApacheMail {
    private static String hostname = "smtp.163.com";
    //    private static int smtppost = 465;
    private static String path = "src\\main\\resources\\image\\image.jpg";
    private static String urlpath = "http://www.apache.org/images/asf_logo_wide.gif";

    /**
     * @param username 用户名
     * @param password 密码
     * @param from     发件人
     * @param to       收信人
     * @throws EmailException
     * @describe 发送内容为简单文本的邮件
     */
    public static void sendSimpleTextEmail(String username, String password, String from, String to) throws EmailException {
        Email email = new SimpleEmail();
        //连接参数配置
        email.setHostName(hostname);
//        email.setSmtpPort(smtppost);
        email.setAuthentication(username, password);
        email.setSSLOnConnect(true);
        //邮件相关
        email.setFrom(from);
        email.setSubject("TestMail");
        email.setMsg("This is a test mail");
        email.addTo(to);
        email.send();
    }

    /**
     * @param username 用户名
     * @param password 密码
     * @param from     发件人
     * @param to       收信人
     * @throws EmailException
     * @describe 发送包含附件的邮件（附件为本地资源）
     */
    public static void sendEmailWithAttachments(String username, String password, String from, String to) throws EmailException {
        //附件
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath(path);
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("Picture of Hqq");
        //邮件
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName(hostname);
        email.setAuthentication(username, password);
        email.setFrom(from);
        email.addTo(to);
        email.setSubject("sendEmailWithAttachments");
        email.setMsg("this is sendEmailWithAttachments");
        email.attach(attachment);
        email.send();
    }

    /**
     * @param username 用户名
     * @param password 密码
     * @param from     发件人
     * @param to       收信人
     * @throws Exception
     * @describe 发送包含附件的邮件（附件为在线资源）
     */
    public static void sendEmailsWithOnlineAttachments(String username, String password, String from, String to) throws Exception {
        //附件
        EmailAttachment attachment = new EmailAttachment();
        attachment.setURL(new URL(urlpath));
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("Picture of Hqq");
        //邮件
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName(hostname);
//        email.setSmtpPort(smtppost);
        email.setAuthentication(username, password);
        email.setFrom(from);
        email.addTo(to);
        email.setSubject("sendEmailsWithOnlineAttachments");
        email.setMsg("this is sendEmailsWithOnlineAttachments");
        //添加附件
        email.attach(attachment);
        email.send();
    }

    /**
     * @param username 用户名
     * @param password 密码
     * @param from     发件人
     * @param to       收信人
     * @throws Exception
     * @describe 发送内容为HTML格式的邮件
     */
    public static void sendHTMLFormattedEmail(String username, String password, String from, String to) throws Exception {
        //create the email message
        HtmlEmail email = new HtmlEmail();
        email.setHostName(hostname);
        email.setAuthentication(username, password);
        email.setFrom(from);
        email.addTo(to);
        email.setSubject("sendHTMLFormattedEmail");
        //嵌入图像并获取内容id
        URL url = new URL(urlpath);
        String cid = email.embed(url, "Apache logo");
        // 设置 html message
        email.setHtmlMsg("<html>The apache logo - <img src=\"cid:" + cid + "\"></html>");
        //设置 alternative message
        email.setTextMsg("Your email client does not support HTML messages");
        email.send();
    }

    /**
     * @param username 用户名
     * @param password 密码
     * @param from     发件人
     * @param to       收信人
     * @throws Exception
     * @describe 发送内容为HTML格式的邮件
     */
    public static void sendHTMLFormattedEmailWithEmbeddedImages(String username, String password, String from, String to) throws Exception {
        //加载您的HTML电子邮件模板
        String htmlEmailTemplete = ".... <img src=\\\"http://www.apache.org/images/feather.gif\\\"> ....";
        URL url = new URL("http://www.apache.org");

        ImageHtmlEmail email = new ImageHtmlEmail();
        email.setDataSourceResolver(new DataSourceUrlResolver(url));
        email.setHostName(hostname);
        email.setAuthentication(username,password);
        email.setFrom(from);
        email.addTo(to);
        email.setSubject("sendHTMLFormattedEmailWithEmbeddedImages");
        email.setHtmlMsg(htmlEmailTemplete);
        email.setTextMsg("Your email client does not support HTML messages");

        email.send();
    }


}
