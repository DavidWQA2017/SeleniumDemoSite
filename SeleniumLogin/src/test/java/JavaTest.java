import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Administrator on 08/08/2017.
 */
public class JavaTest
{

    WebDriver webDriver;

    @Test
    public void test()
    {
        //create user for test
        webDriver.navigate().to("http://www.thedemosite.co.uk/addauser.php");
        webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")).sendKeys("usertest");
        webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")).sendKeys("usertest");
        webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")).click();

        //input login
        webDriver.navigate().to("http://www.thedemosite.co.uk/login.php");
        webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")).sendKeys("usertest");
        webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")).sendKeys("usertest");
        webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")).click();

        //check login is successful
        Assert.assertEquals("Login successful","**Successful Login**", webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText());
    }

    @After
    public void after() {
        System.out.println("after");
        webDriver.quit();
    }


    @Before
    public void before()
    {
        webDriver = new ChromeDriver();
    }

}
