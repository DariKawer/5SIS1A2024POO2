/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;
/**
 *
 * @author ilove
 */
import Modelo.Usuario;
import Modelo.Mensaje;
import Controlador.AccionesUsuario;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

public class iniciarUsuario extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            String email = request.getParameter("email");
            String password = request.getParameter("pass");

            // Obtener correo del usuario de la base de datos
            Usuario user = AccionesUsuario.buscarEmail(email);

            if (user == null) {
                // Correo no encontrado
                Mensaje mensaje = new Mensaje("El correo electrónico no se encuentra registrado. Intenta de nuevo.");
                request.setAttribute("m",mensaje);
                RequestDispatcher dispatcher = request.getRequestDispatcher("incorrecto.jsp");
                dispatcher.forward(request, response);
                //response.sendRedirect("incorrecto.jsp");
                System.out.println("Correo incorrecto");
            } else if (!password.equals(user.getPass_usu())) {
                // Contraseña incorrecta
                Mensaje mensaje = new Mensaje("Contraseña incorrecta. Intenta de nuevo.");
                request.setAttribute("m",mensaje);
                RequestDispatcher dispatcher = request.getRequestDispatcher("incorrecto.jsp");
                dispatcher.forward(request, response);
                //response.sendRedirect("incorrecto.jsp");
                System.out.println("Contraseña incorrecta");
            } else {
                // Contraseña correcta
                response.sendRedirect("inicio.jsp");
                System.out.println("Correo y contrasena correctas");
            }
        }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
