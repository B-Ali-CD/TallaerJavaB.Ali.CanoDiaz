package Mamiferos.Caninos;

public class Lobo extends Canino{

    private int numCamada;
    private String especieLobo;

    

    public Lobo(String habitat, double altura, double largo, double peso, String nombreCientifico,
                String color, double tamColmillos, int numCamada, String especieLobo) {
        super(habitat, altura, largo, peso, nombreCientifico, color, tamColmillos);
        this.numCamada = numCamada;
        this.especieLobo = especieLobo;


    }

    

    public int getNumCamada() {
        return numCamada;
    }



    public void setNumCamada(int numCamada) {
        this.numCamada = numCamada;
    }



    public String getEspecieLobo() {
        return especieLobo;
    }



    public void setEspecieLobo(String especieLobo) {
        this.especieLobo = especieLobo;
    }



    @Override
    public String comer(){
        return "La especie de " + especieLobo + " son depredadores carnívoros cuya dieta principal consiste en grandes mamíferos ungulados, como alces, ciervos, bisontes y caribúes.";
    }

    @Override
    public String dormir(){
        return "Los lobos" + color + " duermen un promedio de 6 a 8 horas diarias, principalmente durante el día. ";

    }

    @Override
    public String correr(){
        return "Pueden trotar a una velocidad constante de aproximadamente 10 km/h durante periodos prolongados, y alcanzar una velocidad máxima de hasta 65 km/h.";

    }


    @Override
    public String comunicarse(){
        return "Se comunican mediante:\n" +
        "Aullidos: Se usan para fortalecer lazos sociales y anunciar su presencia o la ubicación de la manada a otros grupos. \n" +
        "Ladridos y Gruñidos: Se usan de forma más discreta para alertar sobre peligros o expresar nerviosismo si estos tienen camadas de " + numCamada + " cachorros. \n";

    }

    
}