package Mamiferos.Felinos;

public class Guepardo extends Felino{

    public Guepardo(String habitat, double altura, double largo, double peso, String nombreCientifico,
                double tamanioGarras, int velocidad){ 

        super(habitat, altura, largo, peso, nombreCientifico, tamanioGarras, velocidad);
        
        } 
    @Override
    public String comer() {
        return "Los guepardos carnívoros y cazan principalmente ungulados de tamaño pequeño a mediano, como gacelas, impalas y liebres.";
    }

    @Override
    public String dormir() {
        return "Los guepardos son grandes dormilones, como la mayoría de los felinos. Pueden dormir alrededor de 12 horas al día. Pasan una parte significativa de su tiempo descansando para conservar energía, especialmente después de una persecución de alta intensidad.";
    }

    @Override
    public String correr() {
        return "El guepardo corre a una velocidad de " + velocidad + " km/h por cortas distancias.";
    }

    @Override
    public String comunicarse() {
        return "Los guepardos a diferencia de los grandes felinos que rugen (como leones o tigres), los guepardos emiten una variedad de gorjeos, ronroneos y chillidos agudos para comunicarse entre sí.";
    }

}
