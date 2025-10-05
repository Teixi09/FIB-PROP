package persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class controladorPersistencia {

    // ==========================================================
    //           ATRIBUTOS
    // ==========================================================

    private gestorUsuarios gu;
    private gestorListaUsuarios glu;
    private gestorMetadata gm;
    private gestorIO gio;

    // ==========================================================
    //           CONSTRUCTOR
    // ==========================================================

    /**
    * Constructora del controlador de persistencia.
    * Inicializa los gestores.
    *
     */
    public controladorPersistencia() throws IOException {
        glu = new gestorListaUsuarios();
        gm = new gestorMetadata();
        gio = new gestorIO();
    }

    // ==========================================================
    //           FUNCIONES
    // ==========================================================

    /**
     * Inicializa una instancia de usuarios
     *
     */
    public void cargarUsuario(int id) throws IOException {
        gu = new gestorUsuarios(id);
    }

    /**
     * Funcion que se utiliza para obtener la información pertinente a un usuario.
     *
     * @return devuelve una lista con la información pertinente a un usuario, con un formato preestablecido.
     *
     */
    public ArrayList<String> getInfoUsuario() {
        return  gu.getInfoUsuario();
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
        return  gu.getIdElemento(tipo);
    }

    /**
     * Funcion que se utiliza para obtener la información de todos los teclados de un usuario.
     *
     * @return devuelve una lista con la información de todos los teclados de un usuario.
     *
     */
    public ArrayList<ArrayList<String>> getTeclados() {
        return  gu.getTeclados();
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
        return  gu.getElemento(elemento);
    }

    /**
     * Funcion que se utiliza para obtener el conjunto de listas de palabras de un usuario.
     *
     * @return devuelve una lista con todas las listas de palabras de un usuario (solo la lista, no sus propiedades)
     *
     */
    public ArrayList<HashMap<String, Integer>> getLista() {
        return  gu.getLista();
    }

    /**
     * Funcion que se utiliza para modificar la información pertinente a un usuario.
     *
     * @param infoUsuario lista que contiene la nueva información del usuario.
     *
     */
    public void putInfoUsuario(ArrayList<String> infoUsuario) {
        gu.putInfoUsuario(infoUsuario);
    }

    /**
     * Funcion que se utiliza para actualizar los identificadores de un tipo de elemento a un usuario.
     *
     * @param ids lista que contiene la nueva información del usuario.
     * @param tipo String que indentifica el tipo del elemento a modificar.
     *             Pude ser: idTeclados, idAlfabetos, idTextos, idListas
     *
     */
    public void putIdElemento(ArrayList<ArrayList<String>>  ids, String tipo) {
        gu.putIdElemento(ids, tipo);
    }

    /**
     * Funcion que se utiliza para actualizar los teclados de un usuario.
     *
     * @param teclados lista que contiene la nueva información de los teclados.
     *
     */
    public void putTeclado(ArrayList<ArrayList<String>> teclados) {
        gu.putTeclado(teclados);
    }

    /**
     * Funcion que se utiliza para actualizar los elementos, de un tipo específico, del usuario.
     *
     * @param elemento lista que contiene la nueva información de los elementos.
     * @param tipo String que identifica que tipo de elemento se desea actualizar.
     *             Pude ser: textos, listas, alfabetos
     *
     */
    public void putElemento(ArrayList<ArrayList<String>> elemento, String tipo) {
        gu.putElemento(elemento, tipo);
    }

    /**
     * Funcion que se utiliza para actualizar las listas de palabras del usuario.
     *
     * @param palabras lista que contiene unicamente las listas de palabras a actualizar de un usuario.
     *
     */
    public void putLista(ArrayList<HashMap<String, Integer>> palabras) {
        gu.putLista(palabras);
    }


    /**
     * Funcion que se utiliza para obtener una lista de los usuarios y sus identificadores.
     *
     * @return devuelve una lista de los usuarios y sus identificadores.
     *
     */
    public ArrayList<ArrayList<String>> getListaUsuarios() {
        return glu.getUsuarios();
    }

    /**
     * Funcion que se utiliza para obtener los índicies
     *
     * @return devuelve una lista con los índices.
     *
     */
    public ArrayList<Integer> getIndices() {
        return gm.getIndices();
    }

    /**
     * Funcion que se utiliza para actualizar los indicies.
     *
     * @param indicies lista que contiene los nuevos indices.
     *
     */
    public void updateIndices(ArrayList<Integer> indicies) throws IOException {
        gm.updateIndices(indicies);
    }

    /**
     * Funcion que se utiliza para agregar un usuario a la lista de usuarios.
     *
     * @param usuario par que contiene el username del nuevo usuario y su identificador correspondiente.
     *
     */
    public void updateUsuarios(ArrayList<String> usuario) throws IOException {
        glu.updateUsuarios(usuario);
    }

    /**
     * Funcion que se actualiza la lista de usuarios.
     *
     * @param listaUsuarios lista que contiene todos los nuevos username de los usuarios y sus identificadores.
     *
     */
    public void updateListaUsuarios(ArrayList<ArrayList<String>> listaUsuarios) throws IOException {
        glu.updateListaUsuarios(listaUsuarios);
    }

    /**
     * Funcion que crear un nuevo usuario, con su id, username, password y mail
     *
     * @param usuario lista que contiene la informacion del usuario su id, username, password y mail
     *
     */
    public void addUsuario(ArrayList<String> usuario) throws IOException {
        gu.addUsuario(usuario);
    }

    /**
     * Funcion que actualiza al archivo en disco correspondiente al usuario de su inicializacion.
     *
     */
    public void guardarUsuario() throws IOException {
        gu.updateData();
    }

    /**
     * Funcion que extrae el texto de un arhcivo.
     *
     * @param path String que contiene el path del archivo al cual contiene el texto
     *
     */
    public String importarTexto(String path) throws IOException {
        return gio.importarTexto(path);
    }

    /**
     * Funcion que extrae el alfabeto de un arhcivo.
     *
     * @param path String que contiene el path del archivo el cual contiene el alfabeto
     */
    public String importarAlfabeto(String path) throws IOException {
        return gio.importarAlfabeto(path);
    }

    /**
     * Funcion que extrae una lista de palabras de un arhcivo.
     *
     * @param path String que contiene el path del archivo el cual contiene la lista de palabras.
     */
    public HashMap<String, Integer> importarLista(String path) throws Exception {
        return gio.importarLista(path);
    }

    /**
     * Funcion que genera un archivo con un texto.
     *
     * @param path String que contiene el path en el cual se generará el archivo.
     * @param nombre nombre que tendrá el archivo creado.
     * @param texto texto que tendrá el archivo
     */
    public void exportarTexto(String path, String nombre, String texto) throws IOException {
        gio.exportarTexto(path, nombre, texto);
    }

    /**
     * Funcion que genera un archivo con un alfabeto.
     *
     * @param path String que contiene el path en el cual se generará el archivo.
     * @param nombre nombre que tendrá el archivo creado.
     * @param alfabeto alfabeto que tendrá el archivo
     */
    public void exportarAlfabeto(String path, String nombre, String alfabeto) throws IOException {
        gio.exportarAlfabeto(path, nombre, alfabeto);
    }

    /**
     * Funcion que genera un archivo con una lista de palabras.
     *
     * @param path String que contiene el path en el cual se generará el archivo.
     * @param nombre nombre que tendrá el archivo creado.
     * @param lista lista de palabras que tendrá el archivo
     */
    public void exportarLista(String path, String nombre, HashMap<String, Integer> lista) throws IOException {
        gio.exportarLista(path, nombre, lista);
    }

    /**
     * Funcion que genera un archivo con un teclado.
     *
     * @param path String que contiene el path en el cual se generará el archivo.
     * @param nombre nombre que tendrá el archivo creado.
     * @param layout teclado que tendrá el archivo
     */
    public void exportarTeclado(String path, String nombre, char[][] layout) throws IOException {
        gio.exportarTeclado(path, nombre, layout);
    }

    /**
     * Funcion que elimina el archivo correspondiente al usuario activo.
     *
     */
    public void deleteUser() throws IOException {
        gu.deleteUser();
    }
}
