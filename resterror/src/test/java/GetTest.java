import com.mikael0.resterror.Person;
import com.mikael0.resterror.PersonResource;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.*;

/**
 * Created by mikael0 on 14.03.17.
 */
public class GetTest {

    private static PersonResource service;

    @BeforeClass
    public static void setup(){
        service = new PersonResource();
    }

    @Test
    public void testGet(){
        List<Person> ret = service.getPersons();
        assertNotNull(ret);
        for (Person person : ret){
            assertNotNull(person.getName());
            assertNotNull(person.getSurname());
            assertNotNull(person.getAge());
            assertNotNull(person.getSex());
            assertNotNull(person.getBirth());
        }
    }

    @Test
    public void testGetByParams(){
        List<Person> ret = service.getPersonsByParams("MIKHAIL", null, null, null, null);
        assertNotNull(ret);
        for (Person person : ret){
            assertEquals(person.getName(), "MIKHAIL");
        }
    }
}
