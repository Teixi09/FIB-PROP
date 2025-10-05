package presentacion;

import domain.controlador.ControladorDominio;
import domain.classes.Error;

import java.util.ArrayList;
import java.util.HashMap;

public class controladorPresentacion {

    private ControladorDominio cd;
    private firstView loginReg;
    private errorView error;
    private menuView menu;

    public controladorPresentacion() {
        cd = new ControladorDominio();
        iniControladorPresentacion();
    }

    public void iniControladorPresentacion() {
        loginReg = new firstView(this);
        loginReg.setVisible(true);
        loginReg.setLocationRelativeTo(null);
        error = new errorView();
    }

    public void mostrarError(int status) {
        String errorMsg = Error.printError(-status);
        error.setMessageError(errorMsg);
        error.setVisible(true);
        error.setLocationRelativeTo(null);
    }

    public void mostrarSuccess(String type) {
        successView success = new successView(type);
        success.setVisible(true);
        success.setLocationRelativeTo(null);
    }

    public int login(String username, String password) {
        int status = cd.loginUsuario(username, password);
        if (status >= 0) {
            menu = new menuView(this);
            menu.setVisible(true);
            menu.setLocationRelativeTo(null);
        }
        return status;
    }

    public void logout() {
        int status = cd.logoutUsuario();
        if (status < 0) mostrarError(status);
        else {
            loginReg = new firstView(this);
            loginReg.setVisible(true);
            loginReg.setLocationRelativeTo(null);
            menu.setVisible(false);
        }
    }

    public int register(String username, String password, String mail) {
        int status = cd.registroUsuario(username, password, mail);
        if (status >= 0) {
            menu = new menuView(this);
            menu.setVisible(true);
            menu.setLocationRelativeTo(null);
        }
        return status;
    }

    public ArrayList<String> getInfoUser() {
        return cd.getInfoUsuario();
    }

    public String getAlfabeto(String nombreAlfabeto) {
        StringBuilder alfabeto = new StringBuilder();
        cd.verAlfabeto(nombreAlfabeto, alfabeto);
        return alfabeto.toString();
    }

    public void getNombresAlfabetos(ArrayList<String> listaNombresAlfabetos) {
        cd.listarAlfabetos(listaNombresAlfabetos);
    }

    public HashMap<String, Integer> getLista(String nombreLista) {
        HashMap<String, Integer> lista = new HashMap<>();
        cd.verLista(nombreLista, lista);
        return lista;
    }

    public void getNombresListas(ArrayList<String> listaNombresListas) {
        cd.listarListas(listaNombresListas);
    }

    public void getNombreTeclados(ArrayList<String> listaNombreTeclados) {
        cd.listarTeclados(listaNombreTeclados);
    }

    public ArrayList<String> getInfoTeclado(String nombreTeclado) {
        return cd.getInfoTeclado(nombreTeclado);
    }

    public void getNombresTextos(ArrayList<String> listasNombresTextos) {
        cd.listarTextos(listasNombresTextos);
    }

    public String getText(String textName) {
        StringBuilder text = new StringBuilder();
        cd.verTexto(textName, text);
        return text.toString();
    }

    public void getNewUsername() {
        cambiarUsernameMailView changeUsername = new cambiarUsernameMailView(this, "usr");
        changeUsername.setVisible(true);
        changeUsername.setLocationRelativeTo(null);
    }

    public void changeUsername(String newUsername) {
        int status = cd.cambiarUsername(newUsername);
        if (status < 0) mostrarError(status);
        else {
            menu.iniUser();
            mostrarSuccess("change");
        }
    }

    public void getNewMail() {
        cambiarUsernameMailView changeMail = new cambiarUsernameMailView(this, "mail");
        changeMail.setVisible(true);
        changeMail.setLocationRelativeTo(null);
    }

    public void changeMail(String newMail) {
        int status = cd.cambiarCorreo(newMail);
        if (status < 0) mostrarError(status);
        else {
            menu.iniUser();
            mostrarSuccess("change");
        }
    }

