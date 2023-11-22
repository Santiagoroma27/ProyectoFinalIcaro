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
import org.testng.Assert;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.time.Duration;

import static hooks.Hooks.getDriver;


public class WishListDefinitions {

    private HomePage homePage;
    private LoginPage loginPage;
    private WishlistPage wishlistPage;
    private WebDriver driver;
    private WebDriverWait wait;
    private By cameraLink = By.cssSelector("#content > div:nth-child(3) > div:nth-child(1) > div > div.image");

    public WishListDefinitions() throws IOException {
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
        wishlistPage.agregarProductoAFavoritos(productName);
        Assert.assertTrue(wishlistPage.getAlertSuccess());
    }

    @Y("El usuario hace clic en Wish List")
    public void elUsuarioHaceClicEnWishList() {
        wishlistPage.irAWishlist();
    }

    @Entonces("Se valida que exista un producto en favoritos")
    public void seValidaQueExistaUnProductoEnFavoritos() {

    }
}
