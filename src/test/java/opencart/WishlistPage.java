package opencart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WishlistPage {

    By wishlistTitle = By.xpath("//h2[text()='My Wish List']");
    By productInWishlist = By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[2]/a");
    By alertSuccess = By.cssSelector("#product-product > div.alert.alert-success.alert-dismissible");

    WebDriver driver;
    WebDriverWait wait;

    public WishlistPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void irAWishlist() {
        WebElement wishlistTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(wishlistTitle));
        wishlistTitleElement.click();
    }

    public String obtenerNombreProductoEnWishlist() {
        WebElement productInWishlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productInWishlist));
        return productInWishlistElement.getText();
    }

    public Boolean getAlertSuccess() {
        WebElement alertSuccessMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(alertSuccess));
        return alertSuccessMsg.isDisplayed();
    }

    public void agregarProductoAFavoritos(String productName) {
        String productId = "0";
        switch(productName){
            case "Canon EOS 5D":
                productId = "30";
                break;
            default:
                productId = "31";
                break;

        }
        By selector = By.cssSelector(String.format("button[onclick=\"wishlist.add('%s');\"]", productId));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        element.click();
    }
}
