package stepDefinitions;

import com.github.javafaker.Faker;
import hooks.Hooks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
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

    @Dado("que el usuario ingresa a la pagina de opencar")
    public void the_user_enters_the_opencart_page() throws IOException {
        getDriver().get("https://opencart.abstracta.us");
    }

    @Entonces("el usuario ingresa al registro")
    public void the_user_goes_to_the_registration() throws IOException {
        // Ajusta el selector según tu página
        getDriver().get("https://opencart.abstracta.us/index.php?route=account/register");
    }

    @Cuando("el usuario completa el formulario de registro con datos validos")
    public void the_user_completes_the_registration_form_with_valid_data() throws IOException {
        // Reemplaza los selectores y datos según tu formulario de registro
        getDriver().get("https://opencart.abstracta.us/index.php?route=account/register");
        Faker faker = new Faker();

        registerPage.completarFormulario(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                faker.phoneNumber().phoneNumber(),
                faker.internet().password());
    }

    @Entonces("se valida que el usuario se encuentra en su cuenta")
    public void it_is_validated_that_the_user_is_in_their_account() throws IOException {
        // Cambia el criterio de validación según tu página
        Assert.assertTrue(getDriver().getCurrentUrl().contains("account"));
    }
}
