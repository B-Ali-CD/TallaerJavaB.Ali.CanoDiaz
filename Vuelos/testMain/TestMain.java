package testMain;

import vuelo.Vuelo;
import java.util.*;
import java.time.*;

public class TestMain {

    public static void main(String[] args) {
        List<Vuelo> listaVuelos = new ArrayList<>();

        listaVuelos.add(new Vuelo("AAL 933", "New York", "Santiago", LocalDate.of(2021,8,29), LocalTime.of(5,39), 62));
        listaVuelos.add(new Vuelo("LAT 755", "Sao Paulo", "Santiago", LocalDate.of(2021,8,31), LocalTime.of(4,45), 47));
        listaVuelos.add(new Vuelo("SKU 621", "Rio De Janeiro", "Santiago", LocalDate.of(2021,8,30), LocalTime.of(16,0), 52));
        listaVuelos.add(new Vuelo("DAL 147", "Atlanta", "Santiago", LocalDate.of(2021,8,29), LocalTime.of(13,22), 59));
        listaVuelos.add(new Vuelo("AVA 241", "Bogota", "Santiago", LocalDate.of(2021,8,31), LocalTime.of(14,5), 25));
        listaVuelos.add(new Vuelo("AMX 10", "Mexico City", "Santiago", LocalDate.of(2021,8,31), LocalTime.of(5,20), 29));
        listaVuelos.add(new Vuelo("IBE 6833", "London", "Santiago", LocalDate.of(2021,8,30), LocalTime.of(8,45), 55));
        listaVuelos.add(new Vuelo("LAT 2479", "Frankfurt", "Santiago", LocalDate.of(2021,8,29), LocalTime.of(7,41), 51));
        listaVuelos.add(new Vuelo("SKU 803", "Lima", "Santiago", LocalDate.of(2021,8,30), LocalTime.of(10,35), 48));
        listaVuelos.add(new Vuelo("LAT 533", "Los Angeles", "Santiago", LocalDate.of(2021,8,29), LocalTime.of(9,14), 59));
        listaVuelos.add(new Vuelo("LAT 1447", "Guayaquil", "Santiago", LocalDate.of(2021,8,31), LocalTime.of(8,33), 31));
        listaVuelos.add(new Vuelo("CMP 111", "Panama City", "Santiago", LocalDate.of(2021,8,31), LocalTime.of(15,15), 29));
        listaVuelos.add(new Vuelo("LAT 705", "Madrid", "Santiago", LocalDate.of(2021,8,30), LocalTime.of(8,14), 47));
        listaVuelos.add(new Vuelo("AAL 957", "Miami", "Santiago", LocalDate.of(2021,8,29), LocalTime.of(22,53), 60));
        listaVuelos.add(new Vuelo("ARG 5091", "Buenos Aires", "Santiago", LocalDate.of(2021,8,31), LocalTime.of(9,57), 32));
        listaVuelos.add(new Vuelo("LAT 1283", "Cancun", "Santiago", LocalDate.of(2021,8,31), LocalTime.of(4,0), 35));
        listaVuelos.add(new Vuelo("LAT 579", "Barcelona", "Santiago", LocalDate.of(2021,8,29), LocalTime.of(7,45), 61));
        listaVuelos.add(new Vuelo("AAL 945", "Dallas-Fort Worth", "Santiago", LocalDate.of(2021,8,30), LocalTime.of(7,12), 58));
        listaVuelos.add(new Vuelo("LAT 501", "Paris", "Santiago", LocalDate.of(2021,8,29), LocalTime.of(18,29), 49));
        listaVuelos.add(new Vuelo("LAT 405", "Montevideo", "Santiago", LocalDate.of(2021,8,30), LocalTime.of(15,45), 39));

        // Ordenar por fecha + hora
        listaVuelos.sort(Comparator.comparing(Vuelo::getFechaLlegada).thenComparing(Vuelo::getHoraLlegada));

        System.out.println("1. Listado ordenado por llegada ascendente:");
        listaVuelos.forEach(System.out::println);

        // Último vuelo en llegar
        System.out.println(" ");
        Vuelo ultimo = listaVuelos.get(listaVuelos.size() - 1);
        System.out.println("\n2. El último vuelo en llegar es " + ultimo.getNombre() + ": " 
                + ultimo.getOrigen() + ", aterriza el " + ultimo.getFechaHoraFormateada());

        // Vuelo con menor número de pasajeros
        Vuelo menorPasajeros = Collections.min(listaVuelos, Comparator.comparing(Vuelo::getCantidadPasajeros));
        System.out.println("\n3. El vuelo con menor número de pasajeros es " + menorPasajeros.getNombre()
                + ": " + menorPasajeros.getOrigen() + ", con " + menorPasajeros.getCantidadPasajeros() + " pasajeros.\n");
    }
}
