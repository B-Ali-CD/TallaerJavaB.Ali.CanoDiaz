package test;

import java.util.ArrayList;
import java.util.Scanner;

import persona.Persona;
import cliente.Cliente;
import empleado.Empleados;
import empleado.Gerente;

public class TestMain {

    private static ArrayList<Persona> personas = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Crear Persona");
            System.out.println("2. Listar Personas");
            System.out.println("3. Gestionar Persona");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: crearPersona(); break;
                case 2: listarPersonas(); break;
                case 3: gestionarPersona(); break;
                case 4: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    private static void crearPersona() {
        System.out.println("\n--- Crear Persona ---");
        System.out.println("1. Cliente");
        System.out.println("2. Empleado");
        System.out.println("3. Gerente");
        System.out.print("Elige una opción: ");
        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Número Fiscal: ");
        String fiscal = sc.nextLine();
        System.out.print("Dirección: ");
        String direccion = sc.nextLine();

        switch (tipo) {
            case 1:
                System.out.print("ID Cliente: ");
                int clienteId = sc.nextInt();
                personas.add(new Cliente(nombre, apellido, fiscal, direccion, clienteId));
                break;

            case 2:
                System.out.print("Remuneración: ");
                double remuneracion = sc.nextDouble();
                System.out.print("Empleado ID: ");
                int empleadoId = sc.nextInt();
                personas.add(new Empleados(nombre, apellido, fiscal, direccion, remuneracion, empleadoId));
                break;

            case 3:
                System.out.print("Remuneración: ");
                double remuneracionG = sc.nextDouble();
                System.out.print("Empleado ID: ");
                int empleadoIdG = sc.nextInt();
                System.out.print("Presupuesto: ");
                double presupuesto = sc.nextDouble();
                personas.add(new Gerente(nombre, apellido, fiscal, direccion, remuneracionG, empleadoIdG, presupuesto));
                break;

            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void listarPersonas() {
        System.out.println("\n--- Lista de Personas ---");
        if (personas.isEmpty()) {
            System.out.println("No hay personas registradas.");
        } else {
            for (int i = 1; i < personas.size(); i++) {
                System.out.println(i + ". " + personas.get(i).getNombre() + " " + personas.get(i).getApellido()
                        + " (" + personas.get(i).getClass().getSimpleName() + ")");
            }
        }
    }

    private static void gestionarPersona() {
        listarPersonas();
        if (personas.isEmpty()) return;

        System.out.print("Selecciona índice de persona: ");
        int idx = sc.nextInt();
        sc.nextLine();

        if (idx < 0 || idx >= personas.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        Persona persona = personas.get(idx);
        System.out.println("\n--- Gestionando: ---");
        System.out.println(persona);

        if (persona instanceof Cliente) {
            System.out.println("Es un Cliente. No hay acciones disponibles.");
        } else if (persona instanceof Empleados && !(persona instanceof Gerente)) {
            gestionarEmpleado((Empleados) persona);
        } else if (persona instanceof Gerente) {
            gestionarGerente((Gerente) persona);
        }
    }

    private static void gestionarEmpleado(Empleados empleado) {
        System.out.println("\nOpciones para Empleado:");
        System.out.println("1. Aumentar remuneración");
        System.out.println("2. Salir");
        System.out.print("Elige: ");
        int op = sc.nextInt();

        if (op == 1) {
            System.out.print("Porcentaje de aumento: ");
            int porcentaje = sc.nextInt();
            empleado.aumentarRemuneracion(porcentaje);
            System.out.println("Datos actualizados:");
            System.out.println(empleado);
        }
    }

    private static void gestionarGerente(Gerente gerente) {
        int op;
        do {
            System.out.println("\nOpciones para Gerente:");
            System.out.println("1. Aumentar su remuneración");
            System.out.println("2. Modificar presupuesto");
            System.out.println("3. Aumentar remuneración de un empleado específico");
            System.out.println("4. Salir");
            System.out.print("Elige: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.print("Porcentaje de aumento: ");
                    int p1 = sc.nextInt();
                    gerente.aumentarRemuneracion(p1);
                    System.out.println("Datos actualizados:");
                    System.out.println(gerente);
                    break;

                case 2:
                    System.out.print("Nuevo presupuesto: ");
                    double nuevoPres = sc.nextDouble();
                    gerente.setPresupuesto(nuevoPres);
                    System.out.println("Datos actualizados:");
                    System.out.println(gerente);
                    break;

                case 3:
                    listarPersonas();
                    System.out.print("Selecciona índice de empleado: ");
                    int idx = sc.nextInt();
                    if (idx >= 0 && idx < personas.size() && personas.get(idx) instanceof Empleados && !(personas.get(idx) instanceof Gerente)) {
                        Empleados emp = (Empleados) personas.get(idx);
                        System.out.print("Porcentaje de aumento: ");
                        int p2 = sc.nextInt();
                        emp.aumentarRemuneracion(p2);
                        System.out.println("Datos actualizados:");
                        System.out.println(emp);
                    } else {
                        System.out.println("No seleccionaste un empleado válido.");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del menú de Gerente.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (op != 4);
    }
}