    public void getNewPassword() {
        cambiarPasswordView changePassword = new cambiarPasswordView(this);
        changePassword.setVisible(true);
        changePassword.setLocationRelativeTo(null);
    }

    public void changePassword(String newPassword, String oldPassword) {
        int status = cd.cambiarPassword(newPassword, oldPassword);
        if (status < 0) mostrarError(status);
        else {
            menu.iniUser();
            mostrarSuccess("change");
        }
    }

    public void crearAlfabeto(String nombre, String alfabeto) {
        int status = cd.crearAlfabeto(nombre, alfabeto);
        if (status < 0) mostrarError(status);
        else {
            menu.iniAlfabetos();
            mostrarSuccess("create");
        }
    }

    public void eliminarAlfabeto(String nombreAlfabeto) {
        int status = cd.eliminarAlfabeto(nombreAlfabeto);
        if (status < 0) mostrarError(status);
        else {
            menu.iniAlfabetos();
            mostrarSuccess("delete");
        }
    }

    public void editarAlfabeto(String antiguoNombre, String nuevoNombreAlfabeto, String antiguoAlfabeto, String alfabeto) {
        int status1 = 1;
        int status2 = 1;

        if (!antiguoAlfabeto.equals(alfabeto)) status1 = cd.editarAlfabeto(antiguoNombre, alfabeto);
        if (!antiguoNombre.equals(nuevoNombreAlfabeto)) status2 = cd.editarNombreAlfabeto(antiguoNombre, nuevoNombreAlfabeto);

        if (status1 < 0 && status2 < 0) {
            error.setMessageError(Error.printError(-status1) + "\n" + Error.printError(-status2));
            error.setVisible(true);
            error.setLocationRelativeTo(null);
        }
        else if (status1 < 0) mostrarError(status1);
        else if (status2 < 0) mostrarError(status2);
        else if (status1 == 0 || status2 == 0) mostrarSuccess("edit");
        menu.iniAlfabetos();
    }

    public void importarAlfabeto(String path, String nombre) {
        int status = cd.importarAlfabeto(path, nombre);
        if (status < 0) mostrarError(status);
        else {
            menu.iniAlfabetos();
            mostrarSuccess("import");
        }
    }

    public void exportarAlfabeto(String path, String nombre) {
        int status = cd.exportarAlfabeto(path, nombre);
        if (status < 0) mostrarError(status);
        else mostrarSuccess("export");
    }

    public void crearTexto(String nombreTexto, String texto) {
        int status = cd.crearTexto(nombreTexto, texto);
        if (status < 0) mostrarError(status);
        else {
            menu.iniTextos();
            mostrarSuccess("create");
        }
    }

    public void eliminarTexto(String nombreTexto) {
        int status = cd.eliminarTexto(nombreTexto);
        if (status < 0) mostrarError(status);
        else {
            menu.iniTextos();
            mostrarSuccess("delete");
        }
    }

    public void editarTexto(String antiguoNombre, String nuevoNombreTexto, String antiguoTexto, String texto) {
        int status1 = 1;
        int status2 = 1;

        if (!antiguoTexto.equals(texto)) status1 = cd.editarTexto(antiguoNombre, texto);
        if (!antiguoNombre.equals(nuevoNombreTexto)) status2 = cd.editarNombreTexto(antiguoNombre, nuevoNombreTexto);

        if (status1 < 0 && status2 < 0) {
            error.setMessageError(Error.printError(-status1) + "\n" + Error.printError(-status2));
            error.setVisible(true);
            error.setLocationRelativeTo(null);
        }
        else if (status1 < 0) mostrarError(status1);
        else if (status2 < 0) mostrarError(status2);
        else if (status1 == 0 || status2 == 0) mostrarSuccess("edit");
        menu.iniTextos();
    }

    public void importarTexto(String path, String nombre) {
        int status = cd.importarTexto(path, nombre);
        if (status < 0) mostrarError(status);
        else {
            menu.iniTextos();
            mostrarSuccess("import");
        }
    }

