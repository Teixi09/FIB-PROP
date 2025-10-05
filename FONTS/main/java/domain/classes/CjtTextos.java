package domain.classes;
import java.util.ArrayList;
import java.util.HashMap;

    /**
     *  @author Santi Cervera
     */

    public class CjtTextos {

        // ==========================================================
        //           ATRIBUTOS
        // ==========================================================

        /**
         *  Conjunto del textos.
         */
        private HashMap<Integer, Texto> textos;

        // ==========================================================
        //           CONSTRUCTOR
        // ==========================================================

        /**
         * Constructor de conjunto de textos vacio.
         */
        public CjtTextos() {
            textos = new HashMap<>();
        }

        // ==========================================================
        //           FUNCIONES
        // ==========================================================

        /**
         * Añade un texto al conjunto de textos.
         * @param id identificador del texto.
         * @param texto conjunto de simbolos del texto.
         */
        public void crearTexto(Integer id, String texto) {
            textos.put(id, new Texto(texto));
        }

        /**
         * Edita el texto por uno nuevo.
         * @param idTexto id del texto que se quiere modificar.
         * @param newTexto texto modificado.
         */
        public void editarTexto(Integer idTexto, String newTexto) {
            textos.get(idTexto).setTexto(newTexto);
        }

        /**
         * Elimina un texto del conjunto de textos.
         * @param id identificador del alfabeto.
         */
        public void eliminarTexto(Integer id) {
            textos.remove(id);
        }

        /**
         * Getter del texto.
         * @param id id del texto.
         * @return texto.
         */
        public String getTexto(Integer id) {
            return textos.get(id).getTexto();
        }

        /**
         * Getter de los ids de los teclados asociados de un texto
         * @param idTexto id del texto
         * @return idsTecladosAsociados
         */
        public ArrayList<Integer> getIdsTecladosAsociados(Integer idTexto) {
            return textos.get(idTexto).getIdsTecladosAsociados();
        }

        /**
         * Comprueba si un texto esta asociado a algun teclado
         * @param idTexto id del texto del que se quiere comprobar.
         * @return true: si el texto está asociado
         *         false: si el texto no está asociado
         */
        public Boolean hasTecladoAsociado(Integer idTexto) {
            return textos.get(idTexto).hasTecladoAsociado();
        }

        /**
         * Añade un teclado asociado al texto.
         *
         * @param idTexto   id del texto al que se quiere asociar el teclado.
         * @param idTeclado id del teclado asociado.
         */
        public void addTecladoAsociado(Integer idTexto, Integer idTeclado) {
            textos.get(idTexto).addTecladoAsociado(idTeclado);
        }

        /**
         * Elimina un teclado asociado al texto.
         * @param idTexto id del texto del que se quiere quitar el teclado asociado.
         * @param idTeclado id del teclado asociado.
         * @return true: si se ha eliminado correctamente.
         *         false: si no estaba asociado al texto.
         */
        public Boolean deleteTecladoAsociado(Integer idTexto, Integer idTeclado) {
            if (idTexto != -1) return textos.get(idTexto).deleteTecladoAsociado(idTeclado);
            return false;
        }
    }

