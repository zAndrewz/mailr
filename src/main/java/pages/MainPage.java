package pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
        init(this);
    }

    @FindBy(xpath = "//span[text()=\"Написать письмо\"]/../..")
    private WebElement writeALetter;

    public MainPage pushAButtonWriteALetter()
    {
        try {
            writeALetter.click();
        }catch(NoSuchElementException ex)
        {
            Assert.fail("Something went wrong with a button WriteMessage");
        }
        return this;
    }
}
