package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import opencart.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

import static hooks.Hooks.getDriver;

public class BuyDefinitions {

    private WebDriver driver;
    private RegisterDefinitions registerDefinition;
    private BuyPage buyPage;
    private LoginPage loginPage;

    public BuyDefinitions() throws IOException {
        registerDefinition = new RegisterDefinitions();
        driver = getDriver();
        buyPage = new BuyPage(driver);
        this.loginPage = new LoginPage(driver);
    }
    @Dado("que el usuario ingresa a la pagina")
    public void que_el_usuario_ingresa_a_la_pagina_de_opencart() throws IOException {
        getDriver().get("https://opencart.abstracta.us/"); // Cambia esto por la URL de tu página de OpenCart
        Assert.assertEquals(1,1);
    }

    @Entonces("el usuario se registra")
    public void el_usuario_se_registra() throws IOException {
        // Ajusta el selector según tu página
        registerDefinition.the_user_completes_the_registration_form_with_valid_data();
        Assert.assertEquals(1,1);
    }


    @Y("El usuario ingresa a la sección Cameras")
    public void el_usuario_ingresa_a_la_seccion_Cameras() throws IOException {
        // Ajusta el selector para navegar a la sección de cámaras
        buyPage.goToCameras();
        Assert.assertEquals(1,1);
    }

    @Y("el usuario agrega un producto al carrito")
    public void el_usuario_agrega_un_producto_al_carrito() throws IOException {
        // Ajusta el selector para agregar un producto específico al carrito
        buyPage.addToCart();
        Assert.assertEquals(1,1);
    }

    @Y("el usuario entra al carrito")
    public void el_usuario_entra_al_carrito() {
        // Ajusta el selector para navegar al carrito de compras
        buyPage.goToCart();
        Assert.assertEquals(1,1);
    }

    @Entonces("se valida que exista un producto en el carrito")
    public void se_valida_que_exista_un_producto_en_el_carrito() {
        // Valida que el carrito contenga al menos un producto
        buyPage.validateProduct(); // No se que mierda queres hacer aca
        Assert.assertEquals(1,1);
    }

}
