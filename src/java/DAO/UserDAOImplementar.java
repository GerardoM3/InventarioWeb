
package DAO;

import Factory.ConexionDB;
import Factory.FactoryConexionDB;
import Model.UserM;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAOImplementar implements UserDAO{
    
    ConexionDB conn;
    
    @Override
    public ArrayList<UserM> startSession(String usuario, String clave) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        StringBuilder miSQL = new StringBuilder();
        miSQL.append("SELECT * FROM tb_user WHERE BINARY usuario = '").append(usuario);
        miSQL.append("' and clave = '").append(clave).append("';");
        ArrayList<UserM> lista = new ArrayList<UserM>();
        
        try{
            ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());
            while(resultadoSQL.next()){
                UserM user = new UserM();
                
                user.setId(resultadoSQL.getInt("id"));
                user.setNombre_u(resultadoSQL.getString("nombre"));
                user.setApellido_u(resultadoSQL.getString("apellido"));
                user.setCorreo_u(resultadoSQL.getString("correo"));
                user.setUsuario(resultadoSQL.getString("usuario"));
                user.setClave(resultadoSQL.getString("clave"));
                user.setTipo(resultadoSQL.getInt("tipo"));
                user.setEstado(resultadoSQL.getInt("estado"));
                user.setFecha(resultadoSQL.getString("fecha"));
                lista.add(user);
            }
        }catch(Exception ex){
            
        }finally{
            this.conn.cerrarConexion();
        }
        
        return lista;
    }
    
}
