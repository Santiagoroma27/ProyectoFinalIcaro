package opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage {

    By emailInput = By.id("input-email");
    By passwordInput = By.id("input-password");
    By loginForm = By.xpath("//input[@type='submit' and @value='Login']");

    By userIcon = By.cssSelector("#top-links > ul > li.dropdown > a > i");
    By loginIcon = By.cssSelector("#top-links > ul > li.dropdown.open > ul > li:nth-child(2) > a");

    By textLogin = By.cssSelector("#content > div > div:nth-child(2) > div > h2");
    WebDriver driver;

    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /*
    ** TODO: estoy cambiando de estatico a privado
     */
    public void login(String email, String password) {
        this.llenarEmail(email);
        this.llenarPassword(password);
        this.loguearse();
    }

    public void llenarEmail(String email) {
        WebElement emailInputElem = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        emailInputElem.sendKeys(email);
    }

    public void llenarPassword(String password) {
        WebElement passwordInputElem = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        passwordInputElem.sendKeys(password);
    }

    public void loguearse() {
        WebElement loginFormElem = wait.until(ExpectedConditions.elementToBeClickable(loginForm));
        loginFormElem.click();
    }
    public void irLoginScreen() {
        WebElement user =  wait.until(ExpectedConditions.elementToBeClickable(userIcon));
        user.click();
        WebElement l = wait.until(ExpectedConditions.elementToBeClickable(loginIcon));
        l.click();
    }
    public String textLoginPage() {
        WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(textLogin));
        return l.getText();
    }

    public void setEmail(String email) {
        WebElement emailElem = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        emailElem.sendKeys(email);
    }

    public void setPassword(String password) {
        WebElement passElem = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        passElem.sendKeys(password);
    }

    public boolean isMyAccountPagePresent() {
        // Buscar todos los elementos h2 en la página
        List<WebElement> h2Elements = driver.findElements(By.tagName("h2"));

        // Revisar si alguno de los elementos h2 tiene el texto "My Account"
        for (WebElement element : h2Elements) {
            if (element.getText().equals("My Account")) {
                return true; // Retorna true si encuentra un h2 con el texto "My Account"
            }
        }
        return false; // Retorna false si no encuentra ningún h2 con ese texto
    }
}
