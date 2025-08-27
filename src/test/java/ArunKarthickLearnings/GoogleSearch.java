package ArunKarthickLearnings;

import TestComponents.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Hello world!
 *
 */
public class GoogleSearch extends BaseTest {

    @Test
    public void googleTest(){
        //WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
        driver.get("https://www.google.com");
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='Google']")));
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.id("W0wltc"))).click().build().perform();
        driver.findElement(By.cssSelector("textarea")).sendKeys("Good Morning");
        a.click(driver.findElement(By.cssSelector(("[role='presentation'] ul li")))).build().perform();
        Boolean aboutThisPage = driver.findElement(By.cssSelector("b")).isDisplayed();
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        //driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='reCAPTCHA']")));
        driver.switchTo().frame(0);
        a.click(driver.findElement(By.cssSelector(".recaptcha-checkbox-border"))).build().perform();
        String openSeparateTab = Keys.chord(Keys.CONTROL,Keys.ENTER);


    }
}
