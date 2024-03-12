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
import Modelo.Usuario;

public class AccionesUsuario {
    //primero vamos a registrar un usuario
    public static int registrarUsuario(Usuario user){
        int estatus = 0;
        
        try{
            //establezco la conexion
            Connection con = Conexion.getConection();
            String q = "insert into usuario(email_usu, pass_usu) values (?,?)";
                        
            //el cual es preparar la sentencia
            PreparedStatement ps = con.prepareStatement(q);
            
            //obtener cada uno de los elementos del objeto
            ps.setString(1, user.getEmail_usu());
            ps.setString(2, user.getPass_usu());
            
            //ejecuto la sentencia
            estatus = ps.executeUpdate();
            System.out.println("Usuario registrado con exito");
            con.close();
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            System.out.println("No se pudo registrar el usuario");
        }
        return estatus;
    }
    
    //buscar usuario por correo
    public static Usuario buscarEmail(String email) {
        Usuario user = null;
        //Usuario user = new Usuario();
        try {
            Connection con = Conexion.getConection();
            String q = "select * from usuario where email_usu = ?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                user = new Usuario();
                user.setIdUsuario(rs.getInt(1));
                user.setEmail_usu(rs.getString(2));
                user.setPass_usu(rs.getString(3));
                System.out.println("Se encontro al usuario");
            } else {
                System.out.println("No se encontro el usuario");
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return user;
    }
}