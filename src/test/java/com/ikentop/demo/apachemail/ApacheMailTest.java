package com.ikentop.demo.apachemail;

import com.ikentop.demo.ApachemailApplication;
import org.apache.commons.mail.EmailException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author : Huqiao
 * @since : 2017/10/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApachemailApplication.class)
public class ApacheMailTest {
    private String username = "xxxxxx";
    private String password = "xxxxxx";
    private String from = "xxxx@xx.com";
    private String to = "xxxx@xx.com";


    @Test
    public void testSendSimpleTextEmail() throws EmailException {
        ApacheMail.sendSimpleTextEmail(username, password, from, to);
    }

    @Test
    public void testSendEmailWithAttachments() throws EmailException {
        ApacheMail.sendEmailWithAttachments(username, password, from, to);
    }
    @Test
    public void testSendEmailsWithOnlineAttachments() throws Exception {
        ApacheMail.sendEmailsWithOnlineAttachments(username, password, from, to);
    }

    @Test
    public void testSendHTMLFormattedEmail() throws Exception {
        ApacheMail.sendHTMLFormattedEmail(username, password, from, to);
    }

    @Test
    public void testSendHTMLFormattedEmailWithEmbeddedImages() throws Exception {
        ApacheMail.sendHTMLFormattedEmailWithEmbeddedImages(username, password, from, to);
    }
}