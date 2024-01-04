package stepDefinitions;

import groovyjarjarasm.asm.tree.TryCatchBlockNode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.WebElement;
import pages.CategoryPage;

import java.io.IOException;

import static java.lang.Integer.parseInt;
import static utilities.Driver.driver;
import static utilities.JSUtils.*;
import static utilities.JSUtils.scrollIntoVIewJS;
import static utilities.ReusableMethods.*;


public class US_08_CategoriesStepDefinitions {
    CategoryPage kategori = new CategoryPage();


    @Given("Herhangi bir urun kategorisi secer")
    public void herhangi_bir_urun_kategorisi_secer() {
        scrollDownByJS();
        //waitFor(3);
        //driver.switchTo().alert().accept();
        selectRandomEntryFromList(CategoryPage.urunKategorileri).click();
    }
    @Given("Sayfadaki urunlerden rastgele secer")
    public void sayfadaki_urunlerden_rastgele_secer() {
        waitFor(3);
     clickElementByJS(selectRandomEntryFromList(CategoryPage.sayfadakiUrunler));
           }
    @Then("secilen urunun stok durumunu dogrular")
    public void secilen_urunun_stok_durumunu_dogrular() {


        try {

            if(CategoryPage.urundeSepeteEkle.isEnabled()){
                System.out.println("Ürün Stokta Var (" + CategoryPage.urundeSepeteEkle.isEnabled()+")");
            } else if (CategoryPage.urundeStoktaYok.isEnabled()) {
                System.out.println("Ürün Stokta Yok (" + CategoryPage.urundeStoktaYok.isEnabled()+")");
            }else{
                System.out.println("Ürün kutusunda sorun var");
            }
        }catch (Exception e){
            System.out.println("NoSuchElementException");
        }




    }
    @Then("Urun ekran kaydini alir")
    public void urun_ekran_kaydini_alir() throws IOException {
        try{
            if(CategoryPage.urundeSepeteEkle.isEnabled()){
                scrollIntoVIewJS(CategoryPage.urundeSepeteEkle);
                takeScreenshotOfTheEntirePage();
            } else if (CategoryPage.urundeStoktaYok.isEnabled()) {
                scrollIntoVIewJS(CategoryPage.urundeStoktaYok);
                takeScreenshotOfTheEntirePage();
            }

        }catch (Exception e){

        }

    }

    }








