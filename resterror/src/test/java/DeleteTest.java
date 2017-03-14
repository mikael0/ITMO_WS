import com.mikael0.resterror.NoDataException;
import com.mikael0.resterror.PersonResource;
import com.mikael0.resterror.PostgreSQLDAO;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by mikael0 on 14.03.17.
 */
public class DeleteTest {

    private static PersonResource service;

    @BeforeClass
    public static void setup(){
        service = new PersonResource();
    }

    @Test
    public void testDelete(){
        String ret = null;
        try {
             ret = service.deletePerson(13l);
        }
        catch (NoDataException e){
            fail();
        }
        assertNotNull(ret);
        assertEquals(0, ret);
    }

    @Test
    public void testDaoDelete(){
        Integer ret = null;
        ret = new PostgreSQLDAO().deletePerson(13l);
        assertNotNull(ret);
        assertEquals(new Long(0), ret);
    }

}
