package Dao;

import Beans.LineadepedidoBean;
import Beans.PedidoBean;
import Beans.ProductoBean;
import Beans.UsuarioBean;
import Helper.EncodingUtilHelper;
import Helper.FilterBeanHelper;
import Static.Log4jStatic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 *
 * @author Julian
 */

public class LineadepedidoDao implements DaoTableInterface<LineadepedidoBean>, DaoViewInterface<LineadepedidoBean> {

    // VARIABLES
    private final String strTable = "lineadepedido";
    private String strSQL = "SELECT * FROM " + strTable + " WHERE 1=1 ";
    private Connection oConnection = null;

    // CONSTRUCTOR
    public LineadepedidoDao(Connection oPooledConnection) {
        oConnection = oPooledConnection;
    }

    /**
     * @param intExpand
     * @Método get: Obtiene datos sobre un usuario, desde una base de datos, y
     * crea un objeto "Bean" a partir de dichos datos.
     * @param oBean
     * @return UsuarioBean
     * @throws Exception
     */
    @Override
    public LineadepedidoBean get(LineadepedidoBean oBean, int intExpand) throws Exception {
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        strSQL = "SELECT * FROM " + strTable + " WHERE 1=1 ";
        strSQL += "AND id_producto=" + oBean.getId_producto() + " AND id_pedido=" + oBean.getId_pedido();
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oResultSet = oPreparedStatement.executeQuery(strSQL);
            if (oResultSet.next()) {
                oBean.setId_producto(oResultSet.getInt("id_producto"));
                oBean.setId_pedido(oResultSet.getInt("id_pedido"));
                if (intExpand > 0) {
                    ProductoBean oProducto = new ProductoBean();
                    ProductoDao oProductoDao = new ProductoDao(oConnection);
                    oProducto.setId(oBean.getId_producto());
                    oProducto = oProductoDao.get(oProducto, --intExpand);
                    oBean.setObj_producto(oProducto);

                    PedidoBean oPedido = new PedidoBean();
                    PedidoDao oPedidoDao = new PedidoDao(oConnection);
                    oPedido.setId(oBean.getId_pedido());
                    oPedido = oPedidoDao.get(oPedido, --intExpand);
                    oBean.setObj_pedido(oPedido);
                }
            } else {
                throw new Exception();
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jStatic.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }

        }
        return oBean;
    }

    /**
     * @Método set: Crea o actualiza un registro de usuario en una base de datos
     * y devuelve un código en función de si la consulta ha tenido éxito o no.
     * @param oBean
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer set(LineadepedidoBean oBean) throws Exception {
        PreparedStatement oPreparedStatement = null;
        Integer iResult = 0;
        Boolean insert = false;
        try {
            
            strSQL = "UPDATE " + strTable;
            strSQL += " SET ";
            strSQL += "id_producto=" + oBean.getId_producto() + ", ";
            strSQL += "id_usuario= " + oBean.getId_pedido();
            strSQL += " WHERE id_producto=" + oBean.getId_producto() + " AND id_pedido=" + oBean.getId_pedido();

            oPreparedStatement = oConnection.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
            iResult = oPreparedStatement.executeUpdate();
            if (iResult < 1) {
                throw new Exception();
            }
            if (insert) {
                ResultSet oResultSet = oPreparedStatement.getGeneratedKeys();
                oResultSet.next();
                iResult = oResultSet.getInt(1);
            }

        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jStatic.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return iResult;
    }

    /**
     * @Método remove: Elimina un registro de usuario de una base de datos y
     * devuelve un código en función de si la consulta ha tenido éxito o no.
     * @param id
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer remove(Integer id_producto) throws Exception {
        PreparedStatement oPreparedStatement = null;
        Integer iResult = 0;

        try {
            strSQL = "DELETE FROM " + strTable + " WHERE id=? ";
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oPreparedStatement.setInt(1, id_producto);
            iResult = oPreparedStatement.executeUpdate();
            if (iResult < 1) {
                throw new Exception();
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jStatic.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return iResult;
    }

    @Override
    public Long getcount(ArrayList<FilterBeanHelper> alFilter) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<LineadepedidoBean> getpage(int intRegsPerPag, int intPage, LinkedHashMap<String, String> hmOrder, ArrayList<FilterBeanHelper> alFilter) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
