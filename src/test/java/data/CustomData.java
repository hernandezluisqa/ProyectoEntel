package data;

import org.testng.annotations.DataProvider;
import reader.ExcelReader;

import reader.JsonReader;
public class CustomData {
    public static final String DP_NAME = "Data Monstruo"; //de excel

    @DataProvider(name = DP_NAME) //para excel
    public Object[][] monstruoDataProvider(){
        final var listaMonstruo = ExcelReader.obtenerListaMonstruos(); //tengo que obtener la lista

        final var n = listaMonstruo.size();
        final var object = new Object[n][];

        for (var i = 0; i < n; i++) {
            object[i] = new Object[] {listaMonstruo.get(i)};
        }

        return object;
    }

    @DataProvider(name = "telefonosData") //Para json
    public Object[][] telefonosDataProvider() {
        final var equipos = JsonReader.leerEquiposAccesoriosJson();

        final var n = equipos.size();
        final var object = new Object[n][];

        for (int i = 0; i < n; i++) {
            object[i] = new Object[]{equipos.get(i)};
        }

        return object;
    }
}
