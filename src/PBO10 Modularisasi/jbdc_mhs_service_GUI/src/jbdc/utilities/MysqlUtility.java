/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jbdc.utilities;

import java.sql.*;
/**
 *
 * @author Taki
 */
public class MysqlUtility {
    public static Connection koneksi;
    
    public static Connection getConnection() {
        if (koneksi == null) {
            try {
                Class.forName("com.mysql.jbdc.Driver");
                String url = "jbdc:mysql://localhost:3306/pbo";
                String user = "root";
                String password = "taki157";
                koneksi = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException cne){
                System.out.println("Gagal load driver : " + cne.getMessage());
            } catch (SQLException sqle) {
                System.out.println("Gagal koneksi : " + sqle.getMessage());
            }
        }
        return koneksi;
    }
}
