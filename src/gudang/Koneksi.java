/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gudang;

/**
 *
 * @author Customer
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Koneksi {
   Connection con;
   Statement stm;
    
    public void config(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/gudang", "root", "");
            stm = con.createStatement();
        } 
        catch(Exception a){
            JOptionPane.showMessageDialog(null, "Koneksi Gagal "+a.getMessage());
        }
    }
}
 
