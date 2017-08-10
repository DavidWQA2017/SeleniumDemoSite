import com.google.common.base.Function;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import java.util.function.Function;

import java.awt.*;
import java.io.IOException;
import java.util.List;

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
    private static ExtentTest test2;
    private static ExtentTest test3;

    private static String reportFilePath = "C:\\Users\\Administrator\\IdeaProjects\\SeleniumLogin\\report.html";

    @Test
    public void test()
    {
        String filename = "ScreenShotTest1";
        String[] spreadsheetInfo = new String[4];
        int i = 0;

        SpreadSheet sheetReader = new SpreadSheet(System.getProperty("user.dir") + "/src/main/resources/TestInfo.xlsx");
        List<String> row = sheetReader.readRow(1, "TestSheet");

        for(String cell : row)
        {
            spreadsheetInfo[i] = cell;
            i++;
        }

        String testID = spreadsheetInfo[0];
        String testDescrip = spreadsheetInfo[1];
        String testUsername = spreadsheetInfo[2];
        String testPassword = spreadsheetInfo[3];





        //create user for test
        webDriver.navigate().to("http://www.thedemosite.co.uk/addauser.php");
        createUser.enterUsernName(testUsername);
        test.log(Status.INFO, "username has been created");
        createUser.enterPassword(testPassword);
        test.log(Status.INFO, "password has been created for the account");
        createUser.createUser();
        test.log(Status.INFO, "user has been created");
        //webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")).sendKeys("usertest");
        //webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")).sendKeys("usertest");
        //webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")).click();

        //input login
        webDriver.navigate().to("http://www.thedemosite.co.uk/login.php");
        //webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")).sendKeys("usertest");
        //webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")).sendKeys("usertest");
        //webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")).click();
        logInPage.enterUsernName(testUsername);
        test.log(Status.INFO, "username has been entered");
        logInPage.enterPassword(testPassword);
        test.log(Status.INFO, "password has been entered");
        logInPage.login();
        test.log(Status.INFO, "login has been attempted");
        try
        {
            Screenshot.take(webDriver, filename);
            test.addScreenCaptureFromPath("C:\\Users\\Administrator\\IdeaProjects\\SeleniumLogin\\IAMAFILE.jpg");
            test.log(Status.INFO, "a screenshot of the login attempt has been created  ");
        }
        catch (IOException e)
        {
            test.log(Status.WARNING, "Screenshot could not be taken input/output exception" + e);
        }



        //logInPage.login();
        Assert.assertEquals("Login unsuccessful","**Successful Login**", wait.until(webDriver -> webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText()));
        test.log(Status.PASS, "Log in is successful" );

    }

    @Test
    public void LoginFail_Test()
    {

        String filename = "ScreenShotTest2";
        String[] spreadsheetInfo = new String[4];
        int i = 0;

        SpreadSheet sheetReader = new SpreadSheet(System.getProperty("user.dir") + "/src/main/resources/TestInfo.xlsx");
        List<String> row = sheetReader.readRow(2, "TestSheet");

        for(String cell : row)
        {
            spreadsheetInfo[i] = cell;
            i++;
        }

        String testID = spreadsheetInfo[0];
        String testDescrip = spreadsheetInfo[1];
        String testUsername = spreadsheetInfo[2];
        String testPassword = spreadsheetInfo[3];



        //create user for test
        webDriver.navigate().to("http://www.thedemosite.co.uk/addauser.php");
        createUser.enterUsernName("usertest");
        test2.log(Status.INFO, "username has been created");
        createUser.enterPassword(testPassword);
        test2.log(Status.INFO, "password has been created for the account");
        createUser.createUser();
        test2.log(Status.INFO, "user has been created");


        //input login
        webDriver.navigate().to("http://www.thedemosite.co.uk/login.php");
        logInPage.enterUsernName(testUsername);
        test2.log(Status.INFO, "username has been entered");
        logInPage.enterPassword(testPassword);
        test2.log(Status.INFO, "password has been entered");
        logInPage.login();
        test2.log(Status.INFO, "login has been attempted");

        try
        {
            Screenshot.take(webDriver, filename);
            test2.addScreenCaptureFromPath("C:\\Users\\Administrator\\IdeaProjects\\SeleniumLogin\\ScreenshotTest2.jpg");
            test2.log(Status.INFO, "a screenshot of the login attempt has been created  ");
        }
        catch (IOException e)
        {
            test2.log(Status.WARNING, "Screenshot could not be taken input/output exception" + e);
        }


        //logInPage.login();
        try
        {
            Assert.assertEquals("Login unsuccessful", "**Successful Login**", wait.until(webDriver -> webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText()));
            test2.log(Status.PASS, "Log in is successful" );
        }
        catch (AssertionError e)
        {
            test2.log(Status.FAIL, "could not login" );
        }

    }

    @Test
    public void Draggable_Test ()
    {

        webDriver.manage().window().maximize();
        webDriver.navigate().to("http://demoqa.com");
        webDriver.findElement(By.cssSelector("#menu-item-140")).click();
        ; //thing to be dragged
        Actions builder = new Actions(webDriver);
        Point location = wait.until(webDriver1 ->  webDriver.findElement(By.cssSelector("#draggable")).getLocation());
        System.out.println("before movement x is " + location.getX());
        System.out.println("before movement y is "  + location.getY());
        //Point p = MouseInfo.getPointerInfo().getLocation();


        System.out.println();
        builder.moveToElement(webDriver.findElement(By.cssSelector("#draggable"))).clickAndHold().moveByOffset(360,0).release().build().perform();
        location = wait.until(webDriver1 ->  webDriver.findElement(By.cssSelector("#draggable")).getLocation());
        System.out.println("before movement x is " + location.getX());
        System.out.println("before movement y is "  + location.getY());

        Assert.assertEquals(935, location.getX());

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
        test2 = report.createTest("TestName");
        test3 = report.createTest("TestName");
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
