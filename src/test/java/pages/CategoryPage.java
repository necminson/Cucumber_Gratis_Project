package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CategoryPage {
    public CategoryPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//ul[@class=\" links\"]/li")
    public static List<WebElement> urunKategorileri;
    @FindBy(xpath = "//h5[@class=\"title\"]")
    public static List<WebElement> sayfadakiUrunler;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    public static WebElement urundeSepeteEkle;
    @FindBy(xpath = "//span[@class=\"no-stock\"]")
    public static WebElement urundeStoktaYok;


}
