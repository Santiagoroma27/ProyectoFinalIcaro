package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import opencart.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class HomeDefinitions {

    private HomePage homePage;
    private WebDriver driver;
    private Hooks hooks;

    public HomeDefinitions() throws IOException {
        hooks = new Hooks();
        this.driver = hooks.getDriver();
        this.homePage = new HomePage(driver);
    }

    @Dado("que el usuario ingresa a la pagina de opencart")
    public void queElUsuarioIngresaALaPaginaDeOpencart() {
        driver.get(hooks.getConfigValue("url"));
    }

    @Entonces("se valida que el usuario se encuentra en la home")
    public void seValidaQueElUsuarioSeEncuentraEnLaHome() {
        String myHomePage = homePage.getTitulo();
        Assert.assertEquals(myHomePage, "Your Store");
    }
}
