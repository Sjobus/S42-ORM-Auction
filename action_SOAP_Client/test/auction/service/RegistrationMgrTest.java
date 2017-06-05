package auction.service;

import static action_client.Action_Client.getUser;
import static action_client.Action_Client.registerUser;
import java.util.List;
import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import auction.web.*;

public class RegistrationMgrTest {
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void registerUserTest() {
        User user1 = registerUser("xxx10@yyy");
        assertNotNull(user1);
        User user2 = registerUser("xxx2@yyy2");
        assertNotNull(user2);
        User user2bis = registerUser("xxx2@yyy2");
        assertSame(user2bis, user2);
        //geen @ in het adres
        assertNull(registerUser("abc"));
    }

    @Test
    public void getUserTest() {
        User user1 = registerUser("xxx5@yyy5");
        User userGet = getUser("xxx5@yyy5");
        assertSame(userGet, user1);
        assertNull(getUser("aaa4@bb5"));
        registerUser("abc");
        assertNull(getUser("abc"));
    }
}
