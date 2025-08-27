package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage extends AbstractComponent {
    WebDriver driver;
    private String url = "https://tamilgun.group/";

    public WelcomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void goToWebsite(){
        driver.get(url);
    }
}
