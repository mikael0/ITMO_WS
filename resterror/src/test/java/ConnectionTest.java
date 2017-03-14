import com.mikael0.resterror.ConnectionUtil;
import org.junit.Test;

import static junit.framework.Assert.*;

import java.sql.Connection;

/**
 * Created by mikael0 on 14.03.17.
 */
public class ConnectionTest {

    @Test
    public void testConnection(){
        Connection connection = ConnectionUtil.getConnection();
        assertNotNull(connection);
    }

}
