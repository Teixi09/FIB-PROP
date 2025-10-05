package persistence;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class gestorUsuarios {

    // ==========================================================
    //           ATRIBUTOS
    // ==========================================================

    private String json;
    private String path;
    private JsonArray usuarioArr;
    private JsonArray tecladosArr;
    private JsonArray alfabetosArr;
    private JsonArray textosArr;
    private JsonArray listasArr;
    private JsonObject usuarioObj;
    private JsonObject principal;

    // ==========================================================
    //           CONSTRUCTOR
    // ==========================================================

    /**
     * Constructora del gestorUsuarios.
     * Carga en memoria, como un string, el contenido del archivo que contiene al usuario idUser, se guarda en
     * el atributo json. En caso de no existir este archivo, lo crea.
     *
     * @param idUser identificador del usuario del que se desea recuperar la información
     *
     */
    public gestorUsuarios(int idUser) throws IOException {

        path = System.getProperty("user.dir")+"/data/usuarios";
        path += ("/user_" + idUser + ".json");
        json="";
        try {
            json = new String(Files.readAllBytes(Paths.get(path)));
        } catch (Exception e) {
            System.out.println("Problema excepcion:" + e);
            String jsonTemplate = "{\"usuario\":[{\"id\":-1,\"username\":\"\",\"password\":\"\",\"mail\":\"\",\"idTeclados\":[],\"idAlfabetos\":[],\"idTextos\":[],\"idListas\":[]}],\"teclados\":[],\"alfabetos\":[],\"textos\":[],\"listas\":[]}";
            Files.write(Paths.get(path), jsonTemplate.getBytes(), StandardOpenOption.CREATE);
            json = jsonTemplate;
            System.out.println("Archivo creado exitosamente.");
        }

        getData();
    }

    // ==========================================================
    //           FUNCIONES
    // ==========================================================

    /**
     * Funcion que le asigna a los atributos usuarioArr, tecladosArr, alfabetosArr, textosArr, listasArr, usuarioObj
     * la información extraida del archivo del usuario.
     *
     */
    public void getData() {
        usuarioArr = (JsonArray) JsonParser.parseString(json).getAsJsonObject().get("usuario");
        tecladosArr = (JsonArray) JsonParser.parseString(json).getAsJsonObject().get("teclados");
        alfabetosArr = (JsonArray) JsonParser.parseString(json).getAsJsonObject().get("alfabetos");
        textosArr = (JsonArray) JsonParser.parseString(json).getAsJsonObject().get("textos");
        listasArr = (JsonArray) JsonParser.parseString(json).getAsJsonObject().get("listas");
        usuarioObj = usuarioArr.get(0).getAsJsonObject();
    }

    /**
     * Funcion que se utiliza para obtener la información pertinente a un usuario.
     *
     * @return devuelve una lista con la información pertinente a un usuario, con un formato preestablecido.
     *
     */
    public ArrayList<String> getInfoUsuario() {
        ArrayList<String> usuario = new ArrayList<>();

        usuario.add(usuarioObj.get("id").getAsString());
        usuario.add(usuarioObj.get("username").getAsString());
        usuario.add(usuarioObj.get("password").getAsString());
        usuario.add(usuarioObj.get("mail").getAsString());
        return usuario;
    }

    /**
     * Funcion que se utiliza para obtener los identificadores de un tipo de elemento del usuario.
     *
     * @param tipo String que representa el elemento del cual se quieren obtener sus identificadores
     *             Pude ser: idTeclados, idAlfabetos, idTextos, idListas
     * @return devuelve una lista con los identificadores de un tipo de elemento del usuario.
     *
     */
    public ArrayList<ArrayList<String>> getIdElemento(String tipo) {
        JsonArray ids = usuarioObj.get(tipo).getAsJsonArray();
        ArrayList<ArrayList<String>>  idTeclados = new ArrayList<>();

        for (JsonElement e : ids) {
            JsonObject g = e.getAsJsonObject();
            ArrayList<String> par = new ArrayList<>();
            par.add(g.get("nombre").getAsString());
            par.add(g.get("id").getAsString());
            idTeclados.add(par);
        }
        return idTeclados;
    }

    /**
     * Funcion que se utiliza para obtener la información de todos los teclados de un usuario.
     *
     * @return devuelve una lista con la información de todos los teclados de un usuario.
     *
     */
    public ArrayList<ArrayList<String>> getTeclados() {
        ArrayList<ArrayList<String>> teclados = new ArrayList<>();

        for (JsonElement obj : tecladosArr) {
            JsonObject gsonObj = obj.getAsJsonObject();
            ArrayList<String> teclado = new ArrayList<>();

            teclado.add(gsonObj.get("id").getAsString());
            teclado.add(gsonObj.get("layout").getAsString());
            teclado.add(gsonObj.get("idAlfabeto").getAsString());
            teclado.add(gsonObj.get("idTexto").getAsString());
            teclado.add(gsonObj.get("idLista").getAsString());
            teclados.add(teclado);
        }
        return teclados;
    }

    /**
     * Funcion que se utiliza para obtener la información de todos los elementos, de un tipo en concreto, de un usuario.
     *
     * @param elemento String que identifica que tipo de elemento se desea,
     *                 Su posible valores son: teclados, textos, listas, alfabetos.
     * @return devuelve una lista con la información de todos los teclados de un usuario.
     *
     */
    public ArrayList<ArrayList<String>> getElemento(String elemento) {
        ArrayList<ArrayList<String>> elementos = new ArrayList<>();
        JsonArray gsonArr = new JsonArray();
        switch (elemento) {
            case "telcados":
                gsonArr = tecladosArr;
                break;
            case "textos":
                gsonArr = textosArr;
                break;
            case "listas":
                gsonArr = listasArr;
                break;
            case "alfabetos":
                gsonArr = alfabetosArr;
                break;
        }

        for (JsonElement obj : gsonArr) {
            JsonObject gsonObj = obj.getAsJsonObject();
            ArrayList<String> lelemento = new ArrayList<>();

            lelemento.add(gsonObj.get("id").getAsString());
            if(!elemento.equals("listas")) lelemento.add(gsonObj.get("elemento").getAsString());
            lelemento.add(gsonObj.get("idTeclados").getAsString());
            elementos.add(lelemento);
        }
        return elementos;
    }

    /**
     * Funcion que se utiliza para obtener el conjunto de listas de palabras de un usuario.
     *
     * @return devuelve una lista con todas las listas de palabras de un usuario (solo la lista, no sus propiedades)
     *
     */
    public ArrayList<HashMap<String,Integer>> getLista() {
        ArrayList<HashMap<String,Integer>> listas = new ArrayList<>();

        for (JsonElement obj : listasArr) {
            JsonObject gsonObj = obj.getAsJsonObject();
            JsonArray l = gsonObj.get("elemento").getAsJsonArray();
            HashMap<String, Integer> lista = new HashMap<>();
            for (int i=0; i < l.size(); ++i) {
                JsonObject gsonObj2 = l.get(i).getAsJsonObject();
                lista.put(gsonObj2.get("palabra").getAsString(), Integer.parseInt(gsonObj2.get("frecuencia").getAsString()));
            }
            listas.add(lista);
        }
        return listas;
    }

    /**
     * Funcion que crear un nuevo usuario, con su id, username, password y mail
     *
     * @param usuario lista que contiene la informacion del usuario su id, username, password y mail
     *
     */
    public void addUsuario(ArrayList<String> usuario) throws IOException {
        usuarioObj.remove("id");
        usuarioObj.addProperty("id", Integer.parseInt(usuario.get(0)));
        usuarioObj.remove("username");
        usuarioObj.addProperty("username", usuario.get(1));
        usuarioObj.remove("password");
        usuarioObj.addProperty("password", usuario.get(2));
        usuarioObj.remove("mail");
        usuarioObj.addProperty("mail", usuario.get(3));

        usuarioArr = new JsonArray();
        usuarioArr.add(usuarioObj);

        updateData();
    }

    /**
     * Funcion que se utiliza para modificar la información pertinente a un usuario.
     *
     * @param infoUsuario lista que contiene la nueva información del usuario.
     *
     */
    public void putInfoUsuario(ArrayList<String> infoUsuario) {
        usuarioObj = new JsonObject();
        usuarioObj.addProperty("id", infoUsuario.get(0));
        usuarioObj.addProperty("username", infoUsuario.get(1));
        usuarioObj.addProperty("password",infoUsuario.get(2));
        usuarioObj.addProperty("mail", infoUsuario.get(3));
    }

    /**
     * Funcion que se utiliza para actualizar los identificadores de un tipo de elemento a un usuario.
     *
     * @param ids lista que contiene la nueva información del usuario.
     * @param tipo String que indentifica el tipo del elemento a modificar.
     *             Pude ser: idTeclados, idAlfabetos, idTextos, idListas
     *
     */
    public void putIdElemento(ArrayList<ArrayList<String>> ids, String tipo) {
        JsonArray jsonIds = new JsonArray();
        for (ArrayList<String> id : ids) {
            JsonObject jsonId = new JsonObject();
            jsonId.addProperty("nombre",id.get(0));
            jsonId.addProperty("id",id.get(1));
            jsonIds.add(jsonId);
        }
        usuarioObj.add(tipo,jsonIds);
        usuarioArr = new JsonArray();
        usuarioArr.add(usuarioObj);
    }

    /**
     * Funcion que se utiliza para actualizar los teclados de un usuario.
     *
     * @param teclados lista que contiene la nueva información de los teclados.
     *
     */
    public void putTeclado(ArrayList<ArrayList<String>> teclados) {
        tecladosArr = new JsonArray();
        for (ArrayList<String> teclado : teclados) {
            JsonObject jsonTeclado = new JsonObject();
            jsonTeclado.addProperty("id", teclado.get(0));
            jsonTeclado.addProperty("layout", teclado.get(1));
            jsonTeclado.addProperty("idAlfabeto", teclado.get(2));
            jsonTeclado.addProperty("idTexto", teclado.get(3));
            jsonTeclado.addProperty("idLista", teclado.get(4));
            tecladosArr.add(jsonTeclado);
        }
    }

    /**
     * Funcion que se utiliza para actualizar los elementos, de un tipo específico, del usuario.
     *
     * @param elementos lista que contiene la nueva información de los elementos.
     * @param tipo String que identifica que tipo de elemento se desea actualizar.
     *             Pude ser: textos, listas, alfabetos
     *
     */
    public void putElemento(ArrayList<ArrayList<String>> elementos, String tipo) {
        JsonArray gsonArr = new JsonArray();
        switch (tipo) {
            case "textos":
                textosArr = new JsonArray();
                gsonArr = textosArr;
                break;
            case "listas":
                listasArr = new JsonArray();
                gsonArr = listasArr;
                break;
            case "alfabetos":
                alfabetosArr = new JsonArray();
                gsonArr = alfabetosArr;
                break;
        }

        for (ArrayList<String> elemento : elementos) {
            JsonObject jsonElemento = new JsonObject();
            jsonElemento.addProperty("id", elemento.get(0));
            if(!tipo.equals("listas")) jsonElemento.addProperty("elemento", elemento.get(1));
            jsonElemento.addProperty("idTeclados", elemento.get(2));
            gsonArr.add(jsonElemento);
        }
    }

    /**
     * Funcion que se utiliza para actualizar las listas de palabras del usuario.
     *
     * @param palabras lista que contiene unicamente las listas de palabras a actualizar de un usuario.
     *
     */
    public void putLista(ArrayList<HashMap<String, Integer>> palabras) {
        int indice=0;
        for(HashMap<String,Integer> m : palabras) {
            JsonArray ps = new JsonArray();
            for (Map.Entry<String, Integer> entry : m.entrySet()) {
                JsonObject jsonPalabra = new JsonObject();
                jsonPalabra.addProperty("palabra" ,entry.getKey());
                jsonPalabra.addProperty("frecuencia" ,entry.getValue());
                ps.add(jsonPalabra);
            }
            listasArr.get(indice).getAsJsonObject().add("elemento", ps);
            ++indice;
        }
    }

    /**
     * Funcion que actualiza al archivo en disco correspondiente al usuario de su inicializacion.
     *
     */
    public void updateData() throws IOException {
        principal = new JsonObject();
        principal.add("usuario", usuarioArr);
        principal.add("teclados", tecladosArr);
        principal.add("alfabetos", alfabetosArr);
        principal.add("textos", textosArr);
        principal.add("listas", listasArr);
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
        json = jsonContent.toString();
        file.write(jsonContent.toString());
        file.close();

    }

    /**
     * Funcion que elimina el archivo correspondiente al usuario activo.
     *
     */
    public void deleteUser() throws IOException {
        Files.delete(Paths.get(path));
    }
}
