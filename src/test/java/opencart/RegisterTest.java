package opencart;

import com.github.javafaker.Faker;
import opencart.pages.AccountPage;
import opencart.pages.HomePage;
import opencart.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static hooks.Hooks.getDriver;

public class RegisterTest {

    @Test
    public void createAccount() throws IOException {
        HomePage homePage = new HomePage(getDriver());
        RegisterPage registerPage = new RegisterPage(getDriver());
        AccountPage accountPage = new AccountPage(getDriver());

        Faker faker = new Faker();

        getDriver().get("https://opencart.abstracta.us");

        homePage.ingresarAlRegistro();

        registerPage.completarFormulario(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                faker.phoneNumber().phoneNumber(),
                faker.internet().password());

        Assert.assertEquals(accountPage.getTitulo(), "Account");
        Assert.assertTrue(accountPage.descriptionIsDisplayed());
    }
}
