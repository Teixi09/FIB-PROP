package domain.classes;
/**
 * @author Alejandra Traveria
 */
public class Error {
    public enum typeError {
        TODOOK,
        ERRORPASWORD,
        ERRORFORMATOPASWORD,
        ERRORFORMATOUSERNAME,
        ERRORFORMATOMAIL,
        ERRORUSRUNREGISTERED,
        ERRORALREADYLOGGED,
        ERRORNOTLOGGED,
        ERRORUSRALREADYREGISTERED,
        ERRORNOMBRETECLADO,
        ERRORNOMBREALFABETO,
        ERRORNOMBRELISTA,
        ERRORNOMBRETEXTO,
        ERRORTECLADOEXISTS,
        ERRORTECLADONOEXISTS,
        ERRORALFABETOEXISTS,
        ERRORALFABETONOEXISTS,
        ERRORLISTAEXISTS,
        ERRORLISTANOEXISTS,
        ERRORTEXTOEXISTS,
        ERRORTEXTONOEXISTS,
        ERRORTECLADOSFULL,
        ERRORALFABETOSFULL,
        ERRORLISTASFULL,
        ERRORTEXTOSFULL,
        ERRORFORMATOTECLADO,
        ERRORFORMATOALFABETO,
        ERRORFORMATOLISTA,
        ERRORFORMATOTEXTO,
        ERRORLISTAEMPTY,
        ERRORTEXTOEMPTY,
        ERRORTECLADOEMPTY,
        ERRORALFABETOEMPTY,
        ERRORALFABETOYTEXTNOTCOMPATIBLE,
        ERRORALFABETOYLISTANOCOMPATIBLE,
        ERRORALFABETONOEDITABLE,
        ERRORTEXTONOEDITABLE,
        ERRORLISTANOEDITABLE,
        ERRORALFABETOTIENEASOCIACIONES,
        ERRORTEXTOTIENEASOCIACIONES,
        ERRORLISTATIENEASOCIACIONES,
        ERRORENESCRITURA,
        ERRORENLECTURA,
        ERRORFORMATOIMPORT,
        ERRORTIPOALGORITMO,
        UNKNOWNERROR;
    }
    /**
     * Constructora del error, dado un numero enuentra su error correspondiente
     */
    public Error() {
    }

    /**
     * Imprime el mensage de error asociado a un error en concreto
     */
    public static String printError(int i) {
        switch ( typeError.values()[i] ){
            case TODOOK:
                return "Realizado correctamente";
            case ERRORPASWORD:
                return "Pasword no coincide";
            case ERRORFORMATOPASWORD:
                return "El formato de la password no coincide con el establecido";
            case ERRORFORMATOUSERNAME:
                return "El formato del username no coincide con el establecido";
            case ERRORFORMATOMAIL:
                return "El formato del mail no coincide con el establecido";
            case ERRORUSRUNREGISTERED:
                return "No existe un usuario registrado con este username";
            case ERRORALREADYLOGGED:
                return "No se ha cerrado sesion";
            case ERRORNOTLOGGED:
                return "No se ha iniciado sesion";
            case ERRORUSRALREADYREGISTERED:
                return "Ya existe un usuario con este username";
            case ERRORNOMBRETECLADO:
                return "El nombre del teclado no cumple con el formato establecido";
            case ERRORNOMBREALFABETO:
                return "El nombre del alfabeto no cumple con el formato establecido";
            case ERRORNOMBRELISTA:
                return "El nombre de la lista no cumple con el formato establecido";
            case ERRORNOMBRETEXTO:
                return "El nombre del texto no cumple con el formato establecido";
            case ERRORTECLADOEXISTS:
                return "Ya existe un teclado con este nombre";
            case ERRORTECLADONOEXISTS:
                return "Este teclado no existe";
            case ERRORALFABETOEXISTS:
                return "Ya existe un alfabeto con este nombre";
            case ERRORALFABETONOEXISTS:
                return "Este alfabeto no existe";
            case ERRORLISTAEXISTS:
                return "Ya existe una lista con este nombre";
            case ERRORLISTANOEXISTS:
                return "Esta lista no existe";
            case ERRORTEXTOEXISTS:
                return "Ya existe un texto con este nombre";
            case ERRORTEXTONOEXISTS:
                return "Este texto no existe";
            case ERRORTECLADOSFULL:
                return "Has llegado al limite de teclados";
            case ERRORALFABETOSFULL:
                return "Has llegado al limite de alfabetos";
            case ERRORLISTASFULL:
                return "Has llegado al limite de listas";
            case ERRORTEXTOSFULL:
                return "Has llegado al limite de textos";
            case ERRORFORMATOTECLADO:
                return "El formato del teclado no coincide con el especificado";
            case ERRORFORMATOALFABETO:
                return "El formato del alfabeto no coincide con el especificado";
            case ERRORFORMATOLISTA:
                return "El formato de la lista no coincide con el especificado";
            case ERRORFORMATOTEXTO:
                return "El formato del texto no coincide con el especificado";
            case ERRORLISTAEMPTY:
                return "No posees listas";
            case ERRORTEXTOEMPTY:
                return "No posees textos";
            case ERRORTECLADOEMPTY:
                return "No posees teclados";
            case ERRORALFABETOEMPTY:
                return "No posees alfabetos";
            case ERRORALFABETOYTEXTNOTCOMPATIBLE:
                return "Alfabeto y texto no compatibles";
            case ERRORALFABETOYLISTANOCOMPATIBLE:
                return "Alfabeto y lista de palabras no compatible";
            case ERRORTEXTONOEDITABLE:
                return "Texto no editable";
            case ERRORALFABETONOEDITABLE:
                return "Alfabeto no editable";
            case ERRORLISTANOEDITABLE:
                return "Lista de palabras no editable";
            case ERRORTEXTOTIENEASOCIACIONES:
                return "Texto contiene asociaciones y no puede ser eliminado";
            case ERRORALFABETOTIENEASOCIACIONES:
                return "Alfabeto contiene asociaciones y no puede ser eliminado";
            case ERRORLISTATIENEASOCIACIONES:
                return "Lista contiene asociaciones y no puede ser eliminada";
            case ERRORENESCRITURA:
                return "Ha habido un error al intentar guardar el archvio";
            case ERRORENLECTURA:
                return "Ha habido un error al intentar leer el archvio";
            case ERRORFORMATOIMPORT:
                return "El archivo importado no cumple con el formato requerido";
            case ERRORTIPOALGORITMO:
                return "El algoritmo no existe, debe ser 0 o 1";
            case UNKNOWNERROR:
                return "Ha pasado algo inesperado";
        }
        return "Ha pasado algo inesperado";  
    }
}
