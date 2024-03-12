/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
/**
 *
 * @author ilove
 */
public class Usuario {
    private int idUsuario;
    private String email_usu, pass_usu;
    
    public Usuario() {   
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String getEmail_usu() {
        return email_usu;
    }
    
    public void setEmail_usu(String email_usu) {
        this.email_usu = email_usu;
    }
    
    public String getPass_usu() {
        return pass_usu;
    }
    
    public void setPass_usu(String pass_usu) {
        this.pass_usu = pass_usu;
    }    
}