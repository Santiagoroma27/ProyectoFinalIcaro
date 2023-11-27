package opencart;

import hooks.Hooks;
import opencart.pages.HomePage;
import opencart.pages.LoginPage;
import opencart.pages.MyAccountPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;

    public LoginTest() {
        Hooks hooks = new Hooks();
        this.driver = hooks.getDriver();
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
        this.myAccountPage = new MyAccountPage(driver);
    }

    @Test
    public void login() {
        // 1) Navegar a la página de inicio
        driver.get("https://opencart.abstracta.us/");

        // 2 y 3) Ingresar al login desde la página de inicio
        homePage.ingresarAlLogin();

        // 4) Realizar el login
        loginPage.login("pepe@pepe.com.ar", "12345678");

        // 5) Validar que se haya iniciado sesión correctamente
        Assert.assertEquals(myAccountPage.obtenerTitulo(), "My Account");
    }
}
