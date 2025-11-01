package Mamiferos.Felinos;


public class Tigre extends Felino{

    private String especieTigre;
    

    public Tigre(String habitat, double altura, double largo, double peso, String nombreCientifico,
                double tamanioGarras, int velocidad, String especieTigre){ 
        super(habitat, altura, largo, peso, nombreCientifico, tamanioGarras, velocidad);
        this.especieTigre = especieTigre;
        }

    public String getEspecieTigre(){
        return especieTigre;
    }
    public void setEspecieTigre(String especieTigre){
        this.especieTigre = especieTigre;
    }   
    
    public String comer() {
        return "Su dieta se compone principalmente de grandes ungulados como jabalíes, diferentes especies de ciervos (sambar, chital), búfalos de agua y, ocasionalmente, monos, pavos reales y puercoespines.";
    }

    @Override
    public String dormir() {
        return "El tigre duerme entre 15 y 16 horas al día.";
    }

    @Override
    public String correr() {
        return "El tigre corre a una velocidad de " + velocidad + " km/h por cortas distancias.";
    }

    @Override
    public String comunicarse() {
        return "Utilizan rugidos, gruñidos, resoplidos (un sonido de huf-huf-huf para expresar calma o llamar a otros tigres) y otros sonidos. ";
    }

}
