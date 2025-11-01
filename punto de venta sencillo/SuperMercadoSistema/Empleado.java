package SuperMercadoSistema;


public class Empleado {
    private int ID;
    private String nombre;
    private String puesto;
    
    public Empleado(int iD, String nombre, String puesto) {
        ID = iD;
        this.nombre = nombre;
        this.puesto = puesto;
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Empleado |ID: " + ID + ", Nombre:" + nombre + ", puesto:" + puesto + "|";
    }



}
