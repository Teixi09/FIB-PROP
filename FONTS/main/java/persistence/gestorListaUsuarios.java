package persistence;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class gestorListaUsuarios {

    // ==========================================================
    //           ATRIBUTOS
    // ==========================================================

    private String path;
    private JsonArray gsonArr;
    private String json;

    // ==========================================================
    //           CONSTRUCTOR
    // ==========================================================

    /**
     * Constructora del gestorListaUsuarios.
     * Carga en memoria, como un string, el contenido del archivo que contiene la lista de usuarios, se guarda en
     * el atributo json
     *
     */
    public gestorListaUsuarios() {
        path = System.getProperty("user.dir")+"/data/usuarios.json";
        json="";

        try {
            json = new String(Files.readAllBytes(Paths.get(path)));
        } catch (Exception e) {
            System.out.println("Problema excepcion:" + e);
        }
    }

    // ==========================================================
    //           FUNCIONES
    // ==========================================================

    /**
     * Funcion que se utiliza para obtener una lista de los usuarios y sus identificadores.
     *
     * @return devuelve una lista de los usuarios y sus identificadores.
     *
     */
    public ArrayList<ArrayList<String>> getUsuarios() {
        gsonArr = (JsonArray) JsonParser.parseString(json).getAsJsonObject().get("usuario");
        ArrayList<ArrayList<String>> usuarios = new ArrayList<>();
        for (JsonElement e : gsonArr) {
            JsonObject g = e.getAsJsonObject();
            ArrayList<String> usuario = new ArrayList<>();
            usuario.add(g.get("username").getAsString());
            usuario.add(g.get("id").getAsString());
            usuarios.add(usuario);
        }
        return usuarios;
    }

    /**
     * Funcion que se utiliza para agregar un usuario a la lista de usuarios.
     *
     * @param usuario par que contiene el username del nuevo usuario y su identificador correspondiente.
     *
     */
    public void updateUsuarios(ArrayList<String> usuario) throws IOException {
        JsonObject nuevoUsuario = new JsonObject();
        nuevoUsuario.addProperty("username", usuario.get(0));
        nuevoUsuario.addProperty("id", Integer.parseInt(usuario.get(1)));
        gsonArr.add(nuevoUsuario);
        JsonObject principal = new JsonObject();
        principal.add("usuario", gsonArr);
        updateFile(principal);
    }

    /**
     * Funcion que se actualiza la lista de usuarios.
     *
     * @param listaUsuarios lista que contiene todos los nuevos username de los usuarios y sus identificadores.
     *
     */
    public void updateListaUsuarios(ArrayList<ArrayList<String>> listaUsuarios) throws IOException {
        gsonArr = new JsonArray();
        for(ArrayList<String> usuario: listaUsuarios) {
            JsonObject nuevoUsuario = new JsonObject();
            nuevoUsuario.addProperty("username", usuario.get(0));
            nuevoUsuario.addProperty("id", Integer.parseInt(usuario.get(1)));
            gsonArr.add(nuevoUsuario);
        }
        JsonObject principal = new JsonObject();
        principal.add("usuario", gsonArr);
        updateFile(principal);
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
