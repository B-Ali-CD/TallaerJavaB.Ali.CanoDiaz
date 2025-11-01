package Mamiferos.Felinos;

import Mamiferos.Mamifero;


public abstract class Felino extends Mamifero {
    protected double tamanioGarras;
    protected double velocidad;

    public Felino(String habitat, double altura, double largo, double peso, String nombreCientifico,
        double tamanioGarras, int velocidad) {
        super(habitat, altura, largo, peso, nombreCientifico);
        this.tamanioGarras = tamanioGarras;
        this.velocidad = velocidad;

    }

    public double getTamanioGarras() {
        return tamanioGarras;
    }   

    public void setTamanioGarras(double tamanioGarras) {
        this.tamanioGarras = tamanioGarras;
    }   

    public double getVelocidad() {
        return velocidad;
    }   

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    

}