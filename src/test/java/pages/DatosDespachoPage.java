package pages;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.BasePage;
import utilities.DatosC;
import utilities.Logs;
import utilities.OtherUtilities;

import java.security.Key;
import java.sql.Driver;

public class DatosDespachoPage extends BasePage {

    private By direccionLocator = By.id("google-address-autocomplete");
    private By dptOficCasaLocator = By.id("departmentValue");
    private By referenciaLocator = By.id("referenceValue");
    private By addressItemsLocator = By.cssSelector(".shipping-google-address__list-item div");
    private By continuarButtonLocator = By.className("button--primary");
    private By mensajePagarLocator = By.xpath("//*[@id=\"collapse-control-1\"]/div[1]/span");
    private By loaderLocator = By.id("loader");

    @Override
    public void waitPageToLoad() {
        waitPage(direccionLocator, getClass().getSimpleName());
        waitPage(dptOficCasaLocator, getClass().getSimpleName());
        waitPage(referenciaLocator, getClass().getSimpleName());
        waitPage(continuarButtonLocator, getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        waitForLoaderToDisappear(loaderLocator);
        softAssert.assertTrue(find(direccionLocator).isDisplayed());
        softAssert.assertTrue(find(referenciaLocator).isDisplayed());
        softAssert.assertTrue(find(dptOficCasaLocator).isDisplayed());
        softAssert.assertTrue(find(continuarButtonLocator).isDisplayed());
        softAssert.assertAll();
    }

    public void llenarDatosDespacho(){
        Logs.info("Completando formulario de datos del cliente");
        waitForLoaderToDisappear(loaderLocator);

        waitElementVisible(referenciaLocator, "referencia");
        waitElementVisible(dptOficCasaLocator, "Direccion Principal");

        new Actions(getDriver())
                .moveToElement(find(referenciaLocator))
                .click()
                .sendKeys(DatosC.datosCliente().getDireccion().getReferencia())
                .moveToElement(find(dptOficCasaLocator))
                .click()
                .sendKeys(DatosC.datosCliente().getDireccion().getDpto())
                .perform();
    }

    public void llenarDireccion(){
        final var wait = waitElement();

        find(direccionLocator).sendKeys(DatosC.datosCliente().getDireccion().getCalleNumero());

        final var elementOption = wait.until(driver -> {
            final var elements = findAll(addressItemsLocator);
            if (!elements.isEmpty() && elements.get(0).isDisplayed()) {
                return elements.get(0);
            } else {
                return null;
            }
        });

        elementOption.click();
    }

    public void clickContinuarButton(){
        final var wait = waitElement();

        wait.until(ExpectedConditions.not(driver -> {
            final var boton = find(continuarButtonLocator);
            final var clase = boton.getAttribute("class");
            final var disabled = boton.getAttribute("disabled");
            return (clase != null && clase.contains("button--disable")) || disabled != null;
        }));

        waitElementClickable(continuarButtonLocator, "boton continuar");
        find(continuarButtonLocator).click();
    }

    public void validarTituloCarrito(){
        softAssert.assertTrue(find(mensajePagarLocator).isDisplayed());
        softAssert.assertEquals(find(mensajePagarLocator).getText(), "Pagas ahora");
        softAssert.assertAll();
    }

}
