package Services;

import Beans.ReplyBean;

/**
 *
 * @author Julian
 */

public interface TableServiceCarrito {

    public ReplyBean add() throws Exception;

    public ReplyBean remove() throws Exception;
}
