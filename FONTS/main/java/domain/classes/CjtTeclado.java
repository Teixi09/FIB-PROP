package domain.classes;

import java.util.HashMap;

public class CjtTeclado {

    // ==========================================================
    //           ATRIBUTOS
    // ==========================================================

    /**
     *  Conjunto de teclados.
     */
    private HashMap<Integer, Teclado> teclados;

    // ==========================================================
    //           CONSTRUCTOR
    // ==========================================================

    /**
     * Constructor de conjunto de teclados vacio.
     */
    public CjtTeclado() {
        teclados = new HashMap<>();
    }

    // ==========================================================
    //           FUNCIONES
    // ==========================================================

    /**
     * Añade un teclado al conjunto de teclados.
     * @param id identificador del alfabeto.
     * @param idAlfabeto identificador del alfabeto asociado.
     * @param idTexto identificador del texto asociado. (-1 si no tiene)
     * @param idLista identificador de la lista asociada. (-1 si no tiene)
     * @param layout distribucion de teclas correspondiente del teclado.
     */
    public void crearTeclado(Integer id, Integer idAlfabeto, Integer idTexto, Integer idLista, char[][] layout) {
        teclados.put(id, new Teclado(layout, idAlfabeto, idTexto, idLista));
    }

    /**
     * Elimina un teclado del conjunto de teclados.
     * @param id identificador del alfabeto.
     */
    public void eliminarTeclado(Integer id) {
        teclados.remove(id);
    }

    /**
     * Getter del id del alfabeto asociado al teclado.
     * @param idTeclado id del teclado a consultar.
     * @return idAlfabeto;
     */
    public Integer getIdAlfabeto(Integer idTeclado) {
        return teclados.get(idTeclado).getIdAlfabeto();
    }

    /**
     * Getter del id del texto asociado al teclado
     * @param idTeclado id del teclado a consultar.
     * @return idTexto;
     */
    public Integer getIdTexto(Integer idTeclado) {
        return teclados.get(idTeclado).getIdTexto();
    }

    /**
     * Getter del id de la lista asociada al teclado.
     * @param idTeclado id del teclado a consultar.
     * @return idLista;
     */
    public Integer getIdLista(Integer idTeclado) {
        return teclados.get(idTeclado).getIdLista();
    }

    public char[][] getLayoutTeclado(Integer idTeclado) {
        return teclados.get(idTeclado).getLayout();
    }
}
