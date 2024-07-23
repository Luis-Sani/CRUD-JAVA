
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class LibroDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarLibros(Libro li) {
        String sql = "INSERT INTO libros (ISBN, titulo, autor, valorprestamo) values (?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, li.getISBN());
            ps.setString(2, li.getTitulo());
            ps.setString(3, li.getAutor());
            ps.setDouble(4, li.getValorprestamo());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
    public void ConsultarAutor(JComboBox autor){
        String sql ="SELECT nombre, apellido FROM autores";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                autor.addItem(rs.getString("nombre") +" "+ rs.getString("apellido"));
                
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }
    
    public List ListarLibros() {
        List<Libro> ListarLi = new ArrayList();
        String sql = "SELECT * FROM libros";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Libro li = new Libro();
                li.setISBN(rs.getInt("ISBN"));
                li.setTitulo(rs.getString("titulo"));
                li.setAutor(rs.getString("autor"));
                li.setValorprestamo(rs.getDouble("valorprestamo"));
                ListarLi.add(li);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListarLi;
    }
    
    public boolean ElimarLibros(int ISBN) {
        String sql = "DELETE FROM libros WHERE ISBN=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, ISBN);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }

    }
    
    public boolean ModificarLibros(Libro li){
        String sql = "UPDATE  libros SET titulo=?, autor=?, valorprestamo=? WHERE ISBN=?";
        try{
            ps = con.prepareStatement(sql);
            
            ps.setString(1, li.getTitulo());
            ps.setString(2, li.getAutor());
            ps.setDouble(3, li.getValorprestamo());
            ps.setInt(4, li.getISBN());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
    }
    
}
