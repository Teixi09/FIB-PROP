package domain.controlador;

import domain.algoritmo.ALG2;
import domain.algoritmo.Algoritmo;
import domain.classes.Usuario;
import persistence.controladorPersistencia;
import domain.classes.Utilidad;
import domain.algoritmo.QAP;
import domain.classes.Error;

import java.io.IOException;
import java.util.*;

public class ControladorDominio {
    // ==========================================================
    //           ATRIBUTOS
    // ==========================================================
    static int status;

    static private Usuario usuario;
    static private Controlador1 controlador;
    static private HashMap<String, Integer> usernameId; //guarda la asociacion del username con su id
    static private Utilidad util;
    static private controladorPersistencia persis;

    static Integer idUser;
    static Integer idTeclado;
    static Integer idTexto;
    static Integer idLista;
    static Integer idAlfabeto;
    static Boolean activo;
    static private Integer idActivo;

    // ==========================================================
    //           CONSTRUCTOR
    // ==========================================================

    /**
     * Carga en el programa todos los usernames con sus ids
     *
     */
    public ControladorDominio() {
        // Creamos una instancia de las clases asociadas
        controlador = new Controlador1();
        util = new Utilidad();
        usernameId = new HashMap<>();
        try{persis = new controladorPersistencia();}
        catch(IOException e) { status = -Error.typeError.ERRORFORMATOUSERNAME.ordinal();}
        // Inicializamos los indicies por si no existe el archivo de metadatos
        idUser=-1;
        idTeclado=-1;
        idTexto=-1;
        idLista=-1;
        idAlfabeto=-1;
        idActivo=-1;
        activo=false;
        // Llamamos a persistencia para tener seguimiento de los indicies y usuario totales
        cargarReferencias();
        cargarIndices();
        status = -Error.typeError.TODOOK.ordinal();
    }

    // ==========================================================
    //           FUNCIONES
    // ==========================================================

    /**
     * Devuelve estado de la creacion de la clase.
     *
     */
    public int checkCreation() {
        return status;
    }

    /**
     * Carga en el programa todos los usernames con sus ids
     *
     */
    private void cargarReferencias() {
        ArrayList<ArrayList<String>> referencias = persis.getListaUsuarios();
        for (ArrayList<String> par : referencias) {
            usernameId.put(par.get(0), Integer.parseInt(par.get(1)));
        }
    }

    /**
     * Carga en el programa los índices para usar como identificadores
     *
     */
    private void cargarIndices() {
        ArrayList<Integer> referencias = persis.getIndices();
        idUser = referencias.get(0);
        idTeclado = referencias.get(1);
        idAlfabeto = referencias.get(2);
        idTexto = referencias.get(3);
        idLista = referencias.get(4);
    }

