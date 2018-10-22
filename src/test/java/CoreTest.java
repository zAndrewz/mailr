import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LetterPage;
import pages.LoginPage;
import pages.MainPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CoreTest {
    private WebDriver driver;

    protected LetterPage letterPage;
    protected LoginPage loginPage;
    protected MainPage mainPage;

    protected Properties props = new Properties();

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "D:\\JavaProjects\\mailRU\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();
        driver.get("https://mail.ru/");
        init(driver);




        try (FileInputStream fis = new FileInputStream("src\\test\\resources\\mail.properties")){
            InputStreamReader reader = new InputStreamReader(fis, "windows-1251");
            props.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void afterTest() {
        driver.close();
    }

    private void init(WebDriver driver) {
        letterPage = new LetterPage(driver);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);/**/
    }
}
