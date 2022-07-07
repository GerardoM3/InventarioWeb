/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ProductoDAO;
import DAO.ProductoDAOImplementar;
import Model.Producto;
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
public class Productos extends HttpServlet {
    
    protected void listaProductos(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        //Crear instancia a CategoriaDAO
        ProductoDAO producto = new ProductoDAOImplementar();
        //Crear instancia de sesión; se le da true para crear la sesión
        HttpSession sesion = request.getSession(true);
        sesion.setAttribute("lista", producto.Listar()); //Lista es el nombre de la sesión
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Productos/listarProductos.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        
        ProductoDAO producto = new ProductoDAOImplementar();
        Producto borrarProducto = new Producto();
        
        HttpSession sesion = request.getSession(true);
        System.out.println(request.getParameter("id_producto_eliminar"));
        sesion.setAttribute("eliminar", producto.borrarProd(Integer.parseInt(request.getParameter("id_producto_eliminar"))));
        sesion.setAttribute("lista", producto.Listar());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Productos/listarProductos.jsp");
        dispatcher.forward(request, response);
    }

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
            out.println("<title>Servlet Productos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Productos at " + request.getContextPath() + "</h1>");
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
        System.out.println("DOGET: " + request.getParameter("opcion"));
        String parametro = request.getParameter("opcion");
        if(parametro.equals("crear")){
            String pagina = "/Vistas-Productos/crearProducto.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
        }else if(parametro.equals("editar")){
            String pagina = "/Vistas-Productos/actualizarProducto.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
        }else if(parametro.equals("eliminar")){
            String pagina = "/Vistas-Productos/listarCategoria.jsp";
            this.eliminarProducto(request, response);
        }else{
            this.listaProductos(request, response);
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
        if(request.getParameter("opcion").equals("editar")){
            try {
                String id_prod_edit = request.getParameter("id");
                String nom_prod_edit = request.getParameter("nombre");
                String stock_prod_edit = request.getParameter("stock");
                String precio_prod_edit = request.getParameter("precio");
                String U_M_edit = request.getParameter("unidad_de_medida");
                String estado_prod_edit = request.getParameter("estado");
                String IdC_prod_edit = request.getParameter("id_categoria");
                
                System.out.println(id_prod_edit);
                System.out.println(nom_prod_edit);
                System.out.println(stock_prod_edit);
                System.out.println(precio_prod_edit);
                System.out.println(U_M_edit);
                System.out.println(estado_prod_edit);
                System.out.println(IdC_prod_edit);
                
                ProductoDAO producto = new ProductoDAOImplementar();
                Producto prod = new Producto();
                prod.setId_producto(Integer.parseInt(id_prod_edit));
                prod.setNom_producto(nom_prod_edit);
                prod.setStock(Float.parseFloat(stock_prod_edit));
                prod.setPrecio(Float.parseFloat(precio_prod_edit));
                prod.setUnidadMedida(U_M_edit);
                prod.setEstado(Integer.parseInt(estado_prod_edit));
                prod.setCategoria_id(Integer.parseInt(IdC_prod_edit));
                producto.guardarProd(prod);
                this.listaProductos(request, response);
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
            
        }else{
            Producto producto = new Producto();
            //Se efectua el casting o conversión de datos porque lo ingresado en el formulario es texto
            producto.setId_producto(Integer.parseInt(request.getParameter("id_productos")));
            producto.setNom_producto(request.getParameter("txtNomProducto"));
            producto.setStock(Float.parseFloat(request.getParameter("txtStockProducto")));
            producto.setPrecio(Float.parseFloat(request.getParameter("txtPrecioProducto")));
            producto.setUnidadMedida(request.getParameter("txtUnidadMedidaProducto"));
            producto.setEstado(Integer.parseInt(request.getParameter("txtEstadoProducto")));
            producto.setCategoria_id(Integer.parseInt(request.getParameter("txtCategoriaProducto")));

            ProductoDAO guardarProducto = new ProductoDAOImplementar();
            guardarProducto.guardarProd(producto);
            this.listaProductos(request, response);
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
