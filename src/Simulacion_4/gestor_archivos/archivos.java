package Simulacion_4.gestor_archivos;
import Simulacion_4.persona.persona;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class archivos {
    public void cargarDatos(ArrayList<persona> persona) throws FileNotFoundException {

        Scanner fileReader = new Scanner(new File("/Users/antony.vargasulead.ac.cr/IdeaProjects/Simulacion 4/src/ArchivosDeRegistro/datos/players_15.csv"));

        System.out.println("Cargando datos...");
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
            persona1.setIndice(Integer.parseInt(datos[8]));
            persona.add(persona1);
        }
        System.out.println("Datos cargados con exito");
        fileReader.close();
    }

    public void cargarDatosMain2() throws IOException {
        Scanner fileReader = new Scanner(new File("/Users/antony.vargasulead.ac.cr/IdeaProjects/Simulacion 4/src/ArchivosDeRegistro/datos/players_15.csv"));
        HashMap<String, ArrayList<Integer>> pais = new HashMap();
        HashMap<Integer, ArrayList<Integer>> estatura = new HashMap();
        HashMap<Integer, ArrayList<Integer>> peso = new HashMap();
        HashMap<Integer, ArrayList<Integer>> edad = new HashMap();
        int i = 1;
        while (fileReader.hasNextLine()) {
            String currentLine = fileReader.nextLine();
            String data[] = currentLine.split(";");
            if (!edad.containsKey(Integer.parseInt(data[1]))){
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(i);
                edad.put(Integer.parseInt(data[1]), arrayList);
            }else{
                edad.get(Integer.parseInt(data[1])).add(i);
            }

            if (!estatura.containsKey(Integer.parseInt(data[3]))){
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(i);
                estatura.put(Integer.parseInt(data[3]), arrayList);
            }else{
                estatura.get(Integer.parseInt(data[3])).add(i);
            }

            if (!peso.containsKey(Integer.parseInt(data[4]))){
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(i);
                peso.put(Integer.parseInt(data[4]), arrayList);
            }else{
                peso.get(Integer.parseInt(data[4])).add(i);
            }

            if (!pais.containsKey(data[5])){
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(i);
                pais.put(data[5], arrayList);
            }else{
                pais.get(data[5]).add(i);
            }
            i++;
        }

        escribirIxd(pais, "pais.idx");
        escribirIxd(estatura, "estatura.idx");
        escribirIxd(peso, "peso.idx");
        escribirIxd(edad, "edad.idx");

    }

    public void escribirIxd(HashMap indices, String nameFile) throws IOException {
        FileOutputStream f = new FileOutputStream(new File("//Users//antony.vargasulead.ac.cr//IdeaProjects//Simulacion 4//src//ArchivosDeRegistro//datos//"+nameFile));
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(indices);
        o.close();
        f.close();
    }
}
