package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BasePage;

import java.time.Duration;

public class HomePage extends BasePage {
    final By headerShadowRoot = By.cssSelector("andino-header");
    //Header Locators from ShadowRoot
    final By headerMenu = By.cssSelector(".eds-header__menu-desk__nav");
    final By equiposMenu = By.cssSelector("#list-item-3");
    final By tecnologiaLocator = By.cssSelector("a#list-item-4");
    //$("andino-header").shadowRoot.querySelector("a#list-item-4")

    @Step("Waiting loading page.")
    @Override
    public void waitPageToLoad() {
        waitPage(headerShadowRoot, getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
    }

    public void clickTecnologia(){
        final var shadowRootHeaderElement = find(headerShadowRoot).getShadowRoot();
        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        final WebElement tecnologiaElement = wait.until(driver -> {
            WebElement element = shadowRootHeaderElement.findElement(tecnologiaLocator);
            if (element.isDisplayed() && element.isEnabled()) {
                return element;
            }
            return null;
        });

        tecnologiaElement.click();
    };

    public void openEquiposMenu(){
        final var headerShadowRootElements = find(headerShadowRoot).getShadowRoot();
        final var headerMenuElement = headerShadowRootElements.findElement(headerMenu);
        final var equiposMenuElement = headerMenuElement.findElement(equiposMenu);
        new Actions(getDriver())
                .moveToElement(equiposMenuElement)
                .perform();
    }

    public void clickEquiposButton(){
        final var headerShadowRootElements = find(headerShadowRoot).getShadowRoot();
        final var headerMenuElement = headerShadowRootElements.findElement(headerMenu);
        final var equiposMenuElement = headerMenuElement.findElement(equiposMenu);

        equiposMenuElement.click();
    }
}
