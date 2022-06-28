/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CategoriaDAO;
import DAO.CategoriaDAOImplementar;
import Model.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
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
public class Categorias extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void listaCategorias(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        //Crear instancia a CategoriaDAO
        CategoriaDAO categoria = new CategoriaDAOImplementar();
        //Crear instancia de sesión; se le da true para crear la sesión
        HttpSession sesion = request.getSession(true);
        sesion.setAttribute("lista", categoria.Listar()); //Lista es el nombre de la sesión
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Categorias/listarCategorias.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void eliminarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        
        CategoriaDAO categoria = new CategoriaDAOImplementar();
        Categoria borrarCategoria = new Categoria();
        
        HttpSession sesion = request.getSession(true);
        System.out.println(request.getParameter("id_categoria_eliminar"));
        sesion.setAttribute("eliminar", categoria.borrarCat(Integer.parseInt(request.getParameter("id_categoria_eliminar"))));
        sesion.setAttribute("lista", categoria.Listar());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Categorias/listarCategorias.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Categorias</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Categorias at " + request.getContextPath() + "</h1>");
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
        System.out.println("DOGET " + request.getParameter("opcion"));
        String parametro = request.getParameter("opcion");
        if(parametro.equals("crear")){
            String pagina = "/Vistas-Categorias/crearCategoria.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
        }else if(parametro.equals("eliminar")){
            String pagina = "/Vistas-Categorias/listarCategoria.jsp";
            this.eliminarCategoria(request, response);
            
            /*RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);*/
        }else{
            this.listaCategorias(request, response);
        }
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
        
        System.out.println("DOPOST " + request.getParameter("opcion"));
        if(request.getParameter("opcion").equals("actualizar")){
            String pagina = "/Vistas-Categorias/listarCategoria.jsp";
            //this.actualizarCategoria(request, response);
            
            /*RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);*/
        }else{
            Categoria categoria = new Categoria();
            //Se efectua el casting o conversión de datos porque lo ingresado en el formulario es texto
            categoria.setId_categoria(Integer.parseInt(request.getParameter("id_categoria")));
            categoria.setNom_categoria(request.getParameter("txtNomCategoria"));
            categoria.setEstado_categoria(Integer.parseInt(request.getParameter("txtEstadoCategoria")));

            CategoriaDAO guardarCategoria = new CategoriaDAOImplementar();
            guardarCategoria.guardarCat(categoria);
            this.listaCategorias(request, response);
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
