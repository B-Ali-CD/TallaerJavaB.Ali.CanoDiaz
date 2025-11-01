package Mamiferos.Felinos;


public class Leon extends Felino{

    private int numManada;
    private double potenciaRugidoDecibel;

    public Leon(String habitat, double altura, double largo, double peso, String nombreCientifico,
                double tamanioGarras, int velocidad, int numManada, double potenciaRugidoDecibel) {
        super(habitat, altura, largo, peso, nombreCientifico, tamanioGarras, velocidad);
        this.numManada = numManada;
        this.potenciaRugidoDecibel = potenciaRugidoDecibel;
    }

    public int getNumManada(){
        return numManada;
    }

    public void setNumManada(int numManada){
        this.numManada = numManada;
    }
    
    public String comer() {
        return "El león caza en manadas de " + numManada+ " miembros" + " y se alimenta de grandes presas, " + " ya que cuentan con garras de " + tamanioGarras + " cm." ;
    }

    @Override
    public String dormir() {
        return "El león duerme gran parte del día bajo la sombra.";
    }

    @Override
    public String correr() {
        return "El león corre a una velocidad de " + velocidad + " km/h por cortas distancias.";
    }

    @Override
    public String comunicarse() {
        return "El león ruge con una potencia de " + potenciaRugidoDecibel + " decibelios.";
    }
}
