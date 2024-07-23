
package Modelo;



public class Prestamo {
    private int nuprestamo;
    private String fechap;
    private String descripcion;
    private int codigoli;
    private int cantidad;
    private String Fechae;

    public Prestamo() {
    }

    public Prestamo(int nuprestamo, String fechap, String descripcion, int codigoli, int cantidad, String Fechae) {
        this.nuprestamo = nuprestamo;
        this.fechap = fechap;
        this.descripcion = descripcion;
        this.codigoli = codigoli;
        this.cantidad = cantidad;
        this.Fechae = Fechae;
    }

    public int getNuprestamo() {
        return nuprestamo;
    }

    public void setNuprestamo(int nuprestamo) {
        this.nuprestamo = nuprestamo;
    }

    public String getFechap() {
        return fechap;
    }

    public void setFechap(String fechap) {
        this.fechap = fechap;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodigoli() {
        return codigoli;
    }

    public void setCodigoli(int codigoli) {
        this.codigoli = codigoli;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFechae() {
        return Fechae;
    }

    public void setFechae(String Fechae) {
        this.Fechae = Fechae;
    }
    
    

   
    
    
}
