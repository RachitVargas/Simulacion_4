package Simulacion_4.interfaz;
import java.io.PrintStream;
import java.util.Scanner;

public class ui {

    private static Scanner input;
    private static PrintStream output;

    public ui(){
        this.input = new Scanner(System.in);
        this.output = new PrintStream(System.out);
    }

    public static void imprimirAgradecimiento(String mensaje) {
        System.out.println(mensaje);
    }

    public static Object stringJugador(String consulta) {
        System.out.println("Escriba la/el " + consulta + " a consultar: ");
        return input.next();
    }

    public static int numericoJugador(String consulta) {
        System.out.println("Escriba la/el + " + consulta + " del jugador: ");
        return Integer.parseInt(input.next());
    }

    public int menu() {
        System.out.println("Bienvenido al simulador de jugadores");
        System.out.println("Elija una opcion:");
        System.out.println("1. Buscar jugadores por nombre");
        System.out.println("2. Buscar jugadores por edad");
        System.out.println("3. Buscar jugadores por peso");
        System.out.println("4. Buscar jugadores por altura");
        System.out.println("5. Buscar jugadores por pais");
        System.out.println("6. Buscar jugadores por el numero de camiseta");
        System.out.println("7. Salir del simulador");
        String opcion = input.next();
        return Integer.parseInt(opcion);
    }
}
