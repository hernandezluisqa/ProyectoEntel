package reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import modelos.DatosCliente;
import modelos.Equipo;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonReader {
    private final static String jsonPathTelefonosAccesorios = "src/main/resources/data/equipos.json";
    private final static String JsonPathDatosCliente = "src/main/resources/data/datosCliente.json";

    public static List<Equipo> leerEquiposAccesoriosJson(){
        final var objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(
                    new File(jsonPathTelefonosAccesorios),
                    new TypeReference<List<Equipo>>() {}
            );
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo JSON", e);
        }
    }

    public static DatosCliente leerDatosClienteJson(){
        final var objectMapper = new ObjectMapper();
        try{
            return objectMapper.readValue(new File(JsonPathDatosCliente),DatosCliente.class);
        } catch (IOException e){
            throw new RuntimeException("Error leyendo JSON", e);
        }
    }
}
