package test;
import Mamiferos.Mamifero;
import Mamiferos.Felinos.Leon;
import Mamiferos.Felinos.Tigre;
import Mamiferos.Felinos.Guepardo;
import Mamiferos.Caninos.Lobo;
import Mamiferos.Caninos.Perro;

public class testMain {
    public static void main(String[] args) {
        Mamifero[] mamiferos = new Mamifero[5];

        mamiferos[0] = new Leon(
            "Sabana africana", 1.2, 2.4, 190.0, "Panthera leo",
            6.5, 80, 10, 114.0
        );

        mamiferos[1] = new Tigre(
            "Selva asiática", 1.1, 3.1, 220.0, "Panthera tigris",
            7.0, 60, "Bengala"
        );

        mamiferos[2] = new Guepardo(
            "Llanuras africanas", 0.9, 2.0, 72.0, "Acinonyx jubatus",
            5.0, 120
        );

        mamiferos[3] = new Lobo(
            "Bosques fríos", 0.8, 1.5, 60.0, "Canis lupus",
            "Gris", 4.0, 5, "Lobo gris"
        );

        mamiferos[4] = new Perro(
            "Sabana", 0.7, 1.1, 35.0, "Lycaon pictus",
            "Moteado", 3.2, 317
        );

        for (Mamifero m : mamiferos) {
            System.out.println("------------------------------------");
            System.out.println("Clase: " + m.getClass().getSimpleName());
            System.out.println("Hábitat: " + m.habitat);
            System.out.println("Altura: " + m.altura);
            System.out.println("Peso: " + m.peso);
            System.out.println("Nombre científico: " + m.nombreCientifico);
            System.out.println(m.comer());
            System.out.println(m.dormir());
            System.out.println(m.correr());
            System.out.println(m.comunicarse());
        }
    }
}
    

