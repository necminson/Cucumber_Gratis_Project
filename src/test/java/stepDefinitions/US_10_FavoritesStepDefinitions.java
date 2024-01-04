package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.CategoryPage;
import pages.FavoritesPage;
import pages.HomePage;
import utilities.BrowserUtilities;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

import static pages.CategoryPage.sayfadakiUrunler;
import static pages.FavoritesPage.*;
import static utilities.BrowserUtilities.*;
import static utilities.Driver.driver;
import static utilities.JSUtils.scrollIntoVIewJS;
import static utilities.ReusableMethods.*;


public class US_10_FavoritesStepDefinitions {
    FavoritesPage favori = new FavoritesPage();
    Actions action =new Actions(driver);
    int favoriUrunsayisi=0;


    @Given("kullanici Favori Listelerim sayfasina gider")
    public void kullanici_favori_listelerim_sayfasina_gider() {
       clickWithJS(BrowserUtilities.waitForVisibility(favorilerimButonu,30));
       ReusableMethods.waitFor(2);
    }
    @Then("Favori Listelerim sayfasina gittigini dogrular")
    public void favori_listelerim_sayfasina_gittigini_dogrular() throws IOException {
        Assert.assertTrue(BrowserUtilities.waitForVisibility(favoriListelerimYazisi,30).isDisplayed());
        scrollIntoVIewJS(favoriListelerimYazisi);
        takeScreenshotOfTheEntirePage();

    }
    @Given("Kullanici Yeni istek listesi acilir butonuna tiklar.")
    public void kullanici_yeni_istek_listesi_acilir_butonuna_tiklar() {
        action.click(istekListesiSecinDrop).perform();

    }
    @When("Acilan Yeni istek listesi sekmesini tiklar.")
    public void acilan_yeni_istek_listesi_sekmesini_tiklar() {
        action.click(yeniIstekListesi).perform();
           }
    @When("Acilan cercevede Adi kutusuna {string} yazar.")
    public void acilan_cercevede_adi_kutusuna_yazar(String liste_ismi) {
        BrowserUtilities.waitForVisibility(listeAdiYazmaKutusu,30).sendKeys(liste_ismi);
    }
    @When("Uc farkli gizlilik ayarindan birini secer.")
    public void uc_farkli_gizlilik_ayarindan_birini_secer() {
        // Default olarak Özel seçili gelir
    }
    @When("Ekle butonuna tiklar.")
    public void ekle_butonuna_tiklar() {
        clickWithJS(BrowserUtilities.waitForVisibility(listeAdiEkleButonu,30));
    }
    @Then("Yeni listenin olusturuldugunu dogrular")
    public void yeni_listenin_olusturuldugunu_dogrular() throws IOException {
        WebElement listeAdi =BrowserUtilities.waitForVisibility(driver.findElement(By.xpath("//div[@class=\"selected-wishlist-name\"]")),30);
        String expected = "Traş Malzemesi";
        String actual=listeAdi .getText();
        Assert.assertEquals("Oluşturulan Liste İsmi Doğrulanamadı",expected,actual);
        scrollIntoVIewJS(listeAdi);
        takeScreenshotOfTheEntirePage();
    }
    @Given("Alisverise Basla butonunu tiklar")
    public void Alisverise_Baslabutonunu_tiklar() {
        clickWithJS(BrowserUtilities.waitForVisibility(alisveriseBaslaButonu,30));
    }
    @Then("Butun ururnlerin listelendigi sayfanin acildigini dogrular")
    public void butun_ururnlerin_listelendigi_sayfanin_acildigini_dogrular() {
        ReusableMethods.waitFor(15);
        String expectedUrl ="https://www.gratis.com/search/:relevance?query=:relevance";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals("Ürünler Sayfasını açamadı",expectedUrl,actualUrl);
    }
    @When("Favoriye ekle butonunu tiklar")
    public void Favoriye_ekle_butonunu_tiklar() {
        ReusableMethods.waitFor(15);
        BrowserUtilities.clickWithJS(BrowserUtilities.waitForVisibility(favorilereEkleButonu,30));
           }
    @When("Acilan  cercevede'Istek listesi secin' acilir butonundan bir istek listesine tiklar")
    public void acilan_cercevede_istek_listesi_secin_acilir_butonundan_bir_istek_listesine_tiklar() {
        ReusableMethods.waitFor(15);
                action.moveToElement(isteklisteneEkleButonu).click().perform();
    }
    @Then("Urunun favori listesine eklendigini dogrular")
    public void urunun_favori_listesine_eklendigini_dogrular() {
        favoriUrunsayisi= sayfadakiUrunler.size();
        int expectedUrunSayisi=1;
        int actualUrunSayisi=favoriUrunsayisi;


        Assert.assertEquals(expectedUrunSayisi,actualUrunSayisi);
    }


    }


