package auction.service;

import static action_client.Action_Client.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import auction.web.*;
import java.util.List;

public class AuctionMgrTest {

    @Before
    public void setUpTest() throws Exception {
    }

    @Test
    public void getItemTest() {

        String email = "xx2@nl";
        String omsch = "omsch";

        User seller1 = registerUser(email);
        Category cat = new Category();
        Item item1 = offerItem(seller1, cat, omsch);
        assertNotNull(item1);
    }

    @Test
    public void findItemByDescriptionTest() {
        String email3 = "xx3@nl";
        String omsch = "omsch";
        String email4 = "xx4@nl";
        String omsch2 = "omsch2";

        User seller3 = registerUser(email3);
        User seller4 = registerUser(email4);
        Category cat = new Category();
        Item item1 = offerItem(seller3, cat, omsch);
        Item item2 = offerItem(seller4, cat, omsch);
        
        System.out.println("Begin 1");
        List<Item> res = (List<Item>) findItemByDescription(omsch);
        assertEquals(0, res.size());
        System.out.println("Klaar 1");
        System.out.println("Begin 2");
        res = (List<Item>) findItemByDescription(omsch);
        assertEquals(2, res.size());
        System.out.println("Klaar 2");
    }

    @Test
    public void newBidTest() {

        String email = "ss2@nl";
        String emailb = "bb@nl";
        String emailb2 = "bb2@nl";
        String omsch = "omsch_bb";

        User seller = registerUser(email);
        User buyer = registerUser(emailb);
        User buyer2 = registerUser(emailb2);
        // eerste bod
        Category cat = new Category();
        Item item1 = offerItem(seller, cat, omsch);
        Bid new1 = newBid(item1, buyer, new Money());
        assertNotNull(new1);

        // lager bod
        Bid new2 = newBid(item1, buyer2, new Money());
        assertNull(new2);

        // hoger bod
        Bid new3 = newBid(item1, buyer2, new Money());
        assertNotNull(new3);
    }
}
