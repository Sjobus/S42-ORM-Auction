package auction.service;

import static action_client.Action_Client.*;
import auction.web.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AuctionMgrTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getItemTest() {

        String email = "xx2@nl";
        String omsch = "omsch";

        User seller1 = registerUser(email);
        Category cat = new Category();
        cat.setDescription("cat2");
        Item item1 = offerItem(seller1, cat, omsch);
        Item item2 = getItem(item1.getId());
        assertEquals(omsch, item2.getDescription());
        assertEquals(email, item2.getSeller().getEmail());
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
        cat.setDescription("cat3");
        Item item1 = offerItem(seller3, cat, omsch);
        Item item2 = offerItem(seller4, cat, omsch);
        
        System.out.println("Begin 1");
        List<Item> res = (List<Item>) findItemByDescription(omsch2);
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
        cat.setDescription("cat9");
        Item item1 = offerItem(seller, cat, omsch);
        Money money = new Money();
        money.setCents(10);
        money.setCurrency("eur");
        Bid new1 = newBid(item1, buyer, money);
        assertEquals(emailb, new1.getBuyer().getEmail());

        // lager bod
        Money moneylower = new Money();
        moneylower.setCents(9);
        moneylower.setCurrency("eur");
        Bid new2 = newBid(item1, buyer2, moneylower);
        assertNull(new2);
        
        // hoger bod
        Money moneyhigher = new Money();
        moneyhigher.setCents(11);
        moneyhigher.setCurrency("eur");
        Bid new3 = newBid(item1, buyer2, moneyhigher);
        assertEquals(emailb2, new3.getBuyer().getEmail());
    }
}
