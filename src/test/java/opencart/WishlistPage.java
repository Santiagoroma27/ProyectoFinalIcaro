package opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishlistPage {

    By wishlistTitle = By.xpath("//h2[text()='My Wish List']");
    By productInWishlist = By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[2]/a");

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
}
