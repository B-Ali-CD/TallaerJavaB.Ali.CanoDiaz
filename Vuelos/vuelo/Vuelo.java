package vuelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Vuelo {
    private String nombre;
    private String origen;
    private String destino;
    private LocalDate fechaLlegada;
    private LocalTime horaLlegada;
    private int cantidadPasajeros;

    public Vuelo(String nombre, String origen, String destino, LocalDate fechaLlegada, LocalTime horaLlegada, int cantidadPasajeros) {
        this.nombre = nombre;
        this.origen = origen;
        this.destino = destino;
        this.fechaLlegada = fechaLlegada;
        this.horaLlegada = horaLlegada;
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public String getNombre() { return nombre; }
    public String getOrigen() { return origen; }
    public String getDestino() { return destino; }
    public LocalDate getFechaLlegada() { return fechaLlegada; }
    public LocalTime getHoraLlegada() { return horaLlegada; }
    public int getCantidadPasajeros() { return cantidadPasajeros; }

    public String getFechaHoraFormateada() {
        LocalDateTime llegada = LocalDateTime.of(fechaLlegada, horaLlegada);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss yyyy", Locale.ENGLISH);
        return llegada.format(formato);
    }

    @Override
    public String toString() {
        return nombre + ": " + origen + " → " + destino + ", llega el " + getFechaHoraFormateada()
                + " con " + cantidadPasajeros + " pasajeros";
    }
}

