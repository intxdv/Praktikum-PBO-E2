/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jbdc.service;

import java.sql.*;
import java.util.*;
import jbdc.model.*;
import static jbdc.utilities.MysqlUtility.getConnection;

/**
 *
 * @author Taki
 */
public class MysqlMahasiswaService {
    Connection koneksi = null;
    
    public MysqlMahasiswaService() {
        koneksi = getConnection();
    }
    
    public Mahasiswa makeMhsObject() {
        return new Mahasiswa();
    }
    
    public void add(Mahasiswa mhs) throws SQLException {
        String query = "INSERT INTO mahasiswa (id, nama) VALUES ("
                + mhs.getId()
                + ", '" + mhs.getNama() + "')";
        try {
            Statement s = koneksi.createStatement();
            s.executeUpdate(query);
            System.out.println("berhasil insert");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw sqle;
        }
    }
    
    public void update(Mahasiswa mhs) throws SQLException {
        String query = "UPDATE mahasiswa SET "
                + "nama = '"  + mhs.getNama() + "' "
                + "WHERE id = " + mhs.getId();
        try {
            Statement s = koneksi.createStatement();
            s.executeUpdate(query);
            System.out.println("berhasil update");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw sqle;
        }
    }
    
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM mahasiswa WHERE id = " + id;
        try {
            Statement s = koneksi.createStatement();
            s.executeUpdate(query);
            System.out.println("berhasil delete");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw sqle;
        }
    }
    
    public Mahasiswa getById(int id) throws SQLException {
        Mahasiswa mhs = new Mahasiswa();
        String query = "SELECT * FROM mahasiswa WHERE id = " + id;
        try {
            Statement s = koneksi.createStatement();
            ResultSet rs = s.executeQuery(query);
            if (rs.next()) {
              mhs.setId(rs.getInt("id"));
              mhs.setNama(rs.getString("nama"));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw sqle;
        }
        return mhs;
    }
    
    public List<Mahasiswa> getAll() throws SQLException {
        List<Mahasiswa> mahasiswaList = new ArrayList<>();
        String query = "SELECT * FROM mahasiswa";
        try {
            Statement s = koneksi.createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
              Mahasiswa mhs = new Mahasiswa();
              mhs.setId(rs.getInt("id"));
              mhs.setNama(rs.getString("nama"));
              mahasiswaList.add(mhs);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw sqle;
        }
        return mahasiswaList;
    }
}
