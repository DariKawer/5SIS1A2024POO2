/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author ilove
 */
import java.sql.*;
import Modelo.Alumno;

public class AccionesAlumno {
    
    //primero vamos a registrar a un alumno
    public static int registrarAlumno(Alumno alu) {
        int estatus = 0;
        
        try {
            //establezco la conexion
            Connection con = Conexion.getConection();
            String q = "insert into alumno(nom_alu, appat_alu,"
                        + "apmat_alu, edad_alu) values (?, ?, ?, ?)";
            
            //el cual es preparar la setencia
            PreparedStatement ps = con.prepareStatement(q);
            
            //obtener cada uno de los elementps del objeto
            ps.setString(1, alu.getNom_alu());
            ps.setString(2, alu.getAppat_alu());
            ps.setString(3, alu.getApmat_alu());
            ps.setString(4, alu.getEdad_alu());
            
            //ejecuto la sentencia
            estatus = ps.executeUpdate();
            System.out.println("Alumno registrado con exito");
            con.close();
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("No se puede registrar el alumno");
        }
        return estatus;
    }
}
