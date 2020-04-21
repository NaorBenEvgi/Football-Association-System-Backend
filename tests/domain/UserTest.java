package domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    User user;

    @Before
    public void setUp() throws Exception {
        user = new User("username","1234","user","user@gmail.com");
    }

    @After
    public void tearDown() throws Exception {
        user = null;
    }

    @Test
    public void addRoleToUser(){
        assertTrue(user.getRoles().size() == 1);
        user.addRoleToUser(Role.REFEREE);
        assertTrue(user.getRoles().size() == 2);
    }

    @Test
    public void removeRoleFromUser(){
        user.addRoleToUser(Role.REFEREE);
        assertTrue(user.getRoles().size() == 2);

        user.removeRoleFromUser(Role.REFEREE);
        assertTrue(user.getRoles().size() == 1);
        assertFalse(user.getRoles().containsKey(Role.REFEREE));
    }

    @Test
    public void setProfileDetails(){
        user.setProfileDetails("12345","userNew","new@gmail.com");
        assertEquals("12345",user.getPassword());
        assertEquals("userNew",user.getName());
        assertEquals("new@gmail.com",user.getMail());
    }

    @Test
    public void isValidPassword(){
        assertTrue(User.isValidPassword("12345"));
        assertFalse(User.isValidPassword("!23456"));
        assertFalse(User.isValidPassword("123"));
    }

    @Test
    public void isValidUserName(){
        assertTrue(User.isValidUserName("a12345"));
        assertTrue(User.isValidUserName("username"));
        assertFalse(User.isValidUserName("!23456"));
        assertFalse(User.isValidUserName("123"));
    }
}