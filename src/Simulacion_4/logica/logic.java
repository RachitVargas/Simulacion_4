package Simulacion_4.logica;

import Simulacion_4.gestor_archivos.archivos;
import Simulacion_4.persona.persona;

import java.io.*;
import java.util.ArrayList;

public class logic {

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
}
