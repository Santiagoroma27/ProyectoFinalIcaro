package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.es.*;
import opencart.pages.HomePage;
import opencart.pages.LoginPage;
import opencart.WishlistPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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
        this.wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    }

    @Dado("que el usuario esta en home")
    public void que_el_usuario_esta_en_home() throws IOException {
        Hooks.getDriver().get(Hooks.getConfigValue("url"));

        //Verificación de que estamos en la web
        Assert.assertEquals(Hooks.getDriver().getTitle(), "Your Store");
    }

    @Entonces("El usuario hace click en el boton Cameras")
    public void el_usuario_hace_click_en_el_boton_cameras(){
        //Encontrar el botónde las cámaras!
        By camerasButtonSelector = By.linkText("Cameras");
        WebElement camerasButton = driver.findElement(camerasButtonSelector);
        //CLICKEAR DE UNA BUENA VEZ!
        camerasButton.click();

    }

    @Entonces("El usuario elige el modelo de camara {string}")
    public void el_usuario_elige_el_modelo_de_camara_(String productName){
        By productImageSelector = By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[1]/a/img");
        WebElement productImage = driver.findElement(productImageSelector);
        Assert.assertTrue(productImage.isDisplayed());
        //CLICKEAR DE UNA MALDITA VEZ!
        productImage.click();
    }

    @Entonces("El usuario agrega el producto a favoritos {string}")
    public void el_usuario_agrega_el_producto_a_favoritos(String productName) {
        // Encuentra el botón de agregar a favoritos
        By addButtonSelector = By.xpath("#content > div > div.col-sm-4 > div.btn-group > button:nth-child(1) > i");
        WebElement addButton = driver.findElement(addButtonSelector);

        // Ya no lo comento a los botones... Se entienden
        addButton.click();

    }
    //Listo, ahora vamos a revisar de que se esté cargando como corresponde a la lista.
    @Entonces ("El usuario hace clic en Wish List")
    public void el_usuario_hace_clic_en_Wish_List() {
        By wishlistButtonSelector = By.xpath("//*[@id=\"wishlist-total\"]/i");
        WebElement wishlistButton = driver.findElement(wishlistButtonSelector);

        //Vamos!
        wishlistButton.click();

    }

    }

      @Entonces("Se valida que exista un producto en favoritos")
    public void se_valida_que_exista_un_producto_en_favoritos() {
          By unitPriceSelector = By.xpath("//*[@id=\"content\"]/div[1]/table/thead/tr/td[5]");
          WebElement unitPrice = driver.findElement(unitPriceSelector);

          //Controlemos

               if (unitPrice.isDisplayed()) {
              // El producto existe en la lista
              } else {
              // El producto no existe en la lista de deseos
              Assert.fail("Producto no encontrado... Llorá");
          }

    }
}

