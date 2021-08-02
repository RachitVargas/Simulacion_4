package Simulacion_4;
import java.util.ArrayList;
import Simulacion_4.persona.persona;
import Simulacion_4.gestor_archivos.archivos;
import java.io.*;


public class main {
    public static void main (String args []) throws IOException {

        archivos unArchivo = new archivos();
        ArrayList<persona> jugador = new ArrayList<>();

        unArchivo.cargarDatos(jugador);

        FileOutputStream f = new FileOutputStream(new File("//Users//antony.vargasulead.ac.cr//IdeaProjects//Simulacion 4//src//ArchivosDeRegistro//datos//archivo.dat"));
        ObjectOutputStream o = new ObjectOutputStream(f);

/*

        jugador.forEach(x -> {
            System.out.println(x.toString());
            try {
                o.writeObject(x);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
*/

        o.close();
        f.close();
    }
}
