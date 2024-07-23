
package Modelo;


public class Libro {
    
    private int ISBN;
    private String titulo;
    private String autor;
    private double valorprestamo;

    public Libro() {
    }

    public Libro(int ISBN, String titulo, String autor, double valorprestamo) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.valorprestamo = valorprestamo;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getValorprestamo() {
        return valorprestamo;
    }

    public void setValorprestamo(double valorprestamo) {
        this.valorprestamo = valorprestamo;
    }
    
    
}
