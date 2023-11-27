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
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class WishlistDefinitions {

    private HomePage homePage;
    private LoginPage loginPage;
    private WishlistPage wishlistPage;
    private WebDriver driver;
    private WebDriverWait wait;
    private Hooks hooks; // Atributo para almacenar la instancia de Hooks

    public WishlistDefinitions() throws IOException {
        hooks = new Hooks();
        this.driver = hooks.getDriver();
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
        this.wishlistPage = new WishlistPage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Dado("que el usuario esta en home")
    public void que_el_usuario_esta_en_home() {
        driver.get(hooks.getConfigValue("url"));
        Assert.assertEquals(driver.getTitle(), "Your Store");
    }

    @Entonces("El usuario se loguea")
    public void el_usuario_se_loguea(){
        loginPage.irLoginScreen();
        loginPage.setEmail("pepe@pepe.com.ar");
        loginPage.setPassword("12345678");
        loginPage.loguearse();
        Assert.assertEquals(loginPage.isMyAccountPagePresent(),Boolean.TRUE);
    }
    @Entonces("El usuario hace click en el boton Cameras")
    public void el_usuario_hace_click_en_el_boton_cameras() {
        List<WebElement> camerasButtons = driver.findElements(By.linkText("Cameras"));

        // Verifica si la lista de botones no está vacía.
        Assert.assertTrue(!camerasButtons.isEmpty(), "El botón 'Cameras' no está presente");

        WebElement camerasButton = camerasButtons.get(0);
        camerasButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement h2Element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content > h2")));

        // Verifica si el texto del elemento h2 es igual a "Cameras".
        Assert.assertEquals(h2Element.getText(), "Cameras", "El texto del elemento h2 no coincide");
    }

    @Entonces("El usuario elige el modelo de camara {string}")
    public void el_usuario_elige_el_modelo_de_camara_(String productName) {
        // Buscar el enlace por el texto exacto del nombre de la cámara
        List<WebElement> productLinks = driver.findElements(By.linkText(productName));

        // Verificar que se encontró el enlace
        Assert.assertFalse(productLinks.isEmpty(), "No se encontró la cámara con el nombre: " + productName);

        // Hacer clic en el enlace
        WebElement productLink = productLinks.get(0);
        productLink.click();

        // Verificar que el texto del producto está presente en la nueva página
        Assert.assertEquals(driver.findElement(By.cssSelector("#content > div > div.col-sm-4 > h1")).getText(),"Canon EOS 5D");
    }

    @Entonces("El usuario agrega el producto a favoritos")
    public void el_usuario_agrega_el_producto_a_favoritos() {
        WebElement addButton = driver.findElement(By.cssSelector("#content > div > div.col-sm-4 > div.btn-group > button:nth-child(1)"));
        addButton.click();

        // Esperar hasta que el mensaje de éxito sea visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert-success")));

        // Verificar que el mensaje de éxito está presente y visible
        Assert.assertTrue(successAlert.isDisplayed(), "El mensaje de éxito no se muestra.");
    }


    @Entonces("El usuario hace clic en Wish List")
    public void el_usuario_hace_clic_en_Wish_List() {
        WebElement wishlistButton = driver.findElement(By.cssSelector("#wishlist-total"));
        wishlistButton.click();

        // Esperar hasta que la página de la lista de deseos esté cargada
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content")));
    }


    @Entonces("Se valida que exista un producto en favoritos {string}")
    public void se_valida_que_exista_un_producto_en_favoritos(String productName) {
        // Buscar un enlace con el texto del producto en la página de la lista de deseos
        List<WebElement> productLinks = driver.findElements(By.linkText(productName));

        // Verificar que se encontró el enlace con el nombre de la cámara
        Assert.assertFalse(productLinks.isEmpty(), "No se encontró el producto con el nombre: " + productName + " en la lista de deseos");
    }
}
