package Mamiferos;

public abstract class  Mamifero {
    public String habitat;
    public Double altura;
    protected Double largo;
    public Double peso;
    public String nombreCientifico;


    public Mamifero(String habitat, Double altura, Double largo, Double peso, String nombreCientifico) {
        
        this.habitat = habitat;
        this.altura = altura;
        this.largo = largo;
        this.peso = peso;
        this.nombreCientifico = nombreCientifico;
    }

    

    public String getHabitat() {
        return habitat;
    }



    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }



    public Double getAltura() {
        return altura;
    }



    public void setAltura(Double altura) {
        this.altura = altura;
    }



    public Double getLargo() {
        return largo;
    }



    public void setLargo(Double largo) {
        this.largo = largo;
    }



    public Double getPeso() {
        return peso;
    }



    public void setPeso(Double peso) {
        this.peso = peso;
    }



    public String getNombreCientifico() {
        return nombreCientifico;
    }



    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }



    // Métodos abstractos (obligatorios de implementar en subclases)
    public abstract String comer();
    public abstract String dormir();
    public abstract String correr();
    public abstract String comunicarse();


}
