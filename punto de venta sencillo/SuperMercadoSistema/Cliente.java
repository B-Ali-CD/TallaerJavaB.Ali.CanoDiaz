package SuperMercadoSistema;

public class Cliente {
    private String nombre;
    private Integer ID;
    private String tipo;

    public Cliente(String nombre, Integer ID, String tipo) {
        this.nombre = nombre;
        this.ID = ID;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getID() {
        return ID;
    }

    public String getTipo() {
        return tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Cliente [Cliente: " + nombre + " ID: " + ID + ", tipo:" + tipo + "]";
    }

    
    
}
