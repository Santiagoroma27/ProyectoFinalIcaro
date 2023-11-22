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

public class LoginFailed {
    @Test
    public void loginFallido() throws IOException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        // 1) Navegar a la página de inicio
        getDriver().get("https://opencart.abstracta.us/");

        // 2 y 3) Ingresar al login desde la página de inicio
        HomePage homePage = new HomePage(getDriver());
        homePage.ingresarAlLogin();

        // 4) Realizar el login
        LoginPage loginPage = new LoginPage(getDriver());
        // esto debe fallar
        loginPage.login("pepe@pepe.com.ar", "1234568");
    }
}
