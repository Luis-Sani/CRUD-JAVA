
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class PrestamoDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarPrestamos(Prestamo pr) {
        String sql = "INSERT INTO prestamo (numeroprestamo, fechaprestamo, descripcion, codigolibro, cantidad, fechaentrega) values (?, ?, ?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pr.getNuprestamo());
            ps.setString(2, pr.getFechap());
            ps.setString(3, pr.getDescripcion());
            ps.setInt(4, pr.getCodigoli());
            ps.setInt(5, pr.getCantidad());
            ps.setString(6, pr.getFechae());
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
    
    public void ConsultarISBN(JComboBox isbn){
        String sql ="SELECT ISBN FROM libros";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                isbn.addItem(rs.getInt("ISBN"));
                
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }
    
    public List ListarPrestamos() {
        List<Prestamo> Listarpr = new ArrayList();
        String sql = "SELECT * FROM prestamo";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Prestamo pr = new Prestamo();
                pr.setNuprestamo(rs.getInt("Numeroprestamo"));
                pr.setFechap(rs.getString("Fechaprestamo"));
                pr.setDescripcion(rs.getString("Descripcion"));
                pr.setCodigoli(rs.getInt("Codigolibro"));
                pr.setCantidad(rs.getInt("Cantidad"));
                pr.setFechae(rs.getString("Fechaentrega"));
                
                Listarpr.add(pr);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return Listarpr;
    }
    
    public boolean ElimarNprestamo(int nprestamo) {
        String sql = "DELETE FROM prestamo WHERE numeroprestamo=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, nprestamo);
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
    
    public boolean ModificarPrestamos(Prestamo pr){
        String sql = "UPDATE  prestamo SET fechaprestamo=?, descripcion=?, codigolibro=?, cantidad=?, fechaentrega=? WHERE numeroprestamo=?";
        try{
            ps = con.prepareStatement(sql);
            
            ps.setString(1, pr.getFechap());
            ps.setString(2, pr.getDescripcion());
            ps.setInt(3, pr.getCodigoli());
            ps.setInt(4, pr.getCantidad());
            ps.setString(5, pr.getFechae());
            ps.setInt(6, pr.getNuprestamo());
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
