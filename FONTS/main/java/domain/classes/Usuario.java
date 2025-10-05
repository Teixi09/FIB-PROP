package domain.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alejandra Traveria
 */
public class Usuario {
   //ATRIBUTOS
   private String username;
   private String pasword;
   private String mail;
   private HashMap<String,Integer> mapaTeclados;
   private HashMap<String, Integer> mapaAlfabetos;
   private HashMap<String, Integer> mapaListasPalabras;
   private HashMap<String, Integer> mapaTextos;

   //CONSTRUCTORAS

   /**
    * Constructora de usuario a partir de un username, una pasword y un mail
    * @param username
    * @param pasword
    * @param mail
    */
   public Usuario(String username, String pasword, String mail) {
      this.username = username;
      this.pasword = pasword;
      this.mail = mail;
      mapaTeclados = new HashMap<>();
      mapaAlfabetos = new HashMap<>();
      mapaListasPalabras = new HashMap<>();
      mapaTextos = new HashMap<>();
   }

   //GETTERS

   /**
    * Getter del username del usuario
    * @return username
    */
   public String getUsername() {
      return username;
   }

   /**
    * Getter de la pasword del username
    * @return pasword
    */
   public String getPasword() {
      return pasword;
   }

   /**
    * Getter del mail
    * @return mail
    */
   public String getMail() {
      return mail;
   }

   /**
    * Getter de la lista de Teclados del usuario
    * @return listaTeclados
    */
   public ArrayList<Integer> getTeclados() {
      ArrayList<Integer> aux = new ArrayList<>(mapaTeclados.values());
      return aux;
   }

   /**
    * Getter de la lista de Alfabetos
    * @return listaAlfabetos
    */
   public ArrayList<Integer> getAlfabetos() {
      ArrayList<Integer> aux = new ArrayList<>(mapaAlfabetos.values());
      return aux;
   }

   /**
    * Getter de la lista de Listas de palabras
    * @return listaListasPalabras
    */
   public ArrayList<Integer> getListasPalabras() {
      ArrayList<Integer> aux = new ArrayList<>(mapaListasPalabras.values());
      return aux;
   }

   /**
    * Getter de la lista de Textos
    * @return listaTextos
    */
   public ArrayList<Integer> getTextos() {
      ArrayList<Integer> aux = new ArrayList<>(mapaTextos.values());
      return aux;
   }

   /**
    * Getter de los nombres de los teclados
    * @return listaNombresTeclados
    */
   public ArrayList<String> getNombreTeclados() {
      ArrayList<String> aux = new ArrayList<>(mapaTeclados.keySet());
      return aux;
   }

   /**
    * Getter de los nombres de los alfabetos
    * @return listaNombresAlfabetos
    */
   public ArrayList<String> getNombreAlfabetos() {
      ArrayList<String> aux = new ArrayList<>(mapaAlfabetos.keySet());
      return aux;
   }

   /**
    * Getter de los nombres de las listas
    * @return listaNombresListas
    */
   public ArrayList<String> getNombreListas() {
      ArrayList<String> aux = new ArrayList<>(mapaListasPalabras.keySet());
      return aux;
   }

   /**
    * Getter de los nombres de los Textos
    * @return listaNombresTeclados
    */
   public ArrayList<String> getNombreTextos() {
      ArrayList<String> aux = new ArrayList<>(mapaTextos.keySet());
      return aux;
   }

   /**
    * Getter del idAlfabeto asociado a un nombreAlfabeto
    * @param nombreTeclado
    * @return idTeclado
    */
   public Integer getIdTeclado(String nombreTeclado) {
      return mapaTeclados.get(nombreTeclado);
   }

   /**
    * Getter del idAlfabeto asociado a un nombreAlfabeto
    * @param nombreAlfabeto
    * @return idAlfabeto
    */
   public Integer getIdAlfabeto(String nombreAlfabeto) {
      return mapaAlfabetos.get(nombreAlfabeto);
   }

