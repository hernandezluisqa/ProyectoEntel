package automation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CarroDeCompraPage;
import pages.DatosDespachoPage;
import pages.EquipoDetailPage;
import pages.EquiposAccesoriosPage;
import pages.HomePage;
import pages.IdentificacionPage;
import utilities.BaseTest;

public class ProductosTests extends BaseTest {

    private final HomePage homePage = new HomePage();
    private final EquiposAccesoriosPage equiposAccesoriosPage = new EquiposAccesoriosPage();
    private final EquipoDetailPage equipoDetailPage = new EquipoDetailPage();

    private final IdentificacionPage identificacionPage = new IdentificacionPage();
    private final DatosDespachoPage datosDespachoPage = new DatosDespachoPage();

    private final CarroDeCompraPage carroDeCompraPage = new CarroDeCompraPage();

    @BeforeMethod
    public void setUp() {
        final var url = "https://www.entel.cl/";
        driver.get(url);
        homePage.clickEquiposButton();
    }

    @Test (groups = {smoke})
    public void buscarEquipoPorSKU() {
        equiposAccesoriosPage.buscarPorSku(0);
        equiposAccesoriosPage.abrirEquipoBuscado();

        equipoDetailPage.waitPageToLoad();
        equipoDetailPage.verifyPage();
        equipoDetailPage.verifyPhone(0);
        equipoDetailPage.comprarEquipoPrecioGeneral();

        identificacionPage.waitPageToLoad();
        identificacionPage.verifyPage();
        identificacionPage.llenarFormularioDatosValidos();

        carroDeCompraPage.waitPageToLoad();
        carroDeCompraPage.verifyPage();
        carroDeCompraPage.clickContinuarButton();

        datosDespachoPage.waitPageToLoad();
        datosDespachoPage.verifyPage();
        //datosDespachoPage.llenarDireccion();
        datosDespachoPage.llenarDatosDespacho();
        //datosDespachoPage.clickContinuarButton();

    }

    @Test (groups = {smoke})
    public void clickeandoTecnologia() {
        homePage.clickTecnologia();
    }

    @Test (groups = {smoke})
    public void comprarProducto() {
        equiposAccesoriosPage.buscarPorSku(1);
        equiposAccesoriosPage.abrirEquipoBuscado();
        equipoDetailPage.verifyPage();
        equipoDetailPage.verifyPhone(1);
    }
}
