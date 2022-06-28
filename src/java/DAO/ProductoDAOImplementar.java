
package DAO;
import Factory.ConexionDB;
import Factory.FactoryConexionDB;
import Model.Categoria;
import Model.Producto;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProductoDAOImplementar implements ProductoDAO {
    
    ConexionDB conn;
    
    public ProductoDAOImplementar(){
        
    }

    @Override
    public List<Producto> Listar() {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        StringBuilder miSQL = new StringBuilder(); //Construir la consulta
        miSQL.append("SELECT * FROM tb_producto;");
        List<Producto> lista = new ArrayList<Producto>();
        try{
            ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());
            while(resultadoSQL.next()){
                Categoria categoria = new Categoria();
                Producto producto = new Producto();
                
                producto.setId_producto(resultadoSQL.getInt("id_producto"));
                producto.setNom_producto(resultadoSQL.getString("nom_categoria"));
                producto.setCategoria_id(resultadoSQL.getInt("categoria"));
                producto.setStock(resultadoSQL.getFloat("stock"));
                producto.setPrecio(resultadoSQL.getFloat("precio"));
                producto.setUnidadMedida(resultadoSQL.getString("unidad_de_medida"));
                producto.setEstado(resultadoSQL.getInt("estado_producto"));
                lista.add(producto);
            }
        }catch(Exception ex){
            
        }finally{
            this.conn.cerrarConexion();
        }
        return lista;
    }

    @Override
    public List<Producto> Listar2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto editarProd(int id_prod_edit) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        Producto producto = new Producto();
        StringBuilder miSQL = new StringBuilder();
        //Agregar la consulta SQL
        miSQL.append("SELECT * FROM tb_producto WHERE id_producto = ").append(id_prod_edit);
        try{
            ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());
            while(resultadoSQL.next()){
                producto.setId_producto(resultadoSQL.getInt("id_producto"));
                producto.setNom_producto(resultadoSQL.getString("nom_categoria"));
                producto.setCategoria_id(resultadoSQL.getInt("categoria"));
                producto.setStock(resultadoSQL.getFloat("stock"));
                producto.setPrecio(resultadoSQL.getFloat("precio"));
                producto.setUnidadMedida(resultadoSQL.getString("unidad_de_medida"));
                producto.setEstado(resultadoSQL.getInt("estado_producto"));
            }
        }catch(Exception e){
            
        }finally{
            this.conn.cerrarConexion();//Cerrar conexión
        }
        return producto;
    }

    @Override
    public boolean guardarProd(Producto producto) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL); //Hacer la conexión
        boolean guarda = false; //Bandera de resultado
        try{
            if(producto.getId_producto() == 0){//Para cuando es una nueva categoria
                StringBuilder miSQL = new StringBuilder();
                //Agregar consulta SQL; el id_categoria es autoincrementable
                miSQL.append("INSERT INTO tb_producto(nom_producto, categoria, stock, precio, unidad_de_medida, estado_producto) VALUES ('");
                miSQL.append(producto.getNom_producto() + "', ").append(producto.getCategoria_id());
                miSQL.append(producto.getStock() + "', ").append(producto.getPrecio());
                miSQL.append(producto.getUnidadMedida() + "', ").append(producto.getEstado());
                miSQL.append(");");
                //Invocar método para ejecutar la consulta
                this.conn.ejecutarSQL(miSQL.toString());
            }else if(producto.getId_producto() > 0){ //Actualizar, id_categoria
                StringBuilder miSQL = new StringBuilder();
                miSQL.append("UPDATE tb_producto SET id_producto = ").append(producto.getId_producto());
                miSQL.append(", nom_producto = '").append(producto.getNom_producto());
                miSQL.append("', stock = ").append(producto.getStock());
                miSQL.append(", precio = ").append(producto.getPrecio());
                miSQL.append(", unidad_de_medida = '").append(producto.getUnidadMedida());
                miSQL.append("', estado_producto = ").append(producto.getEstado());
                miSQL.append(" WHERE id_producto = ").append(producto.getId_producto()).append(";");
                //Invocar método para ejecutar la consola
                this.conn.ejecutarSQL(miSQL.toString());
            }
            guarda = true;
        }catch(Exception e){
            
        }finally{
            this.conn.cerrarConexion();
        }
        return guarda;
    }

    @Override
    public boolean borrarProd(int id_prod_borrar) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL); //Hacer la conexión
        boolean borra = false; //Bandera resultado
        try{
            StringBuilder miSQL = new StringBuilder();
            miSQL.append("DELETE FROM tb_producto WHERE id_producto = ").append(id_prod_borrar);
            this.conn.ejecutarSQL(miSQL.toString());
            borra = true;
        }catch(Exception e){
            
        }finally{
            this.conn.cerrarConexion(); //Cerrar conexión
        }
        return borra;
    }
    
    
}
