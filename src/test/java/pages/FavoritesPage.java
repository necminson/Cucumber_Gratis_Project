package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class FavoritesPage {
    public FavoritesPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class=\"favorites\"]")
    public static WebElement favorilerimButonu;
    @FindBy(xpath = "//*[.=\"Favori Listelerim\"]")
    public static WebElement favoriListelerimYazisi;
    @FindBy(xpath = "//ng-select")
    public static WebElement istekListesiSecinDrop;
    @FindBy(xpath = "//span[.=\" Yeni İstek Listesi... \"]")
    public static WebElement yeniIstekListesi;
    @FindBy(xpath = "//input[@placeholder=\"Adı\"]")
    public static WebElement listeAdiYazmaKutusu;
    @FindBy(xpath = "//button[contains(text(),\"Ekle\")]")
    public static WebElement listeAdiEkleButonu;
    @FindBy(xpath = "(//button[contains(text(),\"Ekle\")])[2]")
    public static WebElement isteklisteneEkleButonu;
    @FindBy(xpath = "//a[@class=\"round-btns\"]")
    public static WebElement alisveriseBaslaButonu;
    @FindBy(xpath = "//button[contains(@class,'add-btns')]")
    public static WebElement favorilereEkleButonu;
    @FindBy(xpath = "//select[@formcontrolname=\"C\"]")
    public static WebElement istekListesineEkleKutusu;

}
