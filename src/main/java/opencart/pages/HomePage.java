package opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {

    By title = By.xpath("//div[@id='logo']/h1/a");
    private By search = By.name("search");
    private By carrousel = By.id("slideshow0");

    private By myAccountBtn = By.xpath("//a[@title='My Account']");
    private By loginBtn = By.xpath("//a[text()='Login']");
    private By registerBtn = By.xpath("//a[text()='Register']");

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void ingresarAlLogin() {
        WebElement myAccountBtnElem = wait.until(ExpectedConditions.elementToBeClickable(myAccountBtn));
        myAccountBtnElem.click();

        WebElement loginBtnElem = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtnElem.click();
    }

    public void ingresarAlRegistro() {
        WebElement myAccountBtnElem = wait.until(ExpectedConditions.elementToBeClickable(myAccountBtn));
        myAccountBtnElem.click();

        WebElement registerBtnElem = wait.until(ExpectedConditions.elementToBeClickable(registerBtn));
        registerBtnElem.click();
    }

    public void validarPage() {
        WebElement titleElement = driver.findElement(title);
        WebElement searchElement = driver.findElement(search);
        WebElement carrouselElement = driver.findElement(carrousel);

        Assert.assertEquals(titleElement.getText(), "Your Store");
        Assert.assertTrue(searchElement.isDisplayed());
        Assert.assertTrue(carrouselElement.isDisplayed());
    }

    public String getTitulo() {
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        return titleElement.getText();
    }

    public Boolean buscadorEsVisible() {
        WebElement searchElement = wait.until(ExpectedConditions.visibilityOfElementLocated(search));
        return searchElement.isDisplayed();
    }

    public Boolean carrouselEsVisible() {
        WebElement carrouselElement = wait.until(ExpectedConditions.visibilityOfElementLocated(carrousel));
        return carrouselElement.isDisplayed();
    }
}
