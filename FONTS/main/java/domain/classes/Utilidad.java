package domain.classes;

import java.util.HashMap;

public class Utilidad {
    // ==========================================================
    //           ATRIBUTOS
    // ==========================================================


    // ==========================================================
    //           CONSTRUCTOR
    // ==========================================================

    /**
     * Constructor de Utilidad
     */
    public Utilidad() {
    }

    // ==========================================================
    //           FUNCIONES
    // ==========================================================

    /**
     * Comprueba que el nombre cumple los requerimientos.
     *
     * @param nombre nombre a comprobar.
     */

    public Boolean comprobarPasswordONombre(String nombre) {
        if (nombre.indexOf('"') != -1 || nombre.indexOf(',') != -1) return false;
        Integer length = nombre.length();

        for (int i = 0; i < nombre.length(); ++i) {
            Character charAnalizado = nombre.charAt(i);
            if (charAnalizado < 33 || charAnalizado > 126 || charAnalizado == 34 || charAnalizado == 44) return false;
        }
        return !(length > 20 || length < 3);
    }

    /**
     * Comprueba que el alfabeto cumple los requerimientos.
     *
     * @param alfabeto alfabeto a comprobar.
     */
    public Boolean comprobarAlfabeto(String alfabeto) {
        Integer length = alfabeto.length();
        if (length > 256 || length < 1) return false;

        //comprobamos que el alfabeto no tiene caracteres repetidos
        for (Character c : alfabeto.toCharArray())
            if (alfabeto.indexOf(c) != alfabeto.lastIndexOf(c)) return false;
        return true;
    }

    public Boolean comprobarTexto(String texto) {
        long count = texto.chars().filter(ch -> ch == ' ').count();
        long length = texto.chars().filter(ch -> ch != ' ').count();
        return !(length > 10240) && !(count > 1023);
    }

    /**
     * Comprueba que la lista de palabras cumpla los requerimientos.
     *
     * @param listaPalabras lista de palabras a comprobar.
     */
    public Boolean comprobarListaPalabras(HashMap<String, Integer> listaPalabras) {
        Integer total = 0, total2 = 0;
        for (HashMap.Entry<String, Integer> entrada : listaPalabras.entrySet()) {
            total2 += entrada.getKey().length() * entrada.getValue();
            total += entrada.getValue();
        }
        return (total <= 1024) && (total2 <= 10240);
    }

    /**
     * Comprueba que el correo existe
     *
     * @param correo correo a comprobar.
     */
    public Boolean comprobarCorreo(String correo) {
        Boolean valid = true;

        //comprueba que el correo no contiene espacios.
        if (correo.indexOf(' ') != -1) valid = false;

        //comprueba que el correo contiene un solo @.
        String aux = correo.replace('@', ' ');
        if (aux.split(" ").length != 2) valid = false;

        //comprueba que el correo contiene, como mínimo un punto en el dominio.
        if (valid) aux = correo.substring(correo.indexOf("@"));
        if (aux.split("\\.").length < 2) valid = false;

        return valid;
    }

    /**
     * Crea una lista de palabras a partir de un texto
     *
     * @param texto texto a convertir.
     * @return listaPalabras
     */
    public HashMap<String, Integer> conversorTextoLista(String texto) {
        //Convertimos el strig aux en un vector separando las palabras segun los espacios.
        String[] palabras = texto.split(" ");

        //Si la palabra ya esta en el mapa sumamos 1 al value si no la añadimos con value 1.
        HashMap<String, Integer> listaPalabras = new HashMap<>();
        for (String palabra : palabras) {
            if (!listaPalabras.containsKey(palabra)) listaPalabras.put(palabra, 1);
            else listaPalabras.put(palabra, listaPalabras.get(palabra) + 1);
        }
        return listaPalabras;
    }

    /**
     *
     * @param alfabeto
     * @param texto
     * @return
     */
    public Boolean comprobarCompatibilidadTextoAlfabeto(String alfabeto, String texto) {
        for (Character a : texto.toCharArray()) {
            if (a != ' ' && !alfabeto.contains(a.toString().toLowerCase())) return false;
        }
        return true;
    }

    /**
     *
     * @param alfabeto
     * @param lista
     * @return
     */
    public Boolean comprobarCompatibilidadListaAlfabeto(String alfabeto, HashMap<String, Integer> lista) {
        for (HashMap.Entry<String, Integer> entrada : lista.entrySet()) {
            for (Character a : entrada.getKey().toCharArray()) {
                if (a != ' ' && !alfabeto.contains(a.toString().toLowerCase())) return false;
            }
        }
        return true;
    }


}
