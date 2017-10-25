package Services;

import Beans.ReplyBean;

/**
 *
 * @author Julian
 */

public interface ViewServiceCarrito {

    public ReplyBean list() throws Exception;

    public ReplyBean buy() throws Exception;
    
    public ReplyBean empty() throws Exception;

}
