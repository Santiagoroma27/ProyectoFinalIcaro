package opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuyPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // REVISAR SELECTORES! NO LOS TERMINÉ!!!

    private By camerasLink = By.linkText("Cameras");
    private By canonEOS5DLink = By.linkText("Canon EOS 5D");
    private By addToCartButton = By.id("button-cart");
    private By cartButton = By.id("cart");
    private By viewCartButton = By.linkText("View Cart");

    private By selectAvailableOption = By.cssSelector("#input-option226");

    public BuyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToCameras() {
        WebElement camerasLinkElem = wait.until(ExpectedConditions.elementToBeClickable(camerasLink));
        camerasLinkElem.click();
    }

    public void selectCanonEOS5D() {
        WebElement canonEOS5DElem = wait.until(ExpectedConditions.elementToBeClickable(canonEOS5DLink));
        canonEOS5DElem.click();
    }

    public void addToCart() {
        WebElement addToCartButtonElem = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButtonElem.click();
    }

    public void goToCart() {
        WebElement cartButtonElem = wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        cartButtonElem.click();
    }

    public void viewCart() {
        WebElement viewCartButtonElem = wait.until(ExpectedConditions.elementToBeClickable(viewCartButton));
        viewCartButtonElem.click();
    }
    public void validateProduct() {
        // llename de codigo

    }

    public Boolean selectedOption(String option){
        return Boolean.TRUE;
    }


    public String getProductName() {
        WebElement productNameElement = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[1]/a/img"));
        return productNameElement.getAttribute("Canon EOS 5D");
    }

}
