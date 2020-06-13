import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import javax.mail.MessagingException;

public class FirstTest  {
    public ChromeDriver driver;

    @Before
    public void setup() {
       System.out.println("test start");

    }

    @Test
    public void firstTest() throws InterruptedException, MessagingException {
        Send.main();
        Read.main();
        Thread.sleep(10000);
        Assert.assertEquals(Read.test.replaceAll("\\n|\\r", ""),(Constants.TEST_MES));
    }

    @After
    public void exit() {
        System.out.println("test stop");
    }

}
