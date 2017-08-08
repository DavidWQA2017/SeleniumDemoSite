import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Administrator on 08/08/2017.
 */
public class JavaTest
{

    WebDriver webDriver;

    @Test
    public void test() {
        webDriver.navigate().to("TheDemoSite.co.uk");
        //webDriver.findElement(By.cssSelector("li.navigation-list-item:nth-child(2) > div:nth-child(1)")).click();

        //try {
        //  Thread.sleep(10000);
        //webDriver.wait(1000);
        //} catch (InterruptedException e) {
        // e.printStackTrace();
        //  }
        //webDriver.findElement(By.cssSelector("article.promocard:nth-child(1) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")).click();


    }

    @After
    public void after() {
        System.out.println("after");
        webDriver.quit();
    }


    @Before
    public void before() {
        /*ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\Administrator\\IdeaProjects\\junittesting\\chromedriver.exe");*/
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\IdeaProjects\\junittesting\\src\\chromedriver.exe");
        webDriver = new FirefoxDriver();
        //System.out.println("before");
    }

}
