package opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {
    //div[@id='conten']/h1

    By title = By.xpath("//div[@id='content']/h1");
    By description = By.xpath("//*[contains(text(), 'Congratulations')]");


    WebDriver driver;

    WebDriverWait wait;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public String getTitulo() {
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        return titleElement.getText();
    }

    public boolean descriptionIsDisplayed(){
        WebElement descriptionElem = wait.until(ExpectedConditions.visibilityOfElementLocated(description));
        return descriptionElem.isDisplayed();

    }
}