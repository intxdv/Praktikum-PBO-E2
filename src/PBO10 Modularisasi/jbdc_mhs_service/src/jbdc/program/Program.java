/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jbdc.program;

import java.sql.SQLException;
import jbdc.service.MysqlMahasiswaService;
import java.util.*;
import jbdc.model.Mahasiswa;

/**
 *
 * @author Taki
 */
public class Program {
    static MysqlMahasiswaService service = new MysqlMahasiswaService();
    public static void main(String[] args) throws SQLException {
        List<Mahasiswa> listMhs = new ArrayList<>();
        
        // insert
        System.out.println("===insert");
        Mahasiswa mhsAdd = new Mahasiswa(12, "Taki");
        service.add(mhsAdd);
        service.getAll();
        
        // update
//        System.out.println("==update");
//        Mahasiswa mhsUpdate = service.getById(12);
//        System.out.println("Akan diupdate data lama: " + mhsUpdate);
//        mhsUpdate.setNama("Syafiq");
//        System.out.println("dengan data baru: " + mhsUpdate);
//        service.update(mhsUpdate);
//        service.getAll();
//        
//        // delete
//        System.out.println("===delete");
//        System.out.println("akan didelete: " + service.getById(12));
//        service.delete(12);
//        service.getAll();
    }
}
