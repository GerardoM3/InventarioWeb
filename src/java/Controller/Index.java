/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UserDAO;
import DAO.UserDAOImplementar;
import Model.UserM;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ITCA
 */
public class Index extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Index</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Index at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //Si da error importar la librería correspondiente import javax.servlet.RequestDispatcher;
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Principal.jsp");
        dispatcher.forward(request, response);
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
        String dato_user_form = request.getParameter("txtuser");
        String dato_pass_form = request.getParameter("txtpass");
        
        UserDAO usuario = new UserDAOImplementar();
        
        ArrayList<UserM> users = new ArrayList();
        
        HttpSession var_sesion = request.getSession(true);
        
        users = usuario.startSession(dato_user_form, dato_pass_form);
        
        if(users.size()>0){
            String full_name = users.get(0).getNombre_u() + " " + users.get(0).getApellido_u();
            
            int tipo_user = users.get(0).getTipo();
            String name_user = users.get(0).getUsuario();
            String email_user = users.get(0).getCorreo_u();
            
            var_sesion.setAttribute("sessionNombres", full_name);
            
            var_sesion.setAttribute("sessionTipo", String.valueOf(tipo_user));
            var_sesion.setAttribute("sessionUsuario", name_user);
            var_sesion.setAttribute("sessionEmail", email_user);
            
            var_sesion.setAttribute("lista", users);
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Principal.jsp");
            dispatcher.forward(request, response);
        }else{
            response.setContentType("text/html;charset=UTF-8");
            try(PrintWriter out = response.getWriter()){
                String url = "index";
                out.println("<script>valor=confirm(\"Error. Usuario o Clave Incorrecto. " + "\\nNombre de Usuario: " + dato_user_form + "\\n\\nClic en aceptar para volver a intentarlo. \");valor;"
                + "if (valor==true){"
                + "location.href='" + url + "';"
                + "}else{"
                + "location.href='" + url + "';"
                + "}"
                + "</script>");
            }
        }
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
