package SuperMercadoSistema;
import SuperMercadoSistema.Cliente;
import SuperMercadoSistema.Empleado;

public class Venta {
    private int iDventa;
    private Double total;
    public Venta(int iDventa, Double total) {
        this.iDventa = iDventa;
        this.total = total;
    }
    public int getiDventa() {
        return iDventa;
    }
    public void setiDventa(int iDventa) {
        this.iDventa = iDventa;
    }
    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }
    @Override
    public String toString() {
        return "|iD venta: " + iDventa + ", total= $" + total + "|";
    }

    
}
