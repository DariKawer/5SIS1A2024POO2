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
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

public class guardarUsuario extends HttpServlet {
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String email, password, password_confirm;

            email = request.getParameter("email");
            password = request.getParameter("pass");
            password_confirm = request.getParameter("pass_confirm");

            //busco en la base de datos el email
            Usuario emailuser = AccionesUsuario.buscarEmail(email);

            //checo si esta vacio(se encontro en la dbase), sino lo esta mande a incorrecto.jsp
            if (emailuser != null) {
                Mensaje mensaje = new Mensaje("Ya se ha registrado este correo. Intenta de nuevo.");
                request.setAttribute("m",mensaje);
                RequestDispatcher dispatcher = request.getRequestDispatcher("incorrecto.jsp");
                dispatcher.forward(request, response);
                //response.sendRedirect("incorrecto.jsp");
                System.out.println("Es el mismo correo");
            } else {
                //confirmo que son contraseñas iguales
                if (!password.equals(password_confirm)) {
                    Mensaje mensaje = new Mensaje("No es la misma contraseña al confirmarla. Intenta de nuevo.");
                    request.setAttribute("m",mensaje);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("incorrecto.jsp");
                    dispatcher.forward(request, response);
                    //response.sendRedirect("incorrecto.jsp");
                    System.out.println("No es la misma contra");
                } else {
                    //hago una instancia del usuario
                    Usuario user = new Usuario();

                    user.setEmail_usu(email);
                    user.setPass_usu(password);

                    int estatus = AccionesUsuario.registrarUsuario(user);

                    if (estatus > 0) {
                        //que si lo registro
                        response.sendRedirect("registrado.jsp");
                        System.out.println("Bien registrado");
                    } else {
                        response.sendRedirect("error.jsp");
                        System.out.println("Nose q paso v:");
                    }
                }
            }     
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
