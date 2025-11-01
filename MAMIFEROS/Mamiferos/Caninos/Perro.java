package Mamiferos.Caninos;

public class Perro extends Canino{

    private int fuerzaMordidaPsi;
    

    public Perro(String habitat, double altura, double largo, double peso, String nombreCientifico,
                String color, double tamColmillos, int fuerzaMordidaPsi) {
        super(habitat, altura, largo, peso, nombreCientifico, color, tamColmillos);
        this.fuerzaMordidaPsi = fuerzaMordidaPsi;

    }

    public int getFuerzaMordidaPsi() {
        return fuerzaMordidaPsi;
    }
    public void setFuerzaMordidaPsi(int fuerzaMordidaPsi) {
        this.fuerzaMordidaPsi = fuerzaMordidaPsi;
    }

    @Override
    public String comer(){
        return "Su dieta principal se compone de presas vivas, generalmente de tamaño mediano, también son carroñeros, consumiendo los restos de animales muertos, ya que estos poseen una mordida fuerte de " + fuerzaMordidaPsi + " PSI." + "y unos colmillos de " + tamanioColmillos + " cm.";
    }

    @Override
    public String dormir(){
        return "Eligen lugares seguros, a menudo en el centro de su territorio, con sombra o resguardo de las inclemencias del tiempo, pueden usar madrigueras abandonadas o áreas con vegetación espesa. ";

    }

    @Override
    public String correr(){
        return "Pueden alcanzar velocidades de hasta 55 km/h en distancias largas. ";

    }


    @Override
    public String comunicarse(){
        return "Utilizan una combinación compleja de señales visuales, auditivas y químicas. ";

    }


    
    
}
