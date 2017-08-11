import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 11/08/2017.
 */
public class ClothWebsitepManipulation
{
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a")
    private WebElement shirtbutton;

    @FindBy(xpath = "//*[@id=\"ul_layered_id_attribute_group_3\"]/li[1]/label/a")
    private WebElement orangeColourSelector;

    @FindBy(xpath = "//*[@id=\"color_1\"]")
    private WebElement orangeColourSelectorNxtImage;

    @FindBy(xpath = "//*[@id=\"quantity_wanted\"]")
    private WebElement quantityField;

    @FindBy(xpath = "//*[@id=\"add_to_cart\"]/button/span")
    private WebElement addToBasket;

    @FindBy(xpath = "//*[@id=\"layer_cart_product_quantity\"]")
    private WebElement checkoutQuantity;

    @FindBy(xpath = "//*[@id=\"layer_cart_product_title\"]")
    private WebElement checkoutProductName;




    public void moveToShirts()
    {
        shirtbutton.click();
    }

    public void clickOrange()
    {
        orangeColourSelector.click();
    }

    public void clickOrangeConfirm()
    {
        orangeColourSelectorNxtImage.click();
    }

    public void passQuantity(String quantity)
    {
        quantityField.sendKeys(quantity);
    }

    public  void addToBasket()
    {
        addToBasket.click();
    }

    public String checkQuantity ()
    {
        String checkoutQuantityV = checkoutQuantity.getText();
        return checkoutQuantityV;
    }

    public String checkProductName()
    {
        String checkoutProductNameV = checkoutProductName.getText();
        return checkoutProductNameV;
    }




}
