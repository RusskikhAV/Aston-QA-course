package MTSPaymentService.iframe;

import BaseClasses.CookieAcceptSupport;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FillFieldsMtsPaymentService {
       public void fillAllFieldAndSwitchFrame(WebDriver driver) {
        String telephoneNumber = "297777777";
        String sum = "101";
        String email = "google@google.com";
        String xPathConnectionTelephone = "//input[@id='connection-phone']";
        String xPathConnectionSum = "//input[@id='connection-sum']";
        String xPathConnectionEmail = "//input[@id='connection-email']";
        String xPathButton = "//form[@id='pay-connection']/button";

        new CookieAcceptSupport().acceptCookie(driver);

        WebElement elementConnectionTelephone = driver.findElement(By.xpath(xPathConnectionTelephone));
        elementConnectionTelephone.sendKeys(telephoneNumber);

        WebElement elementConnectionSum = driver.findElement(By.xpath(xPathConnectionSum));
        elementConnectionSum.sendKeys(sum);

        WebElement elementConnectionEmail = driver.findElement(By.xpath(xPathConnectionEmail));
        elementConnectionEmail.sendKeys(email);

        WebElement button = driver.findElement(By.xpath(xPathButton));
        button.click();


        WebElement frame = driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']"));
        try {
            driver.switchTo().frame(frame);
        } catch (NoSuchWindowException e) {
            e.printStackTrace();
        }
    }
}
