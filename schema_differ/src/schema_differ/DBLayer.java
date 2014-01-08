package schema_differ;

import sql.Connector;
import java.sql.*;

/**
 * The DB Layer is responsible for all the processing
 *
 * @author ahughes
 */
public class DBLayer {

    private Connector c1;
    private Connector c2;

    public DBLayer(Connector aConnector1, Connector aConnector2) {
        c1 = aConnector1;
        c2 = aConnector2;
    }
    
    

}
