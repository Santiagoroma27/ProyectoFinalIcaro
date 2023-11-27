package stepDefinitions;

import com.github.javafaker.Faker;
import hooks.Hooks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import opencart.pages.AccountPage;
import opencart.pages.HomePage;
import opencart.pages.RegisterPage;

import java.io.IOException;

public class RegisterDefinitions {

    private RegisterPage registerPage;
    private AccountPage accountPage;
    private WebDriver driver;
    private Hooks hooks;

    public RegisterDefinitions() throws IOException {
        hooks = new Hooks();
        driver = hooks.getDriver();
        HomePage homePage = new HomePage(driver);
        this.registerPage = new RegisterPage(driver);
        this.accountPage = new AccountPage(driver);
    }

    @Dado("que el usuario ingresa a la pagina de opencar")
    public void the_user_enters_the_opencart_page() {
        driver.get("https://opencart.abstracta.us");
    }

    @Entonces("el usuario ingresa al registro")
    public void the_user_goes_to_the_registration() {
        driver.get("https://opencart.abstracta.us/index.php?route=account/register");
    }

    @Cuando("el usuario completa el formulario de registro con datos validos")
    public void the_user_completes_the_registration_form_with_valid_data() {
        driver.get("https://opencart.abstracta.us/index.php?route=account/register");
        Faker faker = new Faker();

        registerPage.completarFormulario(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                faker.phoneNumber().phoneNumber(),
                faker.internet().password());
    }

    @Entonces("se valida que el usuario se encuentra en su cuenta")
    public void it_is_validated_that_the_user_is_in_their_account() {
        Assert.assertTrue(driver.getCurrentUrl().contains("account"));
    }
}
