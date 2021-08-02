package Simulacion_4.logica;

import Simulacion_4.gestor_archivos.archivos;
import Simulacion_4.interfaz.ui;
import Simulacion_4.persona.persona;

import java.io.*;
import java.util.ArrayList;

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

        for (int i = 0; i<jugador.size(); i++){
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

    public static void correrConsultas(int opcion, ArrayList<persona> players) {

        switch (opcion){
            case 1:
                String nombre = (String) ui.stringJugador("nombre");
                recorrerString(nombre, players, "1");
                break;
            case 2:
                int edad = ui.numericoJugador("edad");
                recorrerNumerico(edad, players, "1");
                break;

            case 3:
                int peso = ui.numericoJugador("peso");
                recorrerNumerico(peso, players, "2");
                break;
            case 4:
                int estatura = ui.numericoJugador("estatura");
                recorrerNumerico(estatura, players, "3");
                break;

            case 5:
                String pais = (String) ui.stringJugador("nacionalidad");
                recorrerString(pais, players, "2");
                break;
            case 6:
                int numeroCamiseta =  ui.numericoJugador("Numero de Camiseta");
                recorrerNumerico(numeroCamiseta, players, "4");
                break;
            case 7:
                ui.imprimirAgradecimiento("Muchas gracias por usar el simulador!!");
                break;

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
        double tiempoTotal = (fin - inicio) * 1.0e-9;
        System.out.println("El tiempo de ejecuacion fue de: " + tiempoTotal + " segundos.");
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
        }else if(s == "2"){
            for (int i = 0; i < players.size(); i++){
                if(players.get(i).getNacionalidad().contains(dato)){
                    jugadores_filtrados.add(players.get(i));
                }
            }
        }
        long fin = System.nanoTime();
        double tiempoTotal = (fin - inicio) * 1.0e-9;
        System.out.println("El tiempo de ejecuacion fue de: " + tiempoTotal + " segundos.");
        System.out.println();

        for (int j = 0; j < jugadores_filtrados.size(); j++){
            System.out.println(jugadores_filtrados.get(j));
        }
    }
}
