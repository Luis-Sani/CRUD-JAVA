package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Conexion {

    Connection con;

    public Connection getConnection() {
        try {
            String myDb = "jdbc:mysql://localhost:3308/proyectop1?serverTimezone=UTC";
            con = DriverManager.getConnection(myDb, "root", "");
            return con;
        } catch (SQLException e) {
            System.out.println(e.toString ());
        }
        return null;
    }



}


