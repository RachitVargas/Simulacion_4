package Simulacion_4.persona;

import java.io.Serializable;

public class persona implements Serializable {

    private String nombre;
    private int edad;
    private String fecha_nacimiento;
    private int altura;
    private int peso;
    private String nacionalidad;
    private String club;
    private int numero_camiseta;
    private int indice;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public int getNumero_camiseta() {
        return numero_camiseta;
    }

    public void setNumero_camiseta(int numero_camiseta) {
        this.numero_camiseta = numero_camiseta;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "Nombre='" + getNombre() + '\'' +
                ", edad=" + getEdad() + '\'' +
                ", fecha nacimiento='" + getFecha_nacimiento() + '\'' +
                ", altura='" + getAltura() + '\'' +
                ", peso='" + getPeso() + '\'' +
                ", nacionalidad=" + getNacionalidad() + '\'' +
                ", club=" + getClub() + '\'' +
                ", numero camiseta=" + getNumero_camiseta() + '\'' +
                '}';
    }

}
