package Modelo;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class AutorDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean RegistrarAutores(Autor au) {
        String sql = "INSERT INTO autores (codigo, nombre, apellido) values (?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, au.getCodigo());
            ps.setString(2, au.getNombre());
            ps.setString(3, au.getApellido());
            
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
    
    

    public List ListarAutores() {
        List<Autor> ListarAu = new ArrayList();
        String sql = "SELECT * FROM autores";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Autor au = new Autor();
                au.setCodigo(rs.getInt("codigo"));
                au.setNombre(rs.getString("nombre"));
                au.setApellido(rs.getString("apellido"));
                
                ListarAu.add(au);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListarAu;
    }

    public boolean ElimarAutores(int codigo) {
        String sql = "DELETE FROM autores WHERE codigo=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
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
    
    public boolean ModificarAutores(Autor au){
        String sql = "UPDATE  autores SET nombre=?, apellido=? WHERE codigo=?";
        try{
            ps = con.prepareStatement(sql);
            
            ps.setString(1, au.getNombre());
            ps.setString(2, au.getApellido());
            ps.setInt(3, au.getCodigo());
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
