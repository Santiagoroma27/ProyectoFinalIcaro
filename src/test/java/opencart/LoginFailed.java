package opencart;

import hooks.Hooks;
import opencart.pages.HomePage;
import opencart.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginFailed {
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    private LoginPage loginPage;

    public LoginFailed() {
        Hooks hooks = new Hooks();
        this.driver = hooks.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
    }

    @Test
    public void loginFallido() {
        // 1) Navegar a la página de inicio
        driver.get("https://opencart.abstracta.us/");

        // 2 y 3) Ingresar al login desde la página de inicio
        homePage.ingresarAlLogin();

        // 4) Realizar el login con credenciales incorrectas
        // Esto debe fallar
        loginPage.login("pepe@pepe.com.ar", "1234568");

        // Aquí puedes agregar aserciones para validar que el inicio de sesión falló
    }
}
