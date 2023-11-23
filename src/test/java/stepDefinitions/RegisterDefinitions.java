package stepDefinitions;

import com.github.javafaker.Faker;
import hooks.Hooks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import opencart.pages.AccountPage;

import opencart.pages.HomePage;
import opencart.pages.RegisterPage;
import org.testng.Assert;

import java.io.IOException;

import static hooks.Hooks.getDriver;

public class RegisterDefinitions {

    private RegisterPage registerPage;
    private AccountPage accountPage;

    public RegisterDefinitions() throws IOException {
        HomePage homePage = new HomePage(Hooks.getDriver());
        this.registerPage = new RegisterPage(Hooks.getDriver());
        this.accountPage = new AccountPage(Hooks.getDriver());
    }

    @Y("el usuario ingresa al registro")
    public void elUsuarioIngresaAlRegistro() throws IOException {
        getDriver().get("https://opencart.abstracta.us/index.php?route=account/register");
    }

    @Cuando("el usuario completa el formulario de registro con datos validos")
    public void elUsuarioCompletaElFormularioDeRegistroConDatosValidos() throws IOException {
        Faker faker = new Faker();

        getDriver().get("https://opencart.abstracta.us");

        registerPage.completarFormulario(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                faker.phoneNumber().phoneNumber(),
                faker.internet().password());
    }

    @Entonces("se valida que el usuario se encuentra en su cuenta")
    public void seValidaQueElUsuarioSeEncuentraEnSuCuenta() {
        Assert.assertTrue(accountPage.getTitulo().contains("My Account"));
        Assert.assertTrue(accountPage.getLogo().getText().contains("Your Store"));
    }
}