   /**
    * Getter del idTexto asociado a un nombreTexto
    * @param nombreTexto
    * @return idTexto
    */
   public Integer getIdTexto(String nombreTexto) {
      return mapaTextos.get(nombreTexto);
   }

   /**
    * Getter del idLista asociado a un nombreLista
    * @param nombreLista
    * @return idLista
    */
   public Integer getIdLista(String nombreLista) {
      return mapaListasPalabras.get(nombreLista);
   }

   //SETTERS

   /**
    * Setter del username
    * @param newUsername nuevo nombre de usuario
    */
   public void setUsername(String newUsername) {
      this.username = newUsername;
   }

   /**
    * Setter del pasword
    * @param newPasword nueva pasword
    */
   public void setPasword(String newPasword) {
      this.pasword = newPasword;
   }

   /**
    * Setter del mail
    * @param newMail nuevo mail
    */
   public void setMail(String newMail) {
      this.mail = newMail;
   }

   //CHECKERS

   /**
    * Comprueba si el usuario tiene el teclado con nombre = nombreTeclado
    * @param nombreTeclado nombre del teclado que buscamos
    * @body retorna true si el usuario tiene el teclado
    */
   public Boolean checkTeclado(String nombreTeclado) {
      return mapaTeclados.containsKey(nombreTeclado);
   }

   /**
    * Comprueba si el usuario tiene el teclado con id = idTeclado
    * @param idTeclado identificador del teclado
    * @body retorna true si lo tiene
    */
   public Boolean checkIdTeclado(Integer idTeclado) {
      for (Integer value : mapaTeclados.values()) {
         if (value.equals(idTeclado)) return true;
      }
      return false;
   }

   /**
    * Comprueba si el usuario tiene el alfabeto con nombre nombreAlfabeto
    * @param nombreAlfabeto nombre del alfabeto que buscamos
    * @body retorna true si el usuario tiene el alfabeto
    */
   public Boolean checkAlfabeto(String nombreAlfabeto) {
      return mapaAlfabetos.containsKey(nombreAlfabeto);
   }

   /**
    * Comprueba si el usuario tiene el alfabeto con id = idAlfabeto
    * @param idAlfabeto identificador del alfabeto
    * @body retorna true si lo tiene
    */
   public Boolean checkIdAlfabeto(Integer idAlfabeto) {
      for (Integer value : mapaAlfabetos.values()) {
         if (value.equals(idAlfabeto)) return true;
      }
      return false;
   }

   /**
    * Comprueba si el usuario tiene la lista de palabras con nombre nombreListaPalabras
    * @param nombreLista nombre de la lista de palabras que buscamos
    * @body retorna true si el usuario tiene la lisa de palabras
    */
   public Boolean checkLista(String nombreLista) {
      return mapaListasPalabras.containsKey(nombreLista);
   }

   /**
    * Comprueba si el usuario tiene la lista con id = idLista
    * @param idLista identificador de la lista
    * @body retorna true si lo tiene
    */
   public Boolean checkIdLista(Integer idLista) {
      for (Integer value : mapaListasPalabras.values()) {
         if (value.equals(idLista)) return true;
      }
      return false;
   }

   /**
    * Comprueba si el usuario tiene el texto con nombre nombreTexto
    * @param nombreTexto nombre del texto que buscamos
    * @body retorna true si el usuario tiene el texto
    */
   public Boolean checkTexto(String nombreTexto) {
      return mapaTextos.containsKey(nombreTexto);
   }

   /**
    * Comprueba si el usuario tiene el texto con id = idTexto
    * @param idTexto identificador del teclado
    * @body retorna true si lo tiene
    */
   public Boolean checkIdTexto(Integer idTexto) {
      for (Integer value : mapaTextos.values()) {
         if (value.equals(idTexto)) return true;
      }
      return false;
   }