    /**
     * Carga un usuario en el sistema.
     * @param username nombre del usuario.
     * @param password contraseña del usuario.
     */
    public int loginUsuario(String username, String password)  {
        //Realizamos control de errores.
        if (!util.comprobarPasswordONombre(username)) return -Error.typeError.ERRORFORMATOUSERNAME.ordinal();
        else if (!util.comprobarPasswordONombre(password)) return -Error.typeError.ERRORFORMATOPASWORD.ordinal();
        else if (!usernameId.containsKey(username)) return -Error.typeError.ERRORUSRUNREGISTERED.ordinal();

        int id = usernameId.get(username);
        try{persis.cargarUsuario(id);}
        catch(IOException e) {return -Error.typeError.ERRORENESCRITURA.ordinal();}

        ArrayList<String> infoUsuario = persis.getInfoUsuario();
        String realPassword = infoUsuario.get(2);
        // Comprobamos que la contraseña que puesto coincida con la real
        if (!realPassword.equals(password)) return -Error.typeError.ERRORPASWORD.ordinal();

        String mail = infoUsuario.get(3);
        idActivo = id;
        usuario = new Usuario(username, password, mail);
        activo = true;

        // Cargamos todos los ids de los elementos para agregarselos al usuario
        ArrayList<ArrayList<String>> idsTeclados = persis.getIdElemento("idTeclados");
        for (ArrayList<String> e : idsTeclados)
            usuario.addTeclado( Integer.parseInt(e.get(1)), e.get(0) );

        ArrayList<ArrayList<String>> idsAlfabetos = persis.getIdElemento("idAlfabetos");
        for (ArrayList<String> e : idsAlfabetos)
            usuario.addAlfabeto( Integer.parseInt(e.get(1)), e.get(0) );

        ArrayList<ArrayList<String>> idsTextos = persis.getIdElemento("idTextos");
        for (ArrayList<String> e : idsTextos)
            usuario.addTexto( Integer.parseInt(e.get(1)), e.get(0) );

        ArrayList<ArrayList<String>> idsListas= persis.getIdElemento("idListas");
        for (ArrayList<String> e : idsListas)
            usuario.addListaPalabras( Integer.parseInt(e.get(1)), e.get(0) );

        ArrayList<ArrayList<String>> alfabetos = persis.getElemento("alfabetos");
        for (ArrayList<String> e : alfabetos)
            cargarElemento(e, "alfabeto");

        ArrayList<ArrayList<String>> textos = persis.getElemento("textos");
        for (ArrayList<String> e : textos)
            cargarElemento(e, "texto");

        ArrayList<ArrayList<String>> listas = persis.getElemento("listas");
        ArrayList<HashMap<String,Integer>> palabras = new ArrayList<>();
        try{palabras = persis.getLista();}
        catch (Exception e) { return  -Error.typeError.UNKNOWNERROR.ordinal();};
        int indice=0;
        for (ArrayList<String> e : listas) {
            cargarLista(e, palabras.get(indice));
            ++indice;
        }

        ArrayList<ArrayList<String>> teclados = persis.getTeclados();
        for (ArrayList<String> e : teclados)
            cargarTeclado(e);

        // Carga info teclado y eso
        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Registra un nuevo usuario en el sistema.
     * @param username nombre del usuario.
     * @param password contraseña del usuario.
     * @param mail correo del usuario.
     */
    public int registroUsuario(String username, String password, String mail) {
        //Realizamos control de errores.
        if (activo) return -Error.typeError.ERRORALREADYLOGGED.ordinal();
        else if (!util.comprobarPasswordONombre(username)) return -Error.typeError.ERRORFORMATOUSERNAME.ordinal();
        else if (!util.comprobarPasswordONombre(password)) return -Error.typeError.ERRORFORMATOPASWORD.ordinal();
        else if (!util.comprobarCorreo(mail)) return -Error.typeError.ERRORFORMATOMAIL.ordinal();
        else if (usernameId.containsKey(username)) return -Error.typeError.ERRORUSRALREADYREGISTERED.ordinal();

        ++idUser;
        idActivo = idUser;
        activo=true;
        usernameId.put(username, idActivo);
        usuario = new Usuario(username, password, mail);
        try{persis.cargarUsuario(idUser);}
        catch(IOException e) {return -Error.typeError.ERRORENESCRITURA.ordinal();}

        try{persis.addUsuario(new ArrayList<>(Arrays.asList(idUser.toString(), username, password, mail)));}
        catch(IOException e) {return -Error.typeError.ERRORENESCRITURA.ordinal();}

        try{persis.updateIndices(new ArrayList<>(Arrays.asList(idUser, idTeclado, idAlfabeto, idTexto, idLista)));}
        catch(IOException e){return -Error.typeError.ERRORENESCRITURA.ordinal();}

        try{persis.updateUsuarios(new ArrayList<>(Arrays.asList(username,idUser.toString())));}
        catch (IOException e) {return -Error.typeError.ERRORENESCRITURA.ordinal();}

        return Error.typeError.TODOOK.ordinal();
    }

    public int logoutUsuario() {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();

        int status = actualizarUsuario();
        if (status < 0) return status;

        ArrayList<Integer> teclados = usuario.getTeclados();
        ArrayList<Integer> alfabetos = usuario.getAlfabetos();
        ArrayList<Integer> textos = usuario.getTextos();
        ArrayList<Integer> listas = usuario.getListasPalabras();

        for (Integer id : teclados)
            controlador.eliminarTeclado(id);

        for (Integer id : alfabetos)
            controlador.eliminarAlfabeto(id);

        for (Integer id : textos)
            controlador.eliminarTexto(id);

        for (Integer id : listas)
            controlador.eliminarListaDePalabras(id);

        activo=false;
        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Crea un teclado a partir de un alfabeto y una lista de palabras con frecuencias.
     * @param nombre nombre del teclado.
     * @param nombreAlfabeto nombre del alfabeto.
     * @param nombreLista nombre de la lista.
     * @return si ok typeR
     *
     */
    public int crearTecladoConLista(String nombre, int tipo, String nombreAlfabeto, String nombreLista) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORALREADYLOGGED.ordinal();
        else if(!util.comprobarPasswordONombre(nombre)) return -Error.typeError.ERRORNOMBRETECLADO.ordinal();
        else if(!(util.comprobarPasswordONombre(nombreAlfabeto))) return -Error.typeError.ERRORNOMBREALFABETO.ordinal();
        else if(!(util.comprobarPasswordONombre(nombreLista))) return -Error.typeError.ERRORNOMBRELISTA.ordinal();
        else if (usuario.checkTeclado(nombre)) return -Error.typeError.ERRORTECLADOEXISTS.ordinal();
        else if (!usuario.checkAlfabeto(nombreAlfabeto)) return -Error.typeError.ERRORALFABETONOEXISTS.ordinal();
        else if (!usuario.checkLista(nombreLista)) return -Error.typeError.ERRORLISTANOEXISTS.ordinal();
        else if (!usuario.checkSizeTeclados()) return -Error.typeError.ERRORTECLADOSFULL.ordinal();
        else if (!(tipo == 0 || tipo == 1)) return -Error.typeError.ERRORTIPOALGORITMO.ordinal();

        //creamos el layout con el algoritmo y lo añadimos al sistema.
        Integer idAlf = usuario.getIdAlfabeto(nombreAlfabeto);
        Integer idL = usuario.getIdLista(nombreLista);
        String alfabeto = controlador.getAlfabeto(idAlf);
        HashMap<String, Integer> lista = controlador.getListaPalabras(idL);
        //comprobamos que el alfabeto y la lista de palabras sean compatibles.
        if (!util.comprobarCompatibilidadListaAlfabeto(alfabeto, lista)) return -Error.typeError.ERRORALFABETOYLISTANOCOMPATIBLE.ordinal();

        Algoritmo algoritmoQap;
        if (tipo == 0) algoritmoQap = new QAP(controlador.getAlfabeto(idAlf), controlador.getListaPalabras(idL));
        else algoritmoQap = new ALG2(controlador.getAlfabeto(idAlf), controlador.getListaPalabras(idL));

        //le asignamos un id al teclado.
        idTeclado += 1;

        usuario.addTeclado(idTeclado, nombre);
        controlador.crearTeclado(idTeclado, idAlf, -1, idL, algoritmoQap.getLayout());

        // Cambios que se deberian producirse en persistencia llamando a otro thread, se retocara para
        // la entrega de persistencia
        try{persis.updateIndices(new ArrayList<>(Arrays.asList(idUser, idTeclado, idAlfabeto, idTexto, idLista)));}
        catch (IOException e) {return -Error.typeError.ERRORENESCRITURA.ordinal();}
        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Crea un teclado a partir de un alfabeto y un texto
     * @param nombre nombre del teclado.
     * @param nombreAlfabeto nombre del alfabeto.
     * @param nombreTexto nombre del texto.
     */
    public int crearTecladoConTexto(String nombre, int tipo, String nombreAlfabeto, String nombreTexto) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();
        if (!(util.comprobarPasswordONombre(nombre))) return -Error.typeError.ERRORNOMBRETECLADO.ordinal();
        else if(!(util.comprobarPasswordONombre(nombreAlfabeto))) return -Error.typeError.ERRORNOMBREALFABETO.ordinal();
        else if (!(util.comprobarPasswordONombre(nombreTexto)))  return -Error.typeError.ERRORNOMBRETEXTO.ordinal();
        else if (usuario.checkTeclado(nombre)) return -Error.typeError.ERRORTECLADOEXISTS.ordinal();
        else if (!usuario.checkSizeTeclados()) return -Error.typeError.ERRORTECLADOSFULL.ordinal();
        else if (!usuario.checkAlfabeto(nombreAlfabeto)) return -Error.typeError.ERRORALFABETONOEXISTS.ordinal();
        else if (!usuario.checkTexto(nombreTexto)) return -Error.typeError.ERRORTEXTONOEXISTS.ordinal();
        else if (!(tipo == 0 || tipo == 1)) return -Error.typeError.ERRORTIPOALGORITMO.ordinal();

        //creamos el layout con el algoritmo y lo añadimos al sistema.
        Integer idAlf = usuario.getIdAlfabeto(nombreAlfabeto);
        Integer idTxt = usuario.getIdTexto(nombreTexto);
        String alfabeto = controlador.getAlfabeto(idAlf);
        String texto = controlador.getTexto(idTxt).replaceAll("\\p{C}", "");
        // comprobamos que el texto y el alfabeto sean compatibles.
        if (!util.comprobarCompatibilidadTextoAlfabeto(alfabeto, texto)) return -Error.typeError.ERRORALFABETOYTEXTNOTCOMPATIBLE.ordinal();

        //le asignamos un id al teclado.
        idTeclado += 1;

        //convertimos el texto a una lista de palabras con freqüencias.
        HashMap<String, Integer> lista = util.conversorTextoLista(texto);
        Algoritmo algoritmoQap;
        if (tipo == 0) algoritmoQap = new QAP(alfabeto, lista);
        else algoritmoQap = new ALG2(alfabeto, lista);

        usuario.addTeclado(idTeclado, nombre);
        controlador.crearTeclado(idTeclado, idAlf, idTxt, -1, algoritmoQap.getLayout());
        // Cambios que se producen en persistencia.

        try{persis.updateIndices(new ArrayList<>(Arrays.asList(idUser, idTeclado, idAlfabeto, idTexto, idLista)));}
        catch (IOException e) {return -Error.typeError.ERRORENESCRITURA.ordinal();}
        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Crea un texto y lo añade al sistema.
     * @param nombre nombre asignado al texto.
     * @param texto texto a añadir.
     */
    public int crearTexto(String nombre, String texto) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();
        else if (!usuario.checkSizeTextos()) return -Error.typeError.ERRORTEXTOSFULL.ordinal();
        else if (!util.comprobarTexto(texto)) return -Error.typeError.ERRORFORMATOTEXTO.ordinal();
        else if (!util.comprobarPasswordONombre(nombre)) return -Error.typeError.ERRORNOMBRETEXTO.ordinal();
        else if (usuario.checkTexto(nombre)) return -Error.typeError.ERRORTEXTOEXISTS.ordinal();
        //Después de todas las comprobaciones le asignamos un id al texto.
        idTexto += 1;
        //Añadimos el texto al usuario y se lo pasamos al controlador para que lo añada.
        usuario.addTexto(idTexto, nombre);
        controlador.crearTexto(idTexto, texto);
        // Cambios que se producen en persistencia.
        try{persis.updateIndices(new ArrayList<>(Arrays.asList(idUser, idTeclado, idAlfabeto, idTexto, idLista)));}
        catch (IOException e) {return -Error.typeError.ERRORENESCRITURA.ordinal();}
        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Crea un alfabeto y lo añade al sistema.
     * @param nombre nombre del alfabeto.
     * @param alfabeto alfabeto a añadir.
     */
    public int crearAlfabeto(String nombre, String alfabeto) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();
        else if (!usuario.checkSizeAlfabetos()) return -Error.typeError.ERRORALFABETOSFULL.ordinal();
        else if (!util.comprobarAlfabeto(alfabeto)) return -Error.typeError.ERRORFORMATOALFABETO.ordinal();
        else if (!util.comprobarPasswordONombre(nombre)) return -Error.typeError.ERRORNOMBREALFABETO.ordinal();
        else if (usuario.checkAlfabeto(nombre)) return -Error.typeError.ERRORALFABETOEXISTS.ordinal();
        //Despues de todas las comprobaciones le asignamos un id al alfabeto.
        idAlfabeto += 1;
        //Añadimos el alfabeto al usuario y se lo pasamos al controlador para que lo añada
        usuario.addAlfabeto(idAlfabeto, nombre);
        controlador.crearAlfabeto(idAlfabeto, alfabeto);
        // Cambios que se producen en persistencia.
        try{persis.updateIndices(new ArrayList<>(Arrays.asList(idUser, idTeclado, idAlfabeto, idTexto, idLista)));}
        catch (IOException e) {return -Error.typeError.ERRORENESCRITURA.ordinal();}
        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Crea una lista de palabras y la añade al sistema.
     * @param nombre nombre de la lista de palabras.
     * @param listaPalabras lista de palabras a añadir.
     */
    public int crearListaDePalabras(String nombre, HashMap<String, Integer> listaPalabras) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();
        else if (!usuario.checkSizeListas()) return -Error.typeError.ERRORLISTASFULL.ordinal();
        else if (!(util.comprobarListaPalabras(listaPalabras))) return -Error.typeError.ERRORFORMATOLISTA.ordinal();
        else if (!(util.comprobarPasswordONombre(nombre)))  return -Error.typeError.ERRORNOMBRELISTA.ordinal();
        else if (usuario.checkLista(nombre)) return -Error.typeError.ERRORLISTAEXISTS.ordinal();

        //Después de todas las comprobaciones le asignamos un id a la lista de palabras.
        idLista += 1;
        //Añadimos la lista de palabras al usuario y se la pasamos al controlador para que la añada
        usuario.addListaPalabras(idLista, nombre);
        controlador.crearListaDePalabras(idLista, listaPalabras);

        // Cambios que se producen en persistencia.
        try{persis.updateIndices(new ArrayList<>(Arrays.asList(idUser, idTeclado, idAlfabeto, idTexto, idLista)));}
        catch (IOException e) {return -Error.typeError.ERRORENESCRITURA.ordinal();}
        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Elimina el usuario activo del sistema.
     * @param password contraseña del usuario.
     */
    public int eliminarUsuario(String password) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();
        else if (!util.comprobarPasswordONombre(password)) return -Error.typeError.ERRORFORMATOPASWORD.ordinal();
        else if (!usuario.getPasword().equals(password)) return -Error.typeError.ERRORPASWORD.ordinal();

        ArrayList<Integer> teclados = usuario.getTeclados();
        ArrayList<Integer> alfabetos = usuario.getAlfabetos();
        ArrayList<Integer> textos = usuario.getTextos();
        ArrayList<Integer> listas = usuario.getListasPalabras();
        String username = usuario.getUsername();

        for (Integer id : teclados)
            controlador.eliminarTeclado(id);

        for (Integer id : alfabetos)
            controlador.eliminarAlfabeto(id);

        for (Integer id : textos)
            controlador.eliminarTexto(id);

        for (Integer id : listas)
            controlador.eliminarListaDePalabras(id);

        activo=false;
        usernameId.remove(username);

        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Elimina un texto del sistema.
     * @param nombre nombre del texto a eliminar.
     */
    public int eliminarTexto(String nombre) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();
        else if (!(util.comprobarPasswordONombre(nombre))) return -Error.typeError.ERRORNOMBRETEXTO.ordinal();
        else if (!(usuario.checkTexto(nombre))) return -Error.typeError.ERRORTEXTONOEXISTS.ordinal();

        int idTxt = usuario.getIdTexto(nombre);
        //le decimos al controlador que elimine el texto.
        if (!controlador.eliminarTexto(idTxt)) return -Error.typeError.ERRORTEXTOTIENEASOCIACIONES.ordinal();
        //eliminamos el texto del usuario.
        usuario.deleteTexto(nombre);

        return Error.typeError.TODOOK.ordinal();
    }


    /**
     * Elimina un alfabeto del sistema.
     * @param nombre nombre del alfabeto a eliminar.
     */
    public int eliminarAlfabeto(String nombre) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();
        else if (!(util.comprobarPasswordONombre(nombre))) return -Error.typeError.ERRORNOMBREALFABETO.ordinal();
        else if (!(usuario.checkAlfabeto(nombre)))  return -Error.typeError.ERRORALFABETOEXISTS.ordinal();

        int idAlf = usuario.getIdAlfabeto(nombre);
        //le decimos al controlador que elimine el alfabeto
        if (!controlador.eliminarAlfabeto(idAlf)) return -Error.typeError.ERRORALFABETOTIENEASOCIACIONES.ordinal();
        //eliminamos el alfabeto del usuario
        usuario.deleteAlfabeto(nombre);

        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Elimina una lista de palabras del sistema.
     * @param nombre nombre de la lista a eliminar.
     */
    public int eliminarListaDePalabras(String nombre) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();
        else if (!(util.comprobarPasswordONombre(nombre))) return -Error.typeError.ERRORNOMBRELISTA.ordinal();
        else if(!(usuario.checkLista(nombre))) return -Error.typeError.ERRORLISTANOEXISTS.ordinal();

        int idL = usuario.getIdLista(nombre);
        //le decimos al controlador que elimine la lista de palabras
        if (!controlador.eliminarListaDePalabras(idL)) return -Error.typeError.ERRORLISTATIENEASOCIACIONES.ordinal();
        //eliminamos la lista de palabras del usuario
        usuario.deleteListaPalabras(nombre);

        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Elimina un teclado del sistema.
     * @param nombre nombre del teclado a eliminar.
     */
    public int eliminarTeclado(String nombre) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();
        else if (!util.comprobarPasswordONombre(nombre)) return -Error.typeError.ERRORNOMBRETECLADO.ordinal();
        else if (!usuario.checkTeclado(nombre)) return -Error.typeError.ERRORTECLADONOEXISTS.ordinal();

        int idTec = usuario.getIdTeclado(nombre);

        //le decimos al controlador que elimine el teclado
        controlador.eliminarTeclado(idTec);
        //eliminamos el teclado del usuario
        usuario.deleteTeclado(nombre);

        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Edita un texto del sistema.
     *
     * @param nombre nombre del texto a editar.
     * @param nuevoTexto el contenido del nuevo texto.
     */
    public int editarTexto(String nombre, String nuevoTexto) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();
        else if (!(util.comprobarPasswordONombre(nombre))) return -Error.typeError.ERRORNOMBRETEXTO.ordinal();
        else if (!util.comprobarTexto(nuevoTexto)) return -Error.typeError.ERRORFORMATOTEXTO.ordinal();
        else if (!(usuario.checkTexto(nombre))) return -Error.typeError.ERRORTEXTONOEXISTS.ordinal();

        if (!controlador.editarTexto(usuario.getIdTexto(nombre), nuevoTexto)) return -Error.typeError.ERRORTEXTONOEDITABLE.ordinal();

        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Edita un alfabeto del sistema.
     *
     * @param nombre nombre del alfabeto a editar.
     * @param nuevoAlfabeto el contenido del nuevo alfabeto.
     */
    public int editarAlfabeto(String nombre, String nuevoAlfabeto) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();
        else if (!(util.comprobarPasswordONombre(nombre))) return -Error.typeError.ERRORNOMBREALFABETO.ordinal();
        else if (!util.comprobarAlfabeto(nuevoAlfabeto)) return -Error.typeError.ERRORFORMATOALFABETO.ordinal();
        else if (!(usuario.checkAlfabeto(nombre))) return -Error.typeError.ERRORALFABETONOEXISTS.ordinal();

        if (!controlador.editarAlfabeto(usuario.getIdAlfabeto(nombre), nuevoAlfabeto)) return -Error.typeError.ERRORALFABETONOEDITABLE.ordinal();

        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Edita una lista del sistema.
     *
     * @param nombre nombre de la lista editar.
     * @param nuevaLista el contenido de la nueva lista.
     */
    public int editarLista(String nombre, HashMap<String,Integer> nuevaLista) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();
        else if (!(util.comprobarPasswordONombre(nombre))) return -Error.typeError.ERRORNOMBRELISTA.ordinal();
        else if (!util.comprobarListaPalabras(nuevaLista)) return -Error.typeError.ERRORFORMATOLISTA.ordinal();
        else if (!(usuario.checkLista(nombre))) return -Error.typeError.ERRORLISTANOEXISTS.ordinal();

        if (!controlador.editarListaPalabras(usuario.getIdLista(nombre), nuevaLista)) return -Error.typeError.ERRORLISTANOEDITABLE.ordinal();

        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Edita el nombre de un teclado.
     * @param nombre nombre del teclado a editar
     * @param nuevoNombre nuevo nombre del teclado.
     */
    public int editarNombreTeclado(String nombre, String nuevoNombre) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();
        else if (!(util.comprobarPasswordONombre(nombre))) return -Error.typeError.ERRORNOMBRETECLADO.ordinal();
        else if (!util.comprobarPasswordONombre(nuevoNombre)) return -Error.typeError.ERRORNOMBRETECLADO.ordinal();
        else if (!(usuario.checkTeclado(nombre))) return -Error.typeError.ERRORTECLADONOEXISTS.ordinal();
        else if (usuario.checkTeclado(nuevoNombre)) return -Error.typeError.ERRORTECLADOEXISTS.ordinal();

        usuario.editarTeclado(nombre, nuevoNombre);

        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Edita el nombre de un texto.
     * @param nombre nombre del texto a editar
     * @param nuevoNombre nuevo nombre del texto.
     */
    public int editarNombreTexto(String nombre, String nuevoNombre) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();
        else if (!(util.comprobarPasswordONombre(nombre))) return -Error.typeError.ERRORNOMBRETEXTO.ordinal();
        else if (!util.comprobarPasswordONombre(nuevoNombre)) return -Error.typeError.ERRORNOMBRETEXTO.ordinal();
        else if (!(usuario.checkTexto(nombre))) return -Error.typeError.ERRORTEXTONOEXISTS.ordinal();

        usuario.editarTexto(nombre, nuevoNombre);

        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Edita el nombre de un alfabeto.
     * @param nombre nombre del alfabeto a editar
     * @param nuevoNombre nuevo nombre del alfabeto.
     */
    public int editarNombreAlfabeto(String nombre, String nuevoNombre) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();
        else if (!(util.comprobarPasswordONombre(nombre))) return -Error.typeError.ERRORNOMBREALFABETO.ordinal();
        else if (!util.comprobarPasswordONombre(nuevoNombre)) return -Error.typeError.ERRORNOMBREALFABETO.ordinal();
        else if (!(usuario.checkAlfabeto(nombre))) return -Error.typeError.ERRORALFABETONOEXISTS.ordinal();
        else if (usuario.checkAlfabeto(nuevoNombre)) return -Error.typeError.ERRORALFABETOEXISTS.ordinal();

        usuario.editarAlfabeto(nombre, nuevoNombre);

        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Edita el nombre de una lista.
     * @param nombre nombre de la lista a editar
     * @param nuevoNombre nuevo nombre de la lista.
     */
    public int editarNombreLista(String nombre, String nuevoNombre) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();
        else if (!(util.comprobarPasswordONombre(nombre))) return -Error.typeError.ERRORNOMBRELISTA.ordinal();
        else if (!util.comprobarPasswordONombre(nuevoNombre)) return -Error.typeError.ERRORNOMBRELISTA.ordinal();
        else if (!(usuario.checkLista(nombre))) return -Error.typeError.ERRORLISTANOEXISTS.ordinal();
        else if (usuario.checkLista(nuevoNombre)) return -Error.typeError.ERRORLISTAEXISTS.ordinal();

        usuario.editarLista(nombre, nuevoNombre);

        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Devuelve un texto del sistema.
     *
     * @param nombre nombre del texto que devolverá.
     * @param texto donde se almacenara el texto.
     */
    public int verTexto(String nombre, StringBuilder texto) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();
        else if (!util.comprobarPasswordONombre(nombre)) return -Error.typeError.ERRORNOMBRETEXTO.ordinal();
        else if (!usuario.checkTexto(nombre)) return -Error.typeError.ERRORTEXTONOEXISTS.ordinal();

        texto.append(controlador.getTexto(usuario.getIdTexto(nombre)));
        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Devuelve un alfabeto del sistema.
     *
     * @param nombre nombre del alfabeto que devolverá.
     * @param texto donde se almacenara el alfabeto.
     */
    public int verAlfabeto(String nombre, StringBuilder texto) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();
        else if (!util.comprobarPasswordONombre(nombre)) return -Error.typeError.ERRORNOMBREALFABETO.ordinal();
        else if (!usuario.checkAlfabeto(nombre)) return -Error.typeError.ERRORALFABETONOEXISTS.ordinal();

        texto.append(controlador.getAlfabeto(usuario.getIdAlfabeto(nombre)));
        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Devuelve una lista de palabras con frecuencia del sistema.
     * @param nombre nombre de la lista de palabras con frecuencia que devolverá.
     * @param lista donde se almacenara la lista de palabras con frecuencia.
     */
    public int verLista(String nombre, HashMap<String,Integer> lista) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();
        else if (!util.comprobarPasswordONombre(nombre)) return -Error.typeError.ERRORNOMBRELISTA.ordinal();
        else if (!usuario.checkLista(nombre)) return -Error.typeError.ERRORLISTANOEXISTS.ordinal();

        lista.putAll(controlador.getListaPalabras(usuario.getIdLista(nombre)));
        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Devuelve una matriz de caracteres que representa un teclado del sistema.
     * @param nombre nombre de la lista de palabras con frecuencia que devolverá.
     * @param teclado donde se almacenara la distribucion del teclado.
     */
    public int verTeclado(String nombre, ArrayList<ArrayList<Character>> teclado) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();
        else if (!util.comprobarPasswordONombre(nombre)) return -Error.typeError.ERRORNOMBRETECLADO.ordinal();
        else if (!usuario.checkTeclado(nombre)) return -Error.typeError.ERRORTECLADONOEXISTS.ordinal();

        char[][] aux = controlador.getTeclado(usuario.getIdTeclado(nombre));

        for (char[] fila : aux) {
            ArrayList<Character> nuevaFila = new ArrayList<>();
            for (char elemento : fila) {
                nuevaFila.add(elemento);
            }
            teclado.add(nuevaFila);
        }

        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Devuelve el nombre de todos los alfabetos que posee el usuario actual.
     * @param lista array en donde se almacenarán los nombres.
     */
    public int listarAlfabetos(ArrayList<String> lista) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();
        else if (usuario.emptyAlfabetos()) return -Error.typeError.ERRORALFABETOEMPTY.ordinal();

        lista.addAll(usuario.getNombreAlfabetos());
        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Devuelve el nombre de todos los textos que posee el usuario actual.
     * @param lista array en donde se almacenarán los nombres.
     */
    public int listarTextos(ArrayList<String> lista) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();
        else if (usuario.emptyTextos()) return -Error.typeError.ERRORTEXTOEMPTY.ordinal();

        lista.addAll(usuario.getNombreTextos());
        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Devuelve el nombre de todas las listas de palabras con frecuencia que posee el usuario actual.
     * @param lista array en donde se almacenarán los nombres.
     */
    public int listarListas(ArrayList<String> lista) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();
        else if (usuario.emptyListas()) return -Error.typeError.ERRORLISTAEMPTY.ordinal();

        lista.addAll(usuario.getNombreListas());
        return Error.typeError.TODOOK.ordinal();
    }


