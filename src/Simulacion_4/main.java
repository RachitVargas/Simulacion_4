package Simulacion_4;
import java.util.ArrayList;

import Simulacion_4.persona.persona;
import Simulacion_4.interfaz.ui;
import Simulacion_4.logica.logic;
import java.io.*;
import java.util.HashMap;

public class main {

    public static void main (String args []) throws IOException, ClassNotFoundException {

        ArrayList<persona> jugador;
        jugador = logic.cargarArchivos();
        logic.escribirArchivoBat(jugador);

        ArrayList<persona> players;
        players = logic.leerDatosArchivoBat();

        ui anInterfaz = new ui();
        HashMap pais = logic.readData("pais.idx");
        HashMap estatura = logic.readData("estatura.idx");
        HashMap peso = logic.readData("peso.idx");
        HashMap edad = logic.readData("edad.idx");

        int opcion = 0;

        do{
            opcion = anInterfaz.menu();
            logic.correrConsultas(opcion, players, pais, estatura, peso, edad);
        }while(opcion != 7);

    }
}
