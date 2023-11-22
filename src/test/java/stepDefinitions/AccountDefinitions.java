package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.an.Cuan;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import opencart.pages.LoginPage;
import opencart.pages.MyAccountPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class AccountDefinitions {

    private LoginPage loginPage;
    private MyAccountPage myAccountPage;

    public AccountDefinitions() throws IOException {
        this.loginPage = new LoginPage(Hooks.getDriver());
        this.myAccountPage = new MyAccountPage(Hooks.getDriver());
    }

    @Cuando("el usuario ingresa a la web")
    public void elUsuarioIngresaALaWeb() {
        loginPage.login("email@example.com", "contraseña");
    }

    @Y("luego el usuario ingresa al login")
    public void luegoElUsuarioIngresaAlLogin() {
        WebElement usernameInput = driver.findElement(By.id("input-username"));
        usernameInput.sendKeys("usuario");

    }

    @Cuando("el usuario ingresa credenciales válidos")
    public void elUsuarioIngresaCredencialesValidos() {
        // Implementar la lógica para que el usuario ingrese credenciales válidas al login de OpenCart
    }

    @Entonces("se valida la información en la página de cuenta")
    public void seValidaLaInformaciónEnLaPáginaDeCuenta() {
        // Agrega las validaciones necesarias para la información en la página de cuenta
        // Puedes usar métodos de MyAccountPage o WebDriver directamente según tu implementación
        // Ejemplo: Assert.assertTrue(myAccountPage.informacionEsCorrecta());
    }

    @Dado("que el usuario ingresa a opencart")
    public void queElUsuarioIngresaAOpencart() throws IOException {
        Hooks.getDriver().get(Hooks.getConfigValue("url"));
    }


    @Y ("luego el usuario ingresa al login")
public void luegoElUsuarioIngresaAlLogin() throws {
    WebElement loginLink = driver.findElement(By.linkText("Iniciar sesión")); // Encuentra el enlace de inicio de sesión
    loginLink.click();
}
}