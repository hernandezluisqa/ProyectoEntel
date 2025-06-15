package pages;

import modelos.Equipo;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import reader.JsonReader;
import utilities.BasePage;

public class EquiposAccesoriosPage extends BasePage {

    private final By searchInput = By.cssSelector("#searchBody > .form-group > #searchInputBox");
    private final By producto = By.cssSelector(".search-results > .list-unstyled > li > a");

    @Override
    public void waitPageToLoad() {
        waitPage(searchInput, getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {

    }

    public Equipo seleccionarEquipo(int position){
        final var equipos = JsonReader.leerEquiposAccesoriosJson();
        return equipos.get(position);
    }

    public void buscarPorSku(int jsonPosition){
        final Equipo telefono = JsonReader.leerEquiposAccesoriosJson().get(jsonPosition);

        final var telefonoSku = telefono.getSku();

        final var searchElement = find(searchInput);
        new Actions(getDriver())
                .moveToElement(searchElement)
                .click()
                .sendKeys(telefonoSku)
                .perform();
    }

    public void abrirEquipoBuscado(){
        waitPage(producto, getClass().getSimpleName());
        find(producto).click();
    }
}
