package Services;

import Beans.ReplyBean;
import Beans.UsuarioBean;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Julian
 */

public class CarritoService implements TableServiceCarrito, ViewServiceCarrito {

    HttpServletRequest oRequest = null;

    public CarritoService(HttpServletRequest request) {
        oRequest = request;
    }

    private Boolean checkPermission(String strMethodName) throws Exception {
        UsuarioBean oUsuarioBean = (UsuarioBean) oRequest.getSession().getAttribute("user");
        if (oUsuarioBean != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * METODO FIND
     *TIENE QUE SER HASHMAP O BEAN --> HASHMAP TIPO <INT,POJO BEAN>
     *                             --> BEAN (INT CANTIDAD, PRODUCTOBEAN OPRODUCTO)
     * @return
     * @throws Exception
     */
//    private Producto find(ArrayList<Producto> alProducto, int id) {
//        Iterator<Producto> iterator = alProducto.iterator();
//        while (iterator.hasNext()) {
//            Producto oProducto = iterator.hasNext();
//            if (id == oProducto.getId()) {
//                return oProducto;
//            }
//        }
//        return null;
//    }

    @Override
    public ReplyBean add() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReplyBean remove() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReplyBean list() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReplyBean buy() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReplyBean empty() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
