
package DAO;

import Model.UserM;
import java.util.ArrayList;

public interface UserDAO {
    public ArrayList<UserM> startSession(String usuario, String clave);
}
