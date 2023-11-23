package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import opencart.pages.BuyPage;

import java.io.IOException;

public class BuyDefinitions {

    @Y("el usuario agrega un producto al carrito")
    public void elUsuarioAgregaUnProductoAlCarrito() throws IOException {
        BuyPage buyPage = new BuyPage(Hooks.getDriver());
        buyPage.selectCanonEOS5D();
        String productOption = "";
        buyPage.selectedOption(productOption);
        buyPage.addToCart();
    }

    @Y("el usuario entra al carrito")
    public void elUsuarioEntraAlCarrito() throws IOException {
        BuyPage buyPage = new BuyPage(Hooks.getDriver());
        buyPage.viewCart();
    }

    @Entonces("se valida que exista un producto en el carrito")
    public boolean seValidaQueExisteUnProductoEnElCarrito() throws IOException {
        BuyPage buyPage = new BuyPage(Hooks.getDriver());
        return buyPage.hasProductInCart();
    }
}
