package persistence;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class gestorMetadata {

    // ==========================================================
    //           ATRIBUTOS
    // ==========================================================

    JsonArray gsonArr;
    private String json;
    private String path;

    // ==========================================================
    //           CONSTRUCTOR
    // ==========================================================

    /**
     * Constructora del gestorMetadata.
     * Carga en memoria, como un string, el contenido del archivo que contiene los metadatos, se guarda en
     * el atributo json
     *
     */
    public gestorMetadata() throws IOException {
        path = System.getProperty("user.dir")+"/data/metadata.json";
        json="";
        json = new String(Files.readAllBytes(Paths.get(path)));

    }

    // ==========================================================
    //           FUNCIONES
    // ==========================================================

    /**
     * Funcion que se utiliza para obtener los índicies
     *
     * @return devuelve una lista con los índices.
     *
     */
    public ArrayList<Integer> getIndices() {
            gsonArr = (JsonArray) JsonParser.parseString(json).getAsJsonObject().get("indicies");
            JsonObject gsonObj = gsonArr.get(0).getAsJsonObject();
            ArrayList<Integer> Indices = new ArrayList<>();
            Indices.add(gsonObj.get("idUsuario").getAsInt());
            Indices.add(gsonObj.get("idTeclado").getAsInt());
            Indices.add(gsonObj.get("idAlfabeto").getAsInt());
            Indices.add(gsonObj.get("idTexto").getAsInt());
            Indices.add(gsonObj.get("idLista").getAsInt());
            return Indices;
    }

    /**
     * Funcion que se utiliza para actualizar los indicies.
     *
     * @param indicies lista que contiene los nuevos indices.
     *
     */
    public void updateIndices(ArrayList<Integer> indicies) throws IOException {
        JsonObject gsonObj = gsonArr.get(0).getAsJsonObject();
        gsonObj.remove("idUsuario");
        gsonObj.remove("idTeclado");
        gsonObj.remove("idAlfabeto");
        gsonObj.remove("idTexto");
        gsonObj.remove("idLista");
        gsonObj.addProperty("idUsuario",indicies.get(0));
        gsonObj.addProperty("idTeclado",indicies.get(1));
        gsonObj.addProperty("idAlfabeto",indicies.get(2));
        gsonObj.addProperty("idTexto",indicies.get(3));
        gsonObj.addProperty("idLista",indicies.get(4));

        JsonObject jsonObjectPrincipal = new JsonObject();
        JsonArray jsonArrayIndicies = new JsonArray();
        jsonArrayIndicies.add(gsonObj);
        jsonObjectPrincipal.add("indicies", jsonArrayIndicies);
        updateFile(jsonObjectPrincipal);
    }

    /**
     * Funcion que actualiza el contenido del fichero con los cambios realzados antes de su llamado.
     *
     * @param jsonContent JsonObject que contiene la información nueva para el archivo.
     *
     */
    private void updateFile(JsonObject jsonContent) throws IOException {
        FileWriter file = new FileWriter(path);
        file.write(jsonContent.toString());
        file.close();

    }
}
