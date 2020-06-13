import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class Send {

    public static void main() {
        try {
            Email email = new SimpleEmail();

            // Configuration
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator(Constants.INPUT_EMAIL,
                    Constants.INPUT_PASSWORD));

            // Required for gmail
            email.setSSLOnConnect(true);

            // Sender
            email.setFrom(Constants.INPUT_EMAIL);

            // Email title
            email.setSubject("Test Email");

            // Email message.
            email.setMsg(Constants.TEST_MES);

            // Receiver
            email.addTo(Constants.OUTPUT_EMAIL);
            email.send();
            System.out.println("Sent!!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}