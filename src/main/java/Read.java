import javax.mail.*;
import javax.mail.internet.InternetAddress;
import java.io.IOException;
import java.util.Properties;

public class Read{
    public static String test;

    public static void main() throws MessagingException {
        Properties properties = new Properties();
        properties.setProperty("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        Session session = Session.getDefaultInstance(properties);

        Store store = null;
        try {

            store = session.getStore("imap");
            store.connect("imap.yandex.ru", 993, Constants.OUTPUT_EMAIL,Constants.OUTPUT_PASSWORD);
            Folder inbox = null;
            try {
                inbox = store.getFolder("INBOX");
                inbox.open(Folder.READ_ONLY);
                int count = inbox.getMessageCount();
                Message[] messages = inbox.getMessages(1, count);

                    for (Message message : messages) {
                        String from = ((InternetAddress) message.getFrom()[0]).getAddress();
                        if (from.equals(Constants.INPUT_EMAIL))
                        {
                           // System.out.println("FROM: " + from);
                           // System.out.println("SUBJECT: " + message.getSubject());
                            //System.out.println("Text:" + message.getContent().toString());
                            test= message.getContent().toString();


                        }


                    }
                    //System.out.println(test);


            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inbox != null) {
                    inbox.close(false);
                }
            }

        } finally {
            if (store != null) {
                store.close();
            }
        }
    }
}