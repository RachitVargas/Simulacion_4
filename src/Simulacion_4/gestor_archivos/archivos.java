package Simulacion_4.gestor_archivos;
import Simulacion_4.persona.persona;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class archivos {
    public void cargarDatos(ArrayList<persona> persona) throws FileNotFoundException {

        Scanner fileReader = new Scanner(new File("//Users//antony.vargasulead.ac.cr//IdeaProjects//Simulacion 4//src//ArchivosDeRegistro//datos//players_15.csv"));

        System.out.println("Cargando simulación...");
        while (fileReader.hasNextLine()) {
            String currentLine = fileReader.nextLine();
            String datos[] = currentLine.split(";");
            persona persona1 = new persona();
            persona1.setNombre(datos[0]);
            persona1.setEdad(Integer.parseInt(datos[1]));
            persona1.setFecha_nacimiento(datos[2]);
            persona1.setAltura(Integer.parseInt(datos[3]));
            persona1.setPeso(Integer.parseInt(datos[4]));
            persona1.setNacionalidad(datos[5]);
            persona1.setClub(datos[6]);
            persona1.setNumero_camiseta(Integer.parseInt(datos[7]));

            persona.add(persona1);
        }
        System.out.println("Simulación cargada con exito");
        fileReader.close();
    }
}
