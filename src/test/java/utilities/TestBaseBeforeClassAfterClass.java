package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public abstract class TestBaseBeforeClassAfterClass  {
    protected WebDriver driver;

    //@BeforeClass ve @AfterClass notasyonlarini TestNG de kullanirken JUnit'teki gibi static yapmaya gerek yoktur
    @BeforeClass(groups= {"gp1", "gp2"})
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterClass(groups= {"gp1", "gp2"})
    public void tearDown(){

        driver.quit();
    }
}
