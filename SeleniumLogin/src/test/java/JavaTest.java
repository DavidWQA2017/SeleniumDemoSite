import com.google.common.base.Function;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import java.util.function.Function;

import java.io.IOException;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by Administrator on 08/08/2017.
 */
public class JavaTest
{

    private WebDriver webDriver;
    private LoginClass logInPage;
    private CreateUserClass createUser;
    private Wait<WebDriver> wait;

    private static ExtentReports report;
    private static ExtentTest test;
    private static String reportFilePath = "C:\\Users\\Administrator\\IdeaProjects\\SeleniumLogin\\report.html";

    @Test
    public void test()
    {
        String filename = "IAMAFILE";
        //create user for test
        webDriver.navigate().to("http://www.thedemosite.co.uk/addauser.php");
        createUser.enterUsernName("usertest");
        createUser.enterPassword("usertest");
        createUser.createUser();
        //webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")).sendKeys("usertest");
        //webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")).sendKeys("usertest");
        //webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")).click();

        //input login
        webDriver.navigate().to("http://www.thedemosite.co.uk/login.php");

        //webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")).sendKeys("usertest");
        //webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")).sendKeys("usertest");
        //webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")).click();
        logInPage.enterUsernName("usertest");
        logInPage.enterPassword("usertest");
        logInPage.login();
        try
        {
            Screenshot.take(webDriver, filename);
            test.addScreenCaptureFromPath("C:\\Users\\Administrator\\IdeaProjects\\SeleniumLogin\\IAMAFILE.jpg");
        }
        catch (IOException e)
        {
            System.out.println("I broke");
        }



        //logInPage.login();
        Assert.assertEquals("Login unsuccessful","**Successful Login**", wait.until(webDriver -> webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText()));
        test.log(Status.PASS, "it has passed" );

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
        logInPage = PageFactory.initElements(webDriver,LoginClass.class);
        createUser = PageFactory.initElements(webDriver, CreateUserClass.class);
        wait = new FluentWait<WebDriver>(webDriver).withTimeout(10,SECONDS).pollingEvery(5 , SECONDS).ignoring(NoSuchElementException.class);

    }

    @BeforeClass
    public static void init(){
        report = new ExtentReports();
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportFilePath);
        extentHtmlReporter.config().setReportName("LoginTests");
        extentHtmlReporter.config().setDocumentTitle("DocumentTitle");
        report.attachReporter(extentHtmlReporter);
        test = report.createTest("TestName");
    }


   // @Test
   // public void myTestMethod(){
   ////     test.log(Status.INFO,"Info level");
    //    test.fail("Failed");
    //}

    @AfterClass
    public static void finishedTests()
    {
        report.flush();
    }
}
