package Cucumber.StepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StepDefinitionImplementation {

   // @Given("^Land on google website and enter (.+)$") // only when data driven from examples
    @Given("Land on google website and enter {string}") // only when data driven from examples
    public void goTo(String text){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='Google']")));
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.id("W0wltc"))).click().build().perform();
        driver.findElement(By.cssSelector("textarea")).sendKeys(text);
    }
}
