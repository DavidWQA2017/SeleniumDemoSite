/**
 * Created by Administrator on 08/08/2017.
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginClass
{
    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")
    private WebElement usernameInput;

    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")
    private WebElement passwordInput;

    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")
    private WebElement submitdButton;

    public void enterUsernName(String username)
    {
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password)
    {
        passwordInput.sendKeys(password);
    }

    public void login()
    {
        submitdButton.click();
    }


}
