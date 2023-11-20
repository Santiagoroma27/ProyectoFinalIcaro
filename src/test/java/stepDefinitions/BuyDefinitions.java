// BuyDefinitions.java

package opencart.stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import opencart.pages.CartPage;

public class BuyDefinitions {

    private CartPage cartPage;

    public BuyDefinitions() {
        this.cartPage = new CartPage(Hooks.getDriver());
    }

    @Then("Se valida que el producto se encuentra en el carrito")
    public void seValidaQueElProductoSeEncuentraEnElCarrito() {
        Assert.assertTrue(cartPage.productoEnCarrito());
    }
}
