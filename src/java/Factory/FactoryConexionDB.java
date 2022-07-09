
package Factory;


public class FactoryConexionDB {
    public static final int MySQL = 1;
    public static String[] configMySQL = {"db_inventario_monroy", "root", ""};
    
    public static ConexionDB open(int tipoDB){
        switch(tipoDB){
            case FactoryConexionDB.MySQL:
                System.out.println("Ok");
                return new MySQLConexionFactory(configMySQL);
                
            default:
                System.out.println("No Ok");
                return null;
        }
    }
    
    public static void main(String[] args) {
        open(1);
    }
}
