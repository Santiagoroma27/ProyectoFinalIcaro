// ComprarTest.java

package opencart.tests;

import hooks.Hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import opencart.pages.ComprarPage;
import opencart.pages.LoginPage;

public class ComprarTest {

    private ComprarPage comprarPage;

    @Before
    public void setUp() {
        comprarPage = new ComprarPage(Hooks.getDriver());
    }

    @Given("Que el usuario levanta la página {string}")
    public void queElUsuarioLevantaLaPagina(String url) {
        Hooks.getDriver().get(url);
    }

    @When("El usuario hace clic en Cameras")
    public void elUsuarioHaceClicEnCameras() {
        comprarPage.irACamaras();
    }

    @When("El usuario hace clic en Canon EOS 5D")
    public void elUsuarioHaceClicEnCanonEOS5D() {
        comprarPage.seleccionarCanonEOS5D();
    }

    @When("El usuario selecciona una opción y agrega el producto al carrito")
    public void elUsuarioSeleccionaUnaOpcionYAgregaElProductoAlCarrito() {
        comprarPage.agregarAlCarrito();
    }

    @When("El usuario hace clic en el carrito")
    public void elUsuarioHaceClicEnElCarrito() {
        comprarPage.irAlCarrito();
    }

    @When("El usuario hace clic en View Cart")
    public void elUsuarioHaceClicEnViewCart() {
        comprarPage.verCarrito();
    }

    @After
    public void tearDown() {
        Hooks.quitDriver();
    }
}