    public void exportarTexto(String path, String nombre) {
        int status = cd.exportarTexto(path, nombre);
        if (status < 0) mostrarError(status);
        else mostrarSuccess("export");
    }

    public void crearLista(String nombreLista, HashMap<String, Integer> lista) {
        int status = cd.crearListaDePalabras(nombreLista, lista);
        if (status < 0) mostrarError(status);
        else {
            menu.iniListas();
            mostrarSuccess("create");
        }
    }

    public void eliminarLista(String nombreLista) {
        int status = cd.eliminarListaDePalabras(nombreLista);
        if (status < 0) mostrarError(status);
        else {
            menu.iniListas();
            mostrarSuccess("delete");
        }
    }

    public void editarLista(String antiguoNombre, String nuevoNombreLista, HashMap<String, Integer> antiguaList, HashMap<String, Integer> lista) {
        int status1 = 1;
        int status2 = 1;

        if (!antiguaList.equals(lista)) status1 = cd.editarLista(antiguoNombre, lista);
        if (!antiguoNombre.equals(nuevoNombreLista)) status2 = cd.editarNombreLista(antiguoNombre, nuevoNombreLista);

        if (status1 < 0 && status2 < 0) {
            error.setMessageError(Error.printError(-status1) + "\n" + Error.printError(-status2));
            error.setVisible(true);
            error.setLocationRelativeTo(null);
        }
        else if (status1 < 0) mostrarError(status1);
        else if (status2 < 0) mostrarError(status2);
        else if (status1 == 0 || status2 == 0) mostrarSuccess("edit");
        menu.iniListas();
    }

    public void importarLista(String path, String nombre) {
        int status = cd.importarLista(path, nombre);
        if (status < 0) mostrarError(status);
        else {
            menu.iniListas();
            mostrarSuccess("import");
        }
    }

    public void exportarLista(String path, String nombre) {
        int status = cd.exportarLista(path, nombre);
        if (status < 0) mostrarError(status);
        else mostrarSuccess("export");
    }

    public void crearTecladoTexto(String nombre, int type, String nombreAlfabeto, String nombreTexto) {

        int status = cd.crearTecladoConTexto(nombre, type, nombreAlfabeto, nombreTexto);
        if (status < 0) mostrarError(status);
        else {
            menu.iniTeclados();
            mostrarSuccess("create");
        }
    }

    public void crearTecladoLista(String nombre, int type, String nombreAlfabeto, String nombreLista) {
        int status = cd.crearTecladoConLista(nombre, type, nombreAlfabeto, nombreLista);
        if (status < 0) mostrarError(status);
        else {
            menu.iniTeclados();
            mostrarSuccess("create");
        }
    }

    public void eliminarTeclado(String nombreTeclado) {
        int status = cd.eliminarTeclado(nombreTeclado);
        if (status < 0) mostrarError(status);
        else {
            menu.iniTeclados();
            mostrarSuccess("delete");
        }
    }

    public void editarTeclado(String nombre, String nuevoNombre) {
        int status = cd.editarNombreTeclado(nombre, nuevoNombre);
        if (status < 0) mostrarError(status);
        else {
            menu.iniTeclados();
            mostrarSuccess("edit");
        }
    }

    public void exportarTeclado(String path, String nombre) {
        int status = cd.exportarTeclado(path, nombre);
        if (status < 0) mostrarError(status);
        else mostrarSuccess("export");
    }

    public void getTeclado(String nombreTeclado, ArrayList<ArrayList<Character>> layout) {
        int status = cd.verTeclado(nombreTeclado, layout);
        if (status < 0) mostrarError(status);

    }

    public void eliminarUsuario() {
        int status = cd.deleteUser();
        if (status < 0) mostrarError(status);
        else {
            loginReg = new firstView(this);
            loginReg.setVisible(true);
            loginReg.setLocationRelativeTo(null);
            menu.setVisible(false);
            mostrarSuccess("delete");
        }
    }
}
