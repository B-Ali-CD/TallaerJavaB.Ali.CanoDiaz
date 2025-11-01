package cliente;


// Clase Cliente
public class Cliente extends persona.Persona {
    private int clienteId;

    public Cliente(String nombre, String apellido, String numeroFiscal, String direccion,
                   int clienteId) {
        super(nombre, apellido, numeroFiscal, direccion);
        this.clienteId = clienteId;
    }

    // Getter
    public int getClienteId() { return clienteId; }

    @Override
    public String toString() {
        return super.toString() +
               "\nCliente ID: " + clienteId;
    }
}