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

    @Dado("que el usuario ingresa a la pagina de opencart")
    public void queElUsuarioIngresaALaPaginaDeOpencart() throws IOException {
       Hooks.getDriver().get(Hooks.getConfigValue("url"));
    }

    @Y("el usuario ingresa al login")
public void elUsuarioIngresaAlLogin(){
        homePage.ingresarAlLogin();
    }
}