    /**
     * Devuelve el nombre de todos los teclados que posee el usuario actual.
     * @param lista array en donde se almacenarán los nombres.
     */
    public int listarTeclados(ArrayList<String> lista) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();
        else if (usuario.emptyTeclados()) return -Error.typeError.ERRORTECLADOEMPTY.ordinal();

        lista.addAll(usuario.getNombreTeclados());
        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Importa un texto y se lo agrega al usuario.
     * @param path ubicación en el sistema donde se encuentra el texto.
     * @param nombre nombre que se le asignará el texto.
     */
    public int importarTexto (String path, String nombre) {
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();

        String texto = "";
        try {texto = persis.importarTexto(path);}
        catch (IOException e) { return -Error.typeError.ERRORENLECTURA.ordinal();}
        catch (Exception e) {return -Error.typeError.ERRORFORMATOIMPORT.ordinal();}

        return crearTexto(nombre, texto);
    }

    /**
     * Importa un alfabeto y se lo agrega al usuario.
     * @param path ubicación en el sistema donde se encuentra el alfabeto.
     * @param nombre nombre que se le asignará al alfabeto.
     */
    public int importarAlfabeto (String path, String nombre) {
        //Realizamos control de errores.s
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();

        String alfabeto = "";
        try{alfabeto = persis.importarAlfabeto(path);}
        catch (IOException e) { return -Error.typeError.ERRORENLECTURA.ordinal();}
        catch (Exception e) {return -Error.typeError.ERRORFORMATOIMPORT.ordinal();}

        return crearAlfabeto(nombre, alfabeto);
    }

