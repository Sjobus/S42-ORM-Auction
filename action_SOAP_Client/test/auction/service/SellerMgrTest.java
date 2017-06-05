package auction.service;

import static action_client.Action_Client.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import auction.web.*;

public class SellerMgrTest {

    @Before
    public void setUp() throws Exception {

    }

    /**
     * Test of offerItem method, of class SellerMgr.
     */
    @Test
    public void testOfferItem() {
        String omsch = "omsch";

        User user1 = registerUser("xx@nl");
        Category cat = new Category();
        Item item1 = offerItem(user1, cat, omsch);
        assertEquals(omsch, item1);
        assertNotNull(item1);
    }

    /**
     * Test of revokeItem method, of class SellerMgr.
     */
    @Test
    public void testRevokeItem() {
        String omsch = "omsch";
        String omsch2 = "omsch2";
        
        User seller = registerUser("sel@nl");
        User buyer = registerUser("buy@nl");
        Category cat = new Category();
        
            // revoke before bidding
        Item item1 = offerItem(seller, cat, omsch);
        boolean res = revokeItem(item1);
        assertTrue(res);
        int count = findItemByDescription(omsch).size();
        assertEquals(0, count);
        
            // revoke after bid has been made
        Item item2 = offerItem(seller, cat, omsch2);
        newBid(item2, buyer, new Money());
        boolean res2 = revokeItem(item2);
        assertFalse(res2);
        int count2 = findItemByDescription(omsch2).size();
        assertEquals(1, count2);
    }

}
