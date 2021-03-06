package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void init(BasePage bp)
    {
        PageFactory.initElements(driver, bp);
    }
}
