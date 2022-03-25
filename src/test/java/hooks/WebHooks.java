package hooks;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static hooks.GetConfig.getConfigurationValue;

public class WebHooks {
    @BeforeAll
    public static void before(){
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().
                        screenshots(true).
                        savePageSource(false)
        );
    }

    @BeforeAll
    static void Test_Open() {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver" , getConfigurationValue("driver_dir"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterAll
    static void Test_Close() {
        closeWebDriver();
    }
}
