import com.mikael0.resterror.NoDataException;
import com.mikael0.resterror.Person;
import com.mikael0.resterror.PersonResource;
import com.mikael0.resterror.PostgreSQLDAO;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertSame;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.fail;

/**
 * Created by mikael0 on 14.03.17.
 */
public class UpdateTest {

    private static PersonResource service;

    @BeforeClass
    public static void setup(){
        service = new PersonResource();
    }

    @Test
    public void testUpdate(){
        String ret = null;
        try {
             ret = service.updatePerson(13l, "NAME", null, 0, null, null);
        }
        catch (NoDataException e){
            fail();
        }
        assertNotNull(ret);
        assertEquals(0, ret);
    }

    @Test
    public void testDaoUpdate(){
        Integer ret = null;
        ret = new PostgreSQLDAO().updatePerson(13l, "NAME", null, 0, null, null);
        assertNotNull(ret);
        assertEquals(new Long(0), ret);
    }

}