   /**
    * Mira si se ha llegado al limite de teclados
    * @body retorna true si hay espacio
    */
   public Boolean checkSizeTeclados() {
      return (mapaTeclados.size() < 10);
   }

   /**
    * Mira si se ha llegado al limite de alfabetos
    * @body retorna true si hay espacio
    */
   public Boolean checkSizeAlfabetos() {
      return (mapaAlfabetos.size() < 10);
   }

   /**
    * Mira si se ha llegado al limite de listas de palabras
    * @body retorna true si hay espacio
    */
   public Boolean checkSizeListas() {
      return (mapaListasPalabras.size() < 10);
   }

   /**
    * Mira si se ha llegado al limite de textos
    * @body retorna true si hay espacio
    */
   public Boolean checkSizeTextos() {
      return (mapaTextos.size() < 10);
   }

   /**
    * Comprueba si hay teclados
    * @body retorna true si esta vacio
    */
   public Boolean emptyTeclados() {
      return mapaTeclados.isEmpty();
   }

   /**
    * Comprueba si hay alfabetos
    * @body retorna true si esta vacio
    */
   public Boolean emptyAlfabetos() {
      return mapaAlfabetos.isEmpty();
   }

   /**
    * Comprueba si hay textos
    * @body retorna true si esta vacio
    */
   public Boolean emptyTextos() {
      return mapaTextos.isEmpty();
   }

   /**
    * Comprueba si hay listas de palabras
    * @body retorna true si esta vacio
    */
   public Boolean emptyListas() {
      return mapaListasPalabras.isEmpty();
   }

   //FUNCIONES

   /**
    * Añade un nuevo teclado a la lista de teclados del usuario
    * @param idTeclado identificador del teclado que añadimos
    * @param nombreTelado nombre del teclado
    * @pre El usuario tiene menos de 10 teclados guardados
    * @post Se añade al mapa de teclados del usuario el teclado
    */
   public void addTeclado(Integer idTeclado, String nombreTelado) {
      mapaTeclados.put(nombreTelado, idTeclado);
   }

   /**
    * Añade un nuevo alfabeto a la lista de alfabetos del usuario
    * @param idAlfabeto identificador del alfabeto que añadimos
    * @param nombreAlfabeto nombre del alfabeto
    * @pre El usuario tiene menos de 10 alfabetos guardados
    * @post Se añade al mapa de alfabetos del usuario el alfabeto
    */
   public void addAlfabeto(Integer idAlfabeto, String nombreAlfabeto) {
      mapaAlfabetos.put(nombreAlfabeto, idAlfabeto);
   }

   /**
    * Añade una nueva lista de palabras al mapa de listas de palabras del usuario
    * @param idListaPalabras identificador de la lista de palabras que añadimos
    * @param nombreLista nombre de la lista
    * @pre El usuario tiene menos de 10 listas de palabras guardados
    * @post Se añade al mapa de listas de palabras del usuario la lista
    */
   public void addListaPalabras(Integer idListaPalabras, String nombreLista) {
      mapaListasPalabras.put(nombreLista, idListaPalabras);
   }

   /**
    * Añade un nuevo texto a la lista de textos del usuario
    * @param idTexto identificador del texto que añadimos
    * @param nombreTexto nombre del texto
    * @pre El usuario tiene menos de 10 textos guardados
    * @post Se añade al mapa de textos del usuario el texto
    */
   public void addTexto(Integer idTexto, String nombreTexto) {
      mapaTextos.put(nombreTexto, idTexto);
   }

   /**
    * Elimina un teclado de la lista de teclados del usuario
    * @param nombreTeclado nombre del teclado
    * @pre El usuario tiene mas de 0 teclados guardados
    * @post Se elimina de la lista de teclados del usuario el teclado
    */
   public void deleteTeclado(String nombreTeclado) {
      mapaTeclados.remove(nombreTeclado);
   }

