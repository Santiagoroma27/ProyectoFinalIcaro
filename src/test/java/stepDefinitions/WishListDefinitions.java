package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.es.*;
import opencart.pages.HomePage;
import opencart.pages.LoginPage;
import opencart.pages.WishlistPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class WishlistDefinitions {

    private HomePage homePage;
    private LoginPage loginPage;
    private WishlistPage wishlistPage;

    public WishlistDefinitions() {
        this.homePage = new HomePage(Hooks.getDriver());
        this.loginPage = new LoginPage(Hooks.getDriver());
        this.wishlistPage = new WishlistPage(Hooks.getDriver());
    }

    @Dado("Que el usuario levanta la página {string}")
    public void queElUsuarioLevantaLaPagina(String url) {
        Hooks.getDriver().get(url);
    }

    @Cuando("El usuario hace clic en My Account")
    public void elUsuarioHaceClicEnMyAccount() {
        homePage.ingresarAlLogin();
    }

    @Y("El usuario hace clic en Login")
    public void elUsuarioHaceClicEnLogin() {
        homePage.ingresarAlLogin();
    }

    @Y("El usuario realiza el login")
    public void elUsuarioRealizaElLogin() {
        String username = Hooks.getConfigValue("username");
        String password = Hooks.getConfigValue("password");
        loginPage.login(username, password);
    }


    @Y("El usuario ingresa a la sección Cameras")
    public void elUsuarioIngresaALaSeccionCameras() {
        WebElement camerasLinkElem = wait.until(ExpectedConditions.elementToBeClickable(camerasLink));
        camerasLinkElem.click();
    }

    @Y("El usuario agrega un producto a favoritos {string}")
    public void elUsuarioAgregaUnProductoAFavoritos(String productName) {
        wishlistPage.agregarProductoAFavoritos();
        Assert Assert;
        Assert.assertTrue(wishlistPage.mensajeExitoAgregado());
    }

    @Y("El usuario hace clic en Wish List")
    public void elUsuarioHaceClicEnWishList() {
        wishlistPage.irAWishlist();
    }

    @Entonces("Se valida que exista un producto en favoritos")
    public void seValidaQueExistaUnProductoEnFavoritos() {

    }

    @Y("Se valida que el producto en la grilla sea {string}")
    public void seValidaQueElProductoEnLaGrillaSea(String productName) {
        // Agrega los pasos para validar que el producto en la grilla sea "Canon EOS 5D"
    }
}
