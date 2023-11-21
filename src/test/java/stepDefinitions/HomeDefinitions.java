package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import opencart.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class HomeDefinitions {

  private HomePage homePage;


    public HomeDefinitions() throws IOException {
        this.homePage = new HomePage(Hooks.getDriver());
    }

    @Dado("Que el usuario ingresa a la pagina de opencart")
    public void queElUsuarioIngresaALaPaginaDeOpencart() throws IOException {
       Hooks.getDriver().get(Hooks.getConfigValue("url"));
    }

    @Entonces("se valida que el usuario se encuentra en la home")
    public void seValidaQueElUsuarioSeEncuentraEnLaHome() {
        Assert.assertEquals(homePage.getTitulo(), "Your Store");
        Assert.assertTrue(homePage.buscadorEsVisible());
        Assert.assertTrue(homePage.carrouselEsVisible());
    }

    @Y("el usuario ingresa al login")
    public void elUsuarioIngresaAlLogin() {
        homePage.ingresarAlLogin();
    }

    @Cuando("el usuario ingresa credenciales validos")
    public void elUsuarioIngresaCredencialesValidos() {
        homePage.ingresarAlLogin();
    }


}