   /**
    * Elimina un alfabeto de la lista de alfabetos del usuario
    * @param nombreAlfabeto nombre del alfabeto
    * @pre El usuario tiene mas de 0 alfabetos guardados
    * @post Se elimina de la lista de alfabetos del usuario el alfabeto
    */
   public void deleteAlfabeto(String nombreAlfabeto) {
      mapaAlfabetos.remove(nombreAlfabeto);
   }

   /**
    * Elimina una lista de palabras de la lista lista de palabras del usuario
    * @param nombreLista nombre de la lista de palabras
    * @pre El usuario tiene mas de 0 listas de palabras guardadas
    * @post Se elimina de la lista de listas de palabras del usuario la lista
    */
   public void deleteListaPalabras(String nombreLista) {
      mapaListasPalabras.remove(nombreLista);
   }

   /**
    * Elimina un texto de la lista de textos del usuario
    * @param nombreTexto nombre del texto
    * @pre El usuario tiene mas de 0 textos guardados
    * @post Se elimina de la lista de textos del usuario el texto
    */
   public void deleteTexto(String nombreTexto) {
      mapaTextos.remove(nombreTexto);
   }

   /**
    * Edita el teclado con nombre = nombreTeclado
    * @param nombreTeclado nombre del teclado
    * @param newNombreTeclado nuevo nombre del teclado
    * @post Se le cambia el nombre a newNombreTeclado
    */
   public void editarTeclado(String nombreTeclado, String newNombreTeclado) {
      Integer id = mapaTeclados.get(nombreTeclado);
      mapaTeclados.put(newNombreTeclado, id);
      mapaTeclados.remove(nombreTeclado);
   }

   /**
    * Edita el alfabeto con nombre = nombreAlfabeto
    * @param nombreAlfabeto nombre del alfabeto
    * @param newNombreAlfabeto nuevo nombre del alfabeto
    * @post Se le cambia el nombre a newNombreAlfabeto
    */
   public void editarAlfabeto(String nombreAlfabeto, String newNombreAlfabeto) {
      Integer id = mapaAlfabetos.get(nombreAlfabeto);
      mapaAlfabetos.put(newNombreAlfabeto, id);
      mapaAlfabetos.remove(nombreAlfabeto);
   }

   /**
    * Edita el texto con nombre = nombreAlfabeto
    * @param nombreTexto nombre del alfabeto
    * @param newNombreTexto nuevo nombre del alfabeto
    * @post Se le cambia el nombre a newNombreAlfabeto
    */
   public void editarTexto(String nombreTexto, String newNombreTexto) {
      Integer id = mapaTextos.get(nombreTexto);
      mapaTextos.put(newNombreTexto, id);
      mapaTextos.remove(nombreTexto);
   }

   /**
    * Edita el lista con nombre = nombreAlfabeto
    * @param nombreLista nombre del alfabeto
    * @param newNombreLista nuevo nombre del alfabeto
    * @post Se le cambia el nombre a newNombreAlfabeto
    */
   public void editarLista(String nombreLista, String newNombreLista) {
      Integer id = mapaListasPalabras.get(nombreLista);
      mapaListasPalabras.put(newNombreLista, id);
      mapaListasPalabras.remove(nombreLista);
   }

   public String getNombreAlfabeto(int idAlfabeto) {
      for (Map.Entry<String, Integer> entry : mapaAlfabetos.entrySet()) {
         if (entry.getValue() == idAlfabeto) return entry.getKey();
      }
      return "null";
   }

   public String getNombreLista(int idLista) {
      for (Map.Entry<String, Integer> entry : mapaListasPalabras.entrySet()) {
         if (entry.getValue() == idLista) return entry.getKey();
      }
      return "null";
   }

   public String getNombreTexto(int idTexto) {
      for (Map.Entry<String, Integer> entry : mapaTextos.entrySet()) {
         if (entry.getValue() == idTexto) return entry.getKey();
      }
      return "null";
   }
}