    /**
     * Importa una lista de palabras con frecuencias y se la agrega al usuario.
     * @param path ubicación en el sistema donde se encuentra la lista de palabras con frecuencias.
     * @param nombre nombre que se le asignará a la lista de palabras con frecuencia.
     */
    public int importarLista (String path, String nombre) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();

        HashMap<String, Integer> lista = new HashMap<>();
        try { lista = persis.importarLista(path);}
        catch (IOException e) { return -Error.typeError.ERRORENLECTURA.ordinal();}
        catch (Exception e) {return -Error.typeError.ERRORFORMATOIMPORT.ordinal();}

        return crearListaDePalabras(nombre, lista);
    }

    /**
     * Exporta un texto del sistema, generando un archivo, que contiene el texto.
     * @param path ubicación en el sistema donde se guardará el texto y su nombre.
     * @param nombre nombre del texto a exportar
     */
    public int exportarTexto(String path, String nombre) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();
        else if (!(util.comprobarPasswordONombre(nombre))) return -Error.typeError.ERRORNOMBRETECLADO.ordinal();
        else if (!(usuario.checkTexto(nombre))) return -Error.typeError.ERRORTEXTONOEXISTS.ordinal();

        String texto = controlador.getTexto(usuario.getIdTexto(nombre));

        try { persis.exportarTexto(path, nombre, texto);}
        catch (IOException e) {return -Error.typeError.ERRORENESCRITURA.ordinal();}
        catch (Exception e) {return -Error.typeError.UNKNOWNERROR.ordinal();}

        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Exporta un alfabeto del sistema, generando un archivo, que contiene el alfabeto.
     * @param path ubicación en el sistema donde se guardará el alfabeto y su nombre.
     * @param nombre nombre del alfabeto a exportar
     */
    public int exportarAlfabeto(String path, String nombre) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();
        else if (!(util.comprobarPasswordONombre(nombre))) return -Error.typeError.ERRORNOMBREALFABETO.ordinal();
        else if (!(usuario.checkAlfabeto(nombre))) return -Error.typeError.ERRORALFABETONOEXISTS.ordinal();

        String alfabeto = controlador.getAlfabeto(usuario.getIdAlfabeto(nombre));

        try { persis.exportarAlfabeto(path, nombre, alfabeto); }
        catch (IOException e) {return -Error.typeError.ERRORENESCRITURA.ordinal();}
        catch (Exception e) {return -Error.typeError.UNKNOWNERROR.ordinal();}

        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Exporta una lista de palabras con frecuencia del sistema, generando un archivo, que contiene la lista.
     * @param path ubicación en el sistema donde se guardará la lista y su nombre.
     * @param nombre nombre de la lista a exportar
     */
    public int exportarLista(String path, String nombre) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();
        else if (!(util.comprobarPasswordONombre(nombre))) return -Error.typeError.ERRORNOMBRELISTA.ordinal();
        else if (!(usuario.checkLista(nombre))) return -Error.typeError.ERRORLISTANOEXISTS.ordinal();

        HashMap<String, Integer> lista = controlador.getListaPalabras(usuario.getIdLista(nombre));
        try {persis.exportarLista(path, nombre, lista);}
        catch (IOException e) {return -Error.typeError.ERRORENESCRITURA.ordinal();}
        catch (Exception e) {return -Error.typeError.UNKNOWNERROR.ordinal();}

        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Exporta un teclado del sistema, generando un archivo, que contiene el teclado, su alfabeto y texto o lista.
     * @param path ubicación en el sistema donde se guardará el teclado y su nombre.
     * @param nombre nombre del teclado a exportar
     */
    public int exportarTeclado(String path, String nombre) {
        //Realizamos control de errores.
        if (!activo) return -Error.typeError.ERRORNOTLOGGED.ordinal();
        else if (!(util.comprobarPasswordONombre(nombre))) return -Error.typeError.ERRORNOMBRETECLADO.ordinal();
        else if (!(usuario.checkTeclado(nombre))) return -Error.typeError.ERRORTECLADONOEXISTS.ordinal();

        char[][] teclado = controlador.getTeclado(usuario.getIdTeclado(nombre));
        try{persis.exportarTeclado(path, nombre, teclado);}
        catch (IOException e) {return -Error.typeError.ERRORENESCRITURA.ordinal();}
        catch (Exception e) {return -Error.typeError.UNKNOWNERROR.ordinal();}

        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Dado un string se transforma en una matriz cuadrada
     * @param layout string que se transformará en en matriz
     * @return devuelve la matriz producto de transformar el string.
     */
    private char[][] toMatriz(String layout) {
        int size = layout.length();
        int c = (int) Math.sqrt(size);
        char[][] resultado = new char[c][c];
        for (int i = 0; i <  c; i++)
            for (int j = 0; j < c; j++)
                resultado[i][j] = layout.charAt(i*c+j);
        return  resultado;
    }

    /**
     * Dado una matriz esta se transforma en un string
     * @param matriz matriz que se transformará en un string
     * @return devuelve un string producto de transformar la matriz.
     */
    private String toString(char[][] matriz) {
        String resultado = "";
        for (char[] chars : matriz)
            for (int j = 0; j < matriz.length; j++)
                resultado += chars[j];
        return  resultado;
    }

    /**
     * Dado una lista de enteros esta se transforma en un string
     * @param list lista de enteros que se transformará en un string
     * @return devuelve un string producto de transformar la lista de enteros.
     */
    private String toString(ArrayList<Integer> list) {
        StringBuilder result= new StringBuilder();
        for (Integer num : list)
            result.append(num);
        return result.toString();
    }

    /**
     * Carga en sistema un teclado obtenido de persistencia
     * @param teclado lista de string que contiene la información pertinente a un teclado, en un formato predefinido
     *                anteriormente.
     */
    private void cargarTeclado(ArrayList<String> teclado) {
        int idTec = Integer.parseInt(teclado.get(0));
        int idAlf = Integer.parseInt(teclado.get(2));
        int idTex = Integer.parseInt(teclado.get(3));
        int idLis = Integer.parseInt(teclado.get(4));
        String layout = teclado.get(1);

        controlador.crearTeclado(idTec,idAlf,idTex,idLis, toMatriz(layout));
    }

    /**
     * Carga en sistema un elemento obtenido de persistencia
     * @param elemento lista de string que contiene la información pertinente a un elemento, en un formato predefinido
     *                anteriormente.
     * @param tipo String que identifica que tipo de elemento se desea cargar a sistema.
     */
    private void cargarElemento(ArrayList<String> elemento, String tipo) {
        int id = Integer.parseInt(elemento.get(0));
        String elem = elemento.get(1);
        String sids = elemento.get(2);
        ArrayList<Integer> ids = new ArrayList<>();

        for (int i = 0; i < sids.length(); i++)
            ids.add( Character.getNumericValue(sids.charAt(i)) ) ;

        if (tipo.equals("alfabeto")) {
            controlador.crearAlfabeto(id, elem);
            controlador.addTecladosAsociadosAlfabeto(id, ids);
        }
        else {
            controlador.crearTexto(id, elem);
            controlador.addTecladosAsociadosTexto(id, ids);
        }
    }

    /**
     * Carga en sistema una lista de palabras obtenido de persistencia
     * @param lista lista de string que contiene la información pertinente a una lista de palabras, en un formato predefinido
     *                anteriormente, esta no incluye el contenido de la lista de palabras.
     * @param palabras lista que contiene unicamente el contenido de la lista de palabras.
     */
    private void cargarLista(ArrayList<String> lista, HashMap<String, Integer> palabras) {
        int id = Integer.parseInt(lista.get(0));
        String sids = lista.get(1);
        ArrayList<Integer> ids = new ArrayList<>();

        for (int i = 0; i < sids.length(); i++)
            ids.add( Character.getNumericValue(sids.charAt(i)) ) ;

        controlador.crearListaDePalabras(id, palabras);
        controlador.addTecladosAsociadosLista(id, ids);
    }


    /**
     * Funcion que se encarga de actulizar toda la información relacionada con el usuario activo en persistnecia.
     * Esta información incluye tanto el usuario en sí, como los elementos que contiene.
     */
    private int actualizarUsuario() {

        // Serializamos la informacion referente al usuario
        ArrayList<String> infoUsuario = getInfoUsuario();

        //Empezamos obteniendo la serializacion de los identificadores de los elementos
        ArrayList<ArrayList<String>> tecladosId = getIds("teclado");
        ArrayList<ArrayList<String>> alfabetosId = getIds("alfabeto");
        ArrayList<ArrayList<String>> textosId = getIds("texto");
        ArrayList<ArrayList<String>> listasId = getIds("lista");
        //Terminamos de obtener la serializacion de los identificadores de los elementos

        //Empezamos serializando los elementos

        //Creamos una
        ArrayList<ArrayList<String>> teclados = getElemento(tecladosId, "teclado");
        ArrayList<ArrayList<String>> alfabetos = getElemento(alfabetosId, "alfabeto");
        ArrayList<ArrayList<String>> textos = getElemento(textosId, "texto");
        ArrayList<ArrayList<String>> listas = getElemento(listasId, "lista");
        ArrayList<HashMap<String, Integer>> palabras = getPalabras(listasId);

        //Terminamos de serializar los elementos
        //Enviamos toda la informacion serializada a persistencia

        persis.putInfoUsuario(infoUsuario);
        persis.putIdElemento(tecladosId, "idTeclados");
        persis.putIdElemento(alfabetosId, "idAlfabetos");
        persis.putIdElemento(textosId, "idTextos");
        persis.putIdElemento(listasId, "idListas");
        persis.putTeclado(teclados);
        persis.putElemento(alfabetos,"alfabetos");
        persis.putElemento(textos,"textos");
        persis.putElemento(listas,"listas");
        persis.putLista(palabras);
        try{persis.guardarUsuario();}
        catch(IOException e) {return -Error.typeError.ERRORENESCRITURA.ordinal();}
        return -Error.typeError.TODOOK.ordinal();
    }


    /**
     * Funcion que se encarga de obtener una lista con parte de la información del usuario en memoria.
     * @return lista que contiene la información del usuario: id, username, password y mail. En ese mismo orden.
     */
    public ArrayList<String> getInfoUsuario() {
        return new ArrayList<>(Arrays.asList(idActivo.toString(), usuario.getUsername(), usuario.getPasword(), usuario.getMail()));
    }

    /**
     * Funcion que se encarga de obtener una lista con parte de la información del usuario en memoria.
     * @param  tipo String que identifica de qué elemento se quiere obtener sus identificadores
     * @return una lista que contiene todos los nombres que posee el usuario del tipo "elemento" (teclado, alfabeto, ...)
     *          y sus identificadores.
     */
    private ArrayList<ArrayList<String>> getIds(String tipo) {

        //Creamos una lista de identificadores vacia
        ArrayList<ArrayList<String>> ids = new ArrayList<>();
        ArrayList<String> nombres = new ArrayList<>();

        //Creamos una lista que contiene los nombres del elemento "tipo" que posee el usuario acitvo
        if (tipo.equals("teclado")) nombres = usuario.getNombreTeclados();
        else if (tipo.equals("alfabeto")) nombres = usuario.getNombreAlfabetos();
        else if (tipo.equals("texto")) nombres = usuario.getNombreTextos();
        else if (tipo.equals("lista")) nombres = usuario.getNombreListas();

        //Obtenemos uno a uno los identificadores de los elementos atraves de su nombre y los agregamos a la lista de ids
        for (String nombre : nombres){
            if (tipo.equals("teclado")) ids.add(new ArrayList<>(Arrays.asList(nombre, usuario.getIdTeclado(nombre).toString())));
            else if (tipo.equals("alfabeto")) ids.add(new ArrayList<>(Arrays.asList(nombre, usuario.getIdAlfabeto(nombre).toString())));
            else if (tipo.equals("texto")) ids.add(new ArrayList<>(Arrays.asList(nombre, usuario.getIdTexto(nombre).toString())));
            else if (tipo.equals("lista")) ids.add(new ArrayList<>(Arrays.asList(nombre, usuario.getIdLista(nombre).toString())));
        }
        return ids;
    }

    /**
     * Funcion que se encarga de obtener una lista con toda la información de todos los elementos, de un tipo, del usuario activo.
     * @param  tipo String que identifica qué tipo de element se desea obtener.
     * @return una lista que contiene todos los elementos que posee el usuario del tipo "elemento" (teclado, alfabeto, ...)
     */
    private ArrayList<ArrayList<String>> getElemento(ArrayList<ArrayList<String>> ids, String tipo) {
        ArrayList<ArrayList<String>> resultado = new ArrayList<>();

        for (ArrayList<String> t : ids){
            ArrayList<String> elemento = new ArrayList<>();
            int id = Integer.parseInt(t.get(1));
            elemento.add(t.get(1));

            if (tipo.equals("teclado")) {
                elemento.add(toString(controlador.getTeclado(id)));
                elemento.add(controlador.getIdAlfabeto(id).toString());
                elemento.add(controlador.getIdTexto(id).toString());
                elemento.add(controlador.getIdLista(id).toString());
            }
            else if (tipo.equals("alfabeto")) {
                elemento.add(controlador.getAlfabeto(id));
                elemento.add(toString(controlador.getTecladosAsociadosAlfabeto(id)));
            }
            else if (tipo.equals("texto")) {
                elemento.add(controlador.getTexto(id));
                elemento.add(toString(controlador.getTecladosAsociadosTexto(id)));
            }
            else if (tipo.equals("lista")) {
                elemento.add("");
                elemento.add(toString(controlador.getTecladosAsociadosLista(id)));
            }
            resultado.add(elemento);
        }
        return resultado;
    }

    /**
     * Funcion que se encarga de obtener una lista con parte de la información de todas las listas de palabras del usuario activo.
     * @param  ids Identificadores de las listas de palabras.
     * @return una lista que contiene todas las listas de palabras, de las listas de palabras. (Solo las lista, no su información)
     */
    private ArrayList<HashMap<String, Integer>> getPalabras(ArrayList<ArrayList<String>> ids) {
        ArrayList<HashMap<String, Integer>> palabras = new ArrayList<>();
        for (ArrayList<String> t : ids){
            int id = Integer.parseInt(t.get(1));
            palabras.add(controlador.getListaPalabras(id));
        }
        return palabras;
    }

    /**
     * Cambia el username del usuario cargado en usuario.
     * @param newUsername nuevo nombre de usuario
     * @return codigo del error.
     */
    public int cambiarUsername(String newUsername) {
        if (!util.comprobarPasswordONombre(newUsername)) return -Error.typeError.ERRORFORMATOUSERNAME.ordinal();
        else if (usernameId.containsKey(newUsername)) return -Error.typeError.ERRORUSRALREADYREGISTERED.ordinal();
        String oldUsername = usuario.getUsername();
        usuario.setUsername(newUsername);

        usernameId.remove(oldUsername);
        usernameId.put(newUsername, idActivo);

        ArrayList<ArrayList<String>> listaUsuarios = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : usernameId.entrySet()) {
            ArrayList<String> us = new ArrayList<>();
            us.add(entry.getKey());
            us.add(entry.getValue().toString());
            listaUsuarios.add(us);
        }

        try {persis.updateListaUsuarios(listaUsuarios);}
        catch (IOException e) {return  -Error.typeError.ERRORENESCRITURA.ordinal();}

        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Cambia el correo del usuario activo.
     * @param newCorreo nuevo correo del usuario
     * @return codigo del error.
     */
    public int cambiarCorreo(String newCorreo) {
        if (!util.comprobarCorreo(newCorreo)) return -Error.typeError.ERRORFORMATOMAIL.ordinal();

        usuario.setMail(newCorreo);
        actualizarUsuario();
        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Cambia la contraseña del usuario activo.
     * @param newPassword nueva contraseña del usuario activo.
     * @param oldPassword antigua contraseña del usuario activo.
     * @return codigo del error.
     */
    public int cambiarPassword(String newPassword, String oldPassword) {
        ArrayList<String> userInfo = getInfoUsuario();
        if (!userInfo.get(2).equals(oldPassword)) return -Error.typeError.ERRORPASWORD.ordinal();
        else if (!util.comprobarPasswordONombre(newPassword)) return -Error.typeError.ERRORFORMATOPASWORD.ordinal();

        usuario.setPasword(newPassword);
        actualizarUsuario();

        return Error.typeError.TODOOK.ordinal();
    }

    /**
     * Obtiene la informacion de un telcado.
     * @param nombreTeclado teclado del que se quiere obtener la informacion.
     * @return codigo del error.
     */
    public ArrayList<String> getInfoTeclado(String nombreTeclado) {
        ArrayList<String> info = new ArrayList<>();
        int idTeclado = usuario.getIdTeclado(nombreTeclado);
        int idAlf, idText, idLis;
        idAlf = controlador.getIdAlfabeto(idTeclado);
        idText = controlador.getIdTexto(idTeclado);
        idLis = controlador.getIdLista(idTeclado);

        String nombreAlfabeto, nombreTexto, nombreLista;
        nombreAlfabeto = usuario.getNombreAlfabeto(idAlf);
        nombreTexto = usuario.getNombreTexto(idText);
        nombreLista = usuario.getNombreLista(idLis);

        info.add(nombreAlfabeto);
        if (nombreTexto.equals("null")) info.add("-");
        else info.add(nombreTexto);
        if (nombreLista.equals("null")) info.add("-");
        else info.add(nombreLista);
        return info;
    }

    /**
     * Elimina el usuario activo.
     */
    public int deleteUser() {
        String username = usuario.getUsername();
        usernameId.remove(username);

        ArrayList<ArrayList<String>> listaUsuarios = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : usernameId.entrySet()) {
            ArrayList<String> us = new ArrayList<>();
            us.add(entry.getKey());
            us.add(entry.getValue().toString());
            listaUsuarios.add(us);
        }

        try {persis.updateListaUsuarios(listaUsuarios);}
        catch (IOException e) {return  -Error.typeError.ERRORENESCRITURA.ordinal();}

        try{persis.deleteUser();}
        catch (IOException e) {return -Error.typeError.ERRORENESCRITURA.ordinal();}

        return logoutUsuario();
    }
}