package opencart;

import com.github.javafaker.Faker;
import opencart.pages.AccountPage;
import opencart.pages.HomePage;
import opencart.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import hooks.Hooks;

public class RegisterTest {

    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;
    private AccountPage accountPage;

    public RegisterTest() {
        Hooks hooks = new Hooks();
        this.driver = hooks.getDriver();
        this.homePage = new HomePage(driver);
        this.registerPage = new RegisterPage(driver);
        this.accountPage = new AccountPage(driver);
    }

    @Test
    public void createAccount() {
        Faker faker = new Faker();

        driver.get("https://opencart.abstracta.us");

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
