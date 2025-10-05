package persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class gestorIO {

    /**
     * Constructora del gestorIO.
     *
     */
    public gestorIO() {}

    /**
     * Funcion que se encarga de leer un archivo que se encuentra en path dado
     * @param path String que representa el path del archivo el cual se quiere leer.
     * @return devuelve un string con el contenido del archivo
     */
    private String readFile(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    /**
     * Funcion que se encarga de crear un archivo en un path dado
     *
     * @param path String que representa el path en donde se creará el archivo.
     * @param nombre String que representa nombre que tendrá el archivo.
     * @param texto String que contiene el texto que tendrá el archivo.
     *
     * @return devuelve un string con el contenido del archivo
     */
    private void writeFile(String path, String nombre, String texto) throws IOException {
        path += "/"+nombre;
        Files.write(Paths.get(path), texto.getBytes(), StandardOpenOption.CREATE);
    }

    /**
     * Funcion que extrae el texto de un arhcivo.
     *
     * @param path String que contiene el path del archivo al cual contiene el texto
     *
     */
    public String importarTexto(String path) throws IOException {
        return readFile(path);
    }

    /**
     * Funcion que extrae el alfabeto de un arhcivo.
     *
     * @param path String que contiene el path del archivo el cual contiene el alfabeto
     */
    public String importarAlfabeto(String path) throws IOException {
        return readFile(path);
    }

    /**
     * Funcion que extrae una lista de palabras de un arhcivo.
     *
     * @param path String que contiene el path del archivo el cual contiene la lista de palabras.
     */
    public HashMap<String, Integer> importarLista(String path) throws Exception {
        String text = readFile(path);
        HashMap<String, Integer> lista = new HashMap<>();
        String[] filas = text.split("\n");
        for (String fila : filas) {
            fila = fila.replaceAll("\r", "");
            String[] palabras = fila.split(" ");
            if (palabras.length != 2) throw new Exception("formato incorrecto");
            lista.put(palabras[0], Integer.parseInt(palabras[1])); // Hay que tener encunta el posible excepction
        }
        return lista;
    }

    /**
     * Funcion que genera un archivo con un alfabeto.
     *
     * @param path String que contiene el path en el cual se generará el archivo.
     * @param nombre nombre que tendrá el archivo creado.
     * @param alfabeto alfabeto que tendrá el archivo
     */
    public void exportarAlfabeto(String path, String nombre, String alfabeto) throws IOException {
        writeFile(path, nombre, alfabeto);
    }

    /**
     * Funcion que genera un archivo con un texto.
     *
     * @param path String que contiene el path en el cual se generará el archivo.
     * @param nombre nombre que tendrá el archivo creado.
     * @param texto texto que tendrá el archivo
     */
    public void exportarTexto(String path, String nombre, String texto) throws IOException {
        writeFile(path, nombre, texto);
    }

    /**
     * Funcion que genera un archivo con un teclado.
     *
     * @param path String que contiene el path en el cual se generará el archivo.
     * @param nombre nombre que tendrá el archivo creado.
     * @param layout teclado que tendrá el archivo
     */
    public void exportarTeclado(String path, String nombre, char[][] layout) throws IOException {
        StringBuilder texto = new StringBuilder();
        for(char[] fila : layout) {
            texto.append(Arrays.toString(fila)).append("\n");
        }
        writeFile(path, nombre, texto.toString());
    }

    /**
     * Funcion que genera un archivo con una lista de palabras.
     *
     * @param path String que contiene el path en el cual se generará el archivo.
     * @param nombre nombre que tendrá el archivo creado.
     * @param lista lista de palabras que tendrá el archivo
     */
    public void exportarLista(String path, String nombre, HashMap<String, Integer> lista) throws IOException {
        StringBuilder texto = new StringBuilder();
        for (Map.Entry<String, Integer> e : lista.entrySet()) {
            texto.append(e.getKey()).append(" ").append(e.getValue()).append("\n");
        }
        writeFile(path, nombre, texto.toString());
    }

}
