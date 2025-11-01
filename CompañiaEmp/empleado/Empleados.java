package empleado;

// Clase Empleado
public class Empleados extends persona.Persona {
    private double remuneracion;
    private int empleadoId;

    public Empleados(String nombre, String apellido, String numeroFiscal, String direccion,
                    double remuneracion, int empleadoId) {
        super(nombre, apellido, numeroFiscal, direccion);
        this.remuneracion = remuneracion;
        this.empleadoId = empleadoId;
    }

    // Getters
    public double getRemuneracion() { return remuneracion; }
    public int getEmpleadoId() { return empleadoId; }

    // Método para aumentar remuneración
    public void aumentarRemuneracion(int porcentaje) {
        remuneracion += remuneracion * porcentaje / 100.0;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nEmpleado ID: " + empleadoId +
               "\nRemuneración: $" + remuneracion;
    }
}
