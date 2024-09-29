package tests.base;

import common.CommonActions;
import common.Config;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.mts_home.MtsHomePage;
import pages.mts_home.iFrame.IFramePage;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected MtsHomePage mtsHomePage = new MtsHomePage(driver);
    protected IFramePage iFramePage = new IFramePage(driver);

    @AfterEach
    public void clearCookieAndLocalStorage() {
        if (Config.isClearCookie()) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
            System.out.println("Куки почистили");
        }

    }

    @AfterEach
    public void close() {
        if (Config.isHoldBrowser()) {
            driver.quit();
        }
    }
}
