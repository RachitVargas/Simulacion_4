package Simulacion_4.logica;

import Simulacion_4.gestor_archivos.archivos;
import Simulacion_4.interfaz.ui;
import Simulacion_4.persona.persona;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class logic {

    ui anInterfaz;

    public logic() {
        this.anInterfaz = new ui();
    }

    public static ArrayList<persona> cargarArchivos() throws FileNotFoundException {
        archivos unArchivo = new archivos();
        ArrayList<persona> jugador = new ArrayList<>();
        unArchivo.cargarDatos(jugador);
        return jugador;
    }

    public static void escribirArchivoBat(ArrayList<persona> jugador) throws IOException {
        FileOutputStream f = new FileOutputStream(new File("//Users//antony.vargasulead.ac.cr//IdeaProjects//Simulacion 4//src//ArchivosDeRegistro//archivo.dat"));
        ObjectOutputStream o = new ObjectOutputStream(f);

        for (int i = 0; i < jugador.size(); i++) {
            o.writeObject(jugador.get(i));
        }

        o.close();
        f.close();
    }

    public static ArrayList<persona> leerDatosArchivoBat() throws IOException {
        FileInputStream fi = new FileInputStream(new File("//Users//antony.vargasulead.ac.cr//IdeaProjects//Simulacion 4//src//ArchivosDeRegistro//archivo.dat"));
        ObjectInputStream oi = new ObjectInputStream(fi);

        ArrayList<persona> players = new ArrayList();

        try {
            persona obj = null;
            while ((obj = (persona) oi.readObject()) != null) {
                players.add(obj);
            }
        }catch (Exception e){
            oi.close();
            fi.close();
        }
        oi.close();
        fi.close();

        return players;
    }

    public HashMap leerDatosInx(String nameFile) throws IOException, ClassNotFoundException {
        FileInputStream fi = new FileInputStream(new File("//Users//antony.vargasulead.ac.cr//IdeaProjects//Simulacion 4//src//ArchivosDeRegistro//datos//"+nameFile));
        ObjectInputStream oi = new ObjectInputStream(fi);
        HashMap hashMap  = new HashMap();
        try {
            hashMap = (HashMap) oi.readObject();
        }catch (Exception e){
            oi.close();
            fi.close();
        }
        oi.close();
        fi.close();
        return hashMap;
    }

    public static void correrConsultas(int opcion, ArrayList<persona> players, HashMap pais,
                                       HashMap estatura, HashMap peso, HashMap edad) {

        switch (opcion){
            case 1:
                String nombre = (String) ui.stringJugador("nombre");
                recorrerString(nombre, players, "1");
                break;
            case 2:
                int edad_consola = ui.numericoJugador("edad");
                recorrerNumerico(edad_consola, players, "1");
                hacerBusquedaPorIndex(edad, edad_consola, players);
                break;

            case 3:
                int peso_consola = ui.numericoJugador("peso");
                recorrerNumerico(peso_consola, players, "2");
                hacerBusquedaPorIndex(peso, peso_consola, players);
                break;
            case 4:
                int estatura_consola = ui.numericoJugador("estatura");
                recorrerNumerico(estatura_consola, players, "3");
                hacerBusquedaPorIndex(estatura, estatura_consola, players);
                break;

            case 5:
                String pais_consola = (String) ui.stringJugador("nacionalidad");
                recorrerString(pais_consola, players, "2");
                hacerBusquedaPorIndex(pais, pais_consola, players);
                break;
            case 6:
                int numeroCamiseta =  ui.numericoJugador("Numero de Camiseta");
                recorrerNumerico(numeroCamiseta, players, "4");
                break;
            case 7:
                ui.imprimirAgradecimiento("Muchas gracias por usar el simulador!!");
                break;
            default:
                System.out.println("Opcion invalida!!");
        }
    }

    private static void recorrerNumerico(int dato, ArrayList<persona> players, String s) {
        ArrayList<persona> jugadores_filtrados = new ArrayList();
        long inicio = System.nanoTime();

        if (s == "1"){
            for (int i = 0; i < players.size(); i++){
                if(players.get(i).getEdad() == dato){
                    jugadores_filtrados.add(players.get(i));
                }
            }
        } else if (s == "2"){
            for (int i = 0; i < players.size(); i++){
                if(players.get(i).getPeso() == dato){
                    jugadores_filtrados.add(players.get(i));
                }
            }
        } else if (s == "3"){
            for (int i = 0; i < players.size(); i++){
                if(players.get(i).getAltura() == dato){
                    jugadores_filtrados.add(players.get(i));
                }
            }
        }else if (s == "4"){
            for (int i = 0; i < players.size(); i++){
                if(players.get(i).getNumero_camiseta() == dato){
                    jugadores_filtrados.add(players.get(i));
                }
            }
        }

        long fin = System.nanoTime();
        double tiempoTotal = (fin - inicio);
        System.out.println("El tiempo de ejecuacion fue de: " + tiempoTotal + " milisegundos.");
        System.out.println();

        for (int j = 0; j < jugadores_filtrados.size(); j++){
            System.out.println(jugadores_filtrados.get(j));
        }
    }


    private static void recorrerString(String dato, ArrayList<persona> players, String s) {
        ArrayList<persona> jugadores_filtrados = new ArrayList();
        long inicio = System.nanoTime();
        if (s == "1"){
            for (int i = 0; i < players.size(); i++){
                if(players.get(i).getNombre().contains(dato)){
                    jugadores_filtrados.add(players.get(i));
                }
            }
        }else if(s == "2") {
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).getNacionalidad().contains(dato)) {
                    jugadores_filtrados.add(players.get(i));
                }
            }
        }
        long fin = System.nanoTime();
        double tiempoTotal = (fin - inicio);
        System.out.println("El tiempo de ejecuacion fue de (sin index): " + tiempoTotal + " milisegundos.");
        System.out.println();

        for (int j = 0; j < jugadores_filtrados.size(); j++){
            System.out.println(jugadores_filtrados.get(j));
        }
    }

    public static HashMap readData(String nombreHash) throws IOException {
        FileInputStream i = new FileInputStream(new File("//Users//antony.vargasulead.ac.cr//IdeaProjects//Simulacion 4//src//ArchivosDeRegistro//datos//"+nombreHash));
        ObjectInputStream o = new ObjectInputStream(i);
        HashMap hashMap  = new HashMap();
        try {
            hashMap = (HashMap) o.readObject();
        }catch (Exception e){
            o.close();
            i.close();
        }
        o.close();
        i.close();
        return hashMap;
    }

    public static void hacerBusquedaPorIndex(HashMap hashMap, Object term, ArrayList<persona> personas) {
        long inicio = System.nanoTime();

        ArrayList<Integer> result = (ArrayList) hashMap.get(term);

        for (Integer consecutivo: result) {
            persona persona1 = personas.get(consecutivo-1);
            System.out.println(persona1);
        }

        long fin = System.nanoTime();
        double tiempoTotal = (fin - inicio);
        System.out.println("El tiempo de ejecuacion fue de (tecnica de index): " + tiempoTotal + " milisegundos");
    }
}
