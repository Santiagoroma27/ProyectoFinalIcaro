package opencart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MyAccountPage {
    By title = By.xpath("//h2[text()='My Account']");

    WebDriver driver;

    WebDriverWait wait;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

}
