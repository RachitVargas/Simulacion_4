package Simulacion_4;
import java.util.ArrayList;

import Simulacion_4.persona.persona;
import Simulacion_4.interfaz.ui;
import Simulacion_4.logica.logic;
import java.io.*;

public class main {

    public static void main (String args []) throws IOException, ClassNotFoundException {

        ArrayList<persona> jugador = new ArrayList<>();
        jugador = logic.cargarArchivos();
        logic.escribirArchivoBat(jugador);

        ArrayList<persona> players = new ArrayList();
        players = logic.leerDatosArchivoBat();

        ui anInterfaz = new ui();

        int opcion = 0;

        do{
            opcion = anInterfaz.menu();
            logic.correrConsultas(opcion, players);
        }while(opcion != 7);

    }
}
