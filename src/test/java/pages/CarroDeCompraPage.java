package pages;

import org.openqa.selenium.By;
import utilities.BasePage;

public class CarroDeCompraPage extends BasePage {

    private final By title = By.className("title-con");
    private final By brand = By.cssSelector(".detail-info > .p-title");
    private final By continuarButtonLocator = By.xpath("//button[span[text()='Continuar']]");

    @Override
    public void waitPageToLoad() {
        waitPage(continuarButtonLocator, getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(find(continuarButtonLocator).isDisplayed());
        softAssert.assertAll();
    }

    public void clickContinuarButton(){
        waitElementClickable(continuarButtonLocator, "Boton Continuar");
        find(continuarButtonLocator).click();
    }
}
