package pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
        init(this);
    }

    @FindBy(xpath = "//input[@id=\"mailbox:login\"]")
    private WebElement login;

    @FindBy(xpath = "//input[@id=\"mailbox:password\"]")
    private WebElement password;

    @FindBy(xpath = "//label[@id=\"mailbox:submit\"]/input")
    private WebElement enterButton;

    public LoginPage setLogin(String str) {
        try {
            login.click();
            login.clear();
            login.sendKeys(str);
        }catch(NoSuchElementException ex)
        {
            Assert.fail("Something went wrong with a login");
        }
        return this;
    }

    public LoginPage setPassword(String pass)
    {
        try {
            password.click();
            password.clear();
            password.sendKeys(pass);
        }catch(NoSuchElementException ex)
        {
            Assert.fail("Something went wrong with a password");
        }
        return this;
    }

    public LoginPage pushEnter()
    {
        try {
            enterButton.click();
        }catch(NoSuchElementException ex)
        {
            Assert.fail("Something went wrong with an enter button");
        }
        return this;
    }
}
