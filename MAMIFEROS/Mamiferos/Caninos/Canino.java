package Mamiferos.Caninos;

import Mamiferos.Mamifero;

public abstract class Canino extends Mamifero {
    protected String color;
    protected double tamanioColmillos;

    public Canino(String habitat, Double altura, Double largo, double peso, String nombreCientifico,
        String color, double tamanioColmillos) {
        super(habitat, altura, largo, peso, nombreCientifico);
        this.color = color;
        this.tamanioColmillos = tamanioColmillos;
    
    
    }

    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }  
    
    public double getTamanioColmillos() {
        return tamanioColmillos;
    }

    public void setTamanioColmillos(double tamanioColmillos) {
        this.tamanioColmillos = tamanioColmillos;
    }

}
