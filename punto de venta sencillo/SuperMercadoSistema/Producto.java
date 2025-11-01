package SuperMercadoSistema;

public class Producto {
    private int ID;
    private String prod;
    private Double precio;
    private int stock;
    public Producto(int iD, String prod, Double precio, int stock) {
        ID = iD;
        this.prod = prod;
        this.precio = precio;
        this.stock = stock;
    }
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public String getProd() {
        return prod;
    }
    public void setProd(String prod) {
        this.prod = prod;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    @Override
    public String toString() {
        return "|ID=" + ID + ", producto: " + prod + ", precio: " + precio + ", stock: " + stock + "|";
    }

    
}
