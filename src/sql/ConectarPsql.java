/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro Montañez
 */
public class ConectarPsql {
    
    public static void main(String[] args) throws Exception{
       Connection conn=null;
     try{
        
         
         Class.forName("org.postgresql.Driver");
        
        String url = "jdbc:postgresql://localhost:5432/SARH";
        
        conn = DriverManager.getConnection(url, "postgres", "sa");
        
        PreparedStatement stmt = null;
        
        stmt = conn.prepareStatement("select * from ingreso");
        
        ResultSet rs = stmt.executeQuery();

       while (rs.next())
        {
        System.out.println(rs.getString("nombre"));
        }
         
         
                  
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(conexionsql.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
}
