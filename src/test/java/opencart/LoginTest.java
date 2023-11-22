package opencart;

import opencart.pages.HomePage;
import opencart.pages.LoginPage;
import opencart.pages.MyAccountPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static hooks.Hooks.getDriver;

public class LoginTest extends BuyTest {

    @Test
    public void login() throws IOException {
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());

        // 1) Navegar a la página de inicio
        getDriver().get("https://opencart.abstracta.us/");

        // 2 y 3) Ingresar al login desde la página de inicio
        homePage.ingresarAlLogin();

        // 4) Realizar el login
        loginPage.llenarEmail("pepe@pepe.com.ar");
        loginPage.llenarPassword("12345678");
        loginPage.loguearse();

        // 5) Validar que se haya iniciado sesión correctamente
        Assert.assertEquals(myAccountPage.obtenerTitulo(), "My Account");
    }

}
