package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C02_SoftAssert extends TestBaseBeforeMethodAfterMethod {
    @Test
    public void testName() {

//1-amazon anasayfaya gidin
    driver.get("https://amazon.com");
    //2-title in Amazon içerdigini test edin
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(driver.getTitle().contains("Amazon"));
    //3-arama kutusnun erişilebilir oldugunu tets edin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusu.isEnabled());
    //4-arama kutusuna Nuella yazıp aratın
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);
    //5-arama yapıldıgını test edin
        WebElement resultWE = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(resultWE.isDisplayed());
    //6-arama sonucunun Nutella içerdigini test edin
        softAssert.assertTrue(resultWE.getText().contains("Nutella"));

        softAssert.assertAll();
}
}