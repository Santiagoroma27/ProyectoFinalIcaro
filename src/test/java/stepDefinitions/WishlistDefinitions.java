package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.es.*;
import opencart.pages.HomePage;
import opencart.pages.LoginPage;
import opencart.WishlistPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.time.Duration;

import static hooks.Hooks.getDriver;


public class WishlistDefinitions {

    private HomePage homePage;
    private LoginPage loginPage;
    private WishlistPage wishlistPage;
    private WebDriver driver;
    private WebDriverWait wait;
    private By cameraLink = By.cssSelector("#content > div:nth-child(3) > div:nth-child(1) > div > div.image");

    public WishlistDefinitions() throws IOException {
        this.homePage = new HomePage(getDriver());
        this.loginPage = new LoginPage(getDriver());
        this.wishlistPage = new WishlistPage(getDriver());
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

      @Y("El usuario realiza el login")
    public void elUsuarioRealizaElLogin() {
        String username = Hooks.getConfigValue("username");
        String password = Hooks.getConfigValue("password");
        loginPage.login(username, password);
    }


    @Y("El usuario ingresa a la sección Cameras")
    public void elUsuarioIngresaALaSeccionCameras() {
        WebElement camerasLinkElem = wait.until(ExpectedConditions.elementToBeClickable(cameraLink));
        camerasLinkElem.click();
    }

    @Y("El usuario agrega un producto a favoritos {string}")
    public void elUsuarioAgregaUnProductoAFavoritos(String productName) {
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
        }

    }

    @Y("El usuario hace clic en Wish List")
    public void elUsuarioHaceClicEnWishList() {
        wishlistPage.irAWishlist();
    }

    @Entonces("Se valida que exista un producto en favoritos")
    public void seValidaQueExistaUnProductoEnFavoritos() {
        By selector = By.cssSelector(String.format("button[onclick=\"wishlist.add('%s');\"]", productId));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        element.click();

    }
}
