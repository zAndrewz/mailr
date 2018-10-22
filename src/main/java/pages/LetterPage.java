package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LetterPage extends BasePage {
    public LetterPage(WebDriver driver) {
        super(driver);
        init(this);
    }

    @FindBy(xpath = "//textarea[@data-original-name=\"To\"]")
    private WebElement toWhom;

    @FindBy(xpath = "//input[@name=\"Subject\"]")
    private WebElement topicLine;

    @FindBy(xpath = "//td/iframe")
    private WebElement subjectText;

    @FindBy(xpath = "//span[contains(text(),'Отправить')]/../..")
    private WebElement buttonSend;

    public LetterPage setToWhom(String who)
    {
        try {
            toWhom.sendKeys(who);
        }catch(NoSuchElementException ex)
        {
            Assert.fail("Something went wrong with a line TO WHOM");
        }
        return this;
    }

    public LetterPage setTopicLine(String topic)
    {
        try {
            topicLine.sendKeys(topic);
        }catch(NoSuchElementException ex)
        {
            Assert.fail("Something went wrong with a line TOPIC");
        }
        return this;
    }

    public LetterPage setSubjectText(String subject)
    {
        try {
            WebElement we = driver.findElement(By.xpath("//iframe[starts-with(@id,'toolkit-')]"));
            driver.switchTo().frame(we);
            driver.findElement(By.id("tinymce")).click();
            driver.findElement(By.id("tinymce")).clear();
            driver.findElement(By.id("tinymce")).sendKeys(subject);
        }catch(NoSuchElementException ex)
        {
            Assert.fail("Something went wrong with a SUBJECT of letter");
        }
        return this;
    }

    public LetterPage pushSend()
    {
        try {
            driver.switchTo().defaultContent();
            buttonSend.click();
        }catch(NoSuchElementException ex)
        {
            Assert.fail("Something went wrong with a button SendMessage");
        }
        return this;
    }
}
