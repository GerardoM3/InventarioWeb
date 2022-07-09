
package Controller;

import DAO.CategoriaDAO;
import DAO.CategoriaDAOImplementar;
import Model.Categoria;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PDF extends HttpServlet {

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
        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();
        
        try{
            try{
                if(request.getParameter("opcion").equals("Categoria")){
                    CategoriaDAO cate = new CategoriaDAOImplementar();
                    cate.Listar();
                    List<Categoria> lista = new ArrayList<Categoria>();
                    Document doc = new Document();
                    PdfWriter.getInstance(doc, out);

                    doc.open();

                    Paragraph parrafo1 = new Paragraph();
                    Font fontTitle = new Font(Font.FontFamily.HELVETICA, 30, Font.BOLD, BaseColor.RED);
                    parrafo1.add(new Phrase("Reporte de " + request.getParameter("opcion")+"s.", fontTitle));
                    parrafo1.setAlignment(Element.ALIGN_CENTER);
                    parrafo1.add(Chunk.NEWLINE);
                    parrafo1.add(Chunk.NEWLINE);
                    doc.add(parrafo1);

                    PdfPTable tabla = new PdfPTable(3);
                    PdfPCell celda1 = new PdfPCell(new Paragraph("ID Categoría", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                    PdfPCell celda2 = new PdfPCell(new Paragraph("Nombre de la categoría", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                    PdfPCell celda3 = new PdfPCell(new Paragraph("Estado de la categoría", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
                    tabla.addCell(celda1);
                    tabla.addCell(celda2);
                    tabla.addCell(celda3);
                    System.out.println("OkM");
                    System.out.println(lista);
                    
                    for(int i = 0 ; i < lista.size() ; i++){
                        Categoria categoria = new Categoria();
                        System.out.println("Ok master");
                        categoria = (Categoria)lista.get(i);
                        
                        tabla.addCell(String.valueOf(categoria.getId_categoria()));
                        tabla.addCell(categoria.getNom_categoria());
                        tabla.addCell(String.valueOf(categoria.getEstado_categoria()));
                    }
                    
                    doc.add(tabla);

                    doc.close();
                }else if(request.getParameter("opcion").equals("Categoria")){
                    
                }
                
            }catch(Exception e){
                e.getMessage();
            }
        }finally{
            out.close();
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
