package domain.classes;


public class Teclado {
    // ==========================================================
    //           ATRIBUTOS
    // ==========================================================

    /**
     * Distribucion de las teclas.
     */
    private char[][] layout;

    /**
     * Identificador del alfabeto asociado (-1 si no tiene)
     */
    private Integer idAlfabeto;

    /**
     * Identificador del texto asociado (-1 si no tiene)
     */
    private Integer idTexto;

    /**
     * Identificador de la lista (-1 si no tiene)
     */
    private Integer idLista;
    // ==========================================================
    //           CONSTRUCTOR
    // ==========================================================

    /**
     * Constructor del teclado.
     */
    public Teclado(char[][] layout, Integer idAlfabeto, Integer idTexto, Integer idLista) {
        this.layout = layout;
        this.idAlfabeto = idAlfabeto;
        this.idTexto = idTexto;
        this.idLista = idLista;
    }

    // ==========================================================
    //           FUNCIONES
    // ==========================================================

    /**
     * Getter del layout.
     * @return layout
     */
    public char[][] getLayout() {
        return this.layout;
    }

    /**
     * Setter del layout
     * @param layout layout del teclado.
     */
    public void setLayout(char[][] layout) {
        this.layout = layout;
    }

    /**
     * Getter del id del alfabeto asociado al teclado
     * @return idAlfabeto;
     */
    public Integer getIdAlfabeto() {
        return idAlfabeto;
    }

    /**
     * Getter del id del texto asociado al teclado
     * @return idTexto;
     */
    public Integer getIdTexto() {
        return idTexto;
    }

    /**
     * Getter del id de la lista asociada al teclado
     * @return idLista;
     */
    public Integer getIdLista() {
        return idLista;
    }
}

