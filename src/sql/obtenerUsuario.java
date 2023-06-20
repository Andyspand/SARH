/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro Montañez
 */
public class obtenerUsuario {
     Connection conn=null;
    public String devolver(String usuario,String pass) throws SQLException{
     try{
        
         
         Class.forName("org.postgresql.Driver");
        String V_pass=null;
        String rpt=null;
        String url = "jdbc:postgresql://localhost:5432/SARH";
        String cadena="select password from ingreso where codUser=" + usuario;
        conn = DriverManager.getConnection(url, "postgres", "sa");
        
        PreparedStatement stmt = null;
        
        stmt = conn.prepareStatement("select * from ingreso");
        
        ResultSet rs = stmt.executeQuery();

       while (rs.next())
        {
        V_pass=rs.getString("password");
        }
         
        if (V_pass==pass) {
            rpt= "S";
        }else{
            rpt= "n";
        }
         return   rpt;
                  
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(conexionsql.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
    }
}
