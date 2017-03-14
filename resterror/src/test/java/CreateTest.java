import com.mikael0.resterror.Person;
import com.mikael0.resterror.PersonResource;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.assertSame;

/**
 * Created by mikael0 on 14.03.17.
 */
public class CreateTest {

    private static PersonResource service;

    @BeforeClass
    public static void setup(){
        service = new PersonResource();
    }

    @Test
    public void testCreate(){
       String ret = service.createPerson("IVAN", "IVANOV", 42, "M",  System.currentTimeMillis());
       assertNotNull(ret);
       assertNotSame(0, ret);
    }

}
