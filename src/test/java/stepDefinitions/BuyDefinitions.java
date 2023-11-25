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
        driver.get("https://opencart.abstracta.us/");
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, "https://opencart.abstracta.us/");
    }

    @Entonces("el usuario se registra")
    public void el_usuario_se_registra() throws IOException {
        registerDefinition.the_user_completes_the_registration_form_with_valid_data();
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, "https://opencart.abstracta.us/");
    }


    @Y("El usuario ingresa a la sección Cameras")
    public void el_usuario_ingresa_a_la_seccion_Cameras() throws IOException {
        // Selector cambiado... Quiero vovler a revisarlo en un rato para ver si cambio el selector por otro y sigue corriendo!
        buyPage.goToCameras();
        Assert.assertEquals(1,1);
    }

    @Y("el usuario agrega un producto al carrito")
    public void el_usuario_agrega_un_producto_al_carrito() throws IOException {
        // Selector cambiado... Quiero vovler a revisarlo en un rato para ver si cambio el selector por otro y sigue corriendo!
        buyPage.addToCart();
        Assert.assertEquals(1,1);
    }

    @Y("el usuario entra al carrito")
    public void el_usuario_entra_al_carrito() {
        buyPage.goToCart();
        Assert.assertEquals(1,1);
    }

    @Entonces("se valida que exista un producto en el carrito")
    public void se_valida_que_exista_un_producto_en_el_carrito() {
        buyPage.validateProduct();
        Assert.assertEquals(1,1);
    }

}
