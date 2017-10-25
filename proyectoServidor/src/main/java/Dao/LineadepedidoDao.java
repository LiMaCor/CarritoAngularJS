package Dao;

import Beans.LineadepedidoBean;
import Helper.FilterBeanHelper;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 *
 * @author Julian
 */

public class LineadepedidoDao implements DaoTableInterface<LineadepedidoBean>, DaoViewInterface<LineadepedidoBean> {

    @Override
    public LineadepedidoBean get(LineadepedidoBean oBean, int intExpand) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer set(LineadepedidoBean oBean) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer remove(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
