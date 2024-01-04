package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.time.Duration;

import static utilities.Driver.driver;
import static utilities.JSUtils.clickElementByJS;
import static utilities.JSUtils.scrollDownByJS;
import static utilities.ReusableMethods.*;


public class US_01_LoginStepDefinitions {
    HomePage gratis = new HomePage();
    @Given("Kullanici Gratis ana sayfasina gider")
    public void kullanici_amazon_anasayfasina_gider() {
        Driver.getDriver().get(ConfigurationReader.getProperty("gratisUrl"));
    }
    @When("Giris yap butonuna tiklar")
    public void giris_yap_butonuna_tiklar() {
        scrollDownByJS();
        gratis.GirisYap.click();
        gratis.droptakiGirisYap.click();
    }
    @Then("Gecerli {string} girer")
    public void gecerliGirer(String kullanici_adi) {

      waitForVisibility(gratis.emailBox,30).sendKeys(kullanici_adi);
    }
    @Then("Gecerli {string} bilgisini girer")
    public void gecerli_bilgisini_girer(String sifre) {
        waitForVisibility(gratis.passwordBox, 30).sendKeys(sifre);
    }
    @Then("Giris yap kutusuna tiklar")
    public void giris_yap_kutusuna_tiklar() {
        clickElementByJS(waitForVisibility(gratis.submitButton, 30));
    }





}

