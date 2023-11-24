package stepDefinitions;
import hooks.Hooks;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import opencart.pages.HomePage;
import opencart.pages.MyAccountPage;
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

    @Entonces("se valida que el usuario se encuentra en la home")
    public void seValidaQueElUsuarioSeEncuentraEnLaHome() {
        String myHomePage = homePage.getTitulo();
        Assert.assertEquals(myHomePage, "Your Store");
    }

}


