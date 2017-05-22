package auction.service;

import auction.dao.ItemDAO;
import auction.dao.ItemDAOJPAImpl;
import auction.domain.Category;
import auction.domain.Item;
import auction.domain.User;
import javax.persistence.EntityManager;

public class SellerMgr {

    EntityManager em;
    ItemDAO itemDAO;
    public SellerMgr (EntityManager em)
    {
        this.em = em;
        itemDAO = new ItemDAOJPAImpl(this.em);
    }
    /**
     * @param seller
     * @param cat
     * @param description
     * @return het item aangeboden door seller, behorende tot de categorie cat
     *         en met de beschrijving description
     */
    public Item offerItem(User seller, Category cat, String description) {
        Item newItem = new Item(seller, cat, description);
        itemDAO.create(newItem);
        return newItem;
    }
    
     /**
     * @param item
     * @return true als er nog niet geboden is op het item. Het item word verwijderd.
     *         false als er al geboden was op het item.
     */
    public boolean revokeItem(Item item) {
        if(item.getHighestBid() == null)
        {
            itemDAO.remove(item);
            return true;
        }
        return false;
    }
}
