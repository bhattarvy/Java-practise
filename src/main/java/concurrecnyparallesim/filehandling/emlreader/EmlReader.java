package concurrecnyparallesim.filehandling.emlreader;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.mail.util.MimeMessageParser;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;


public class EmlReader {


    public void readFile(String fileName) throws FileNotFoundException, MessagingException {

        InputStream mailFileInputStream = new FileInputStream(fileName);
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage message = new MimeMessage(session, mailFileInputStream);
        MimeMessageParser parser = new MimeMessageParser(message);

    }



}
