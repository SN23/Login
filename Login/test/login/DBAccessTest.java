package login;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Sukhjinder
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DBAccessTest {
    
    private static User user;
    private static final String USERNAME = "user";
    private static final String PASSWORD = "pwd";
    private static final String NEW_PASSWORD = "new_pwd";
    
    public DBAccessTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        user = new User();
        user.setUsername(USERNAME);
        user.setPassword(PASSWORD);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
       
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addUser method, of class DBAccess.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        Boolean expResult = true;
        Boolean result = DBAccess.addUser(user.getUsername(), user.getPassword());
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteUser method, of class DBAccess.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        Boolean expResult = true;
        Boolean result = DBAccess.deleteUser(user.getUsername());
        assertEquals(expResult, result);
    }

    /**
     * Test of changePassword method, of class DBAccess.
     */
    @Test
    public void testChangePassword() {
        System.out.println("changePassword");
        Boolean expResult = true;
        Boolean result = DBAccess.changePassword(user.getUsername(), user.getPassword(), NEW_PASSWORD);
        assertEquals(expResult, result);
    }

    /**
     * Test of retrieveUser method, of class DBAccess.
     */
    @Test
    public void testBRetrieveUser() {
        System.out.println("retrieveUser");
        User result = DBAccess.retrieveUser(user.getUsername());
        assertEquals(user.getUsername(), result.getUsername());
        assertEquals(user.getPassword(), result.getPassword());
    }
    
}
