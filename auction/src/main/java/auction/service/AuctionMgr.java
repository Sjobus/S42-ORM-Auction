package auction.service;

import auction.dao.ItemDAO;
import auction.dao.ItemDAOJPAImpl;
import nl.fontys.util.Money;
import auction.domain.Bid;
import auction.domain.Item;
import auction.domain.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

public class AuctionMgr  {

    private EntityManager em;
    private ItemDAO itemDAO;
    public AuctionMgr (EntityManager em)
    {
        this.em = em;
        itemDAO = new ItemDAOJPAImpl(this.em);
    }
    
   /**
     * @param id
     * @return het item met deze id; als dit item niet bekend is wordt er null
     *         geretourneerd
     */    
    public Item getItem(Long id) {
        
        return itemDAO.find(id);
    }

  
   /**
     * @param description
     * @return een lijst met items met @desciption. Eventueel lege lijst.
     */
    public List<Item> findItemByDescription(String description) {
        List<Item> itemList = (List<Item>) itemDAO.findByDescription(description);
//        if (itemList == null)
//            return new List<Item>();
        return itemList;
    }

    /**
     * @param item
     * @param buyer
     * @param amount
     * @return het nieuwe bod ter hoogte van amount op item door buyer, tenzij
     *         amount niet hoger was dan het laatste bod, dan null
     */
    public Bid newBid(Item item, User buyer, Money amount) {
        Bid newbid = item.newBid(buyer, amount);
        if (newbid != null)
        {
            itemDAO.edit(item);
            return newbid;
        }
        return null;
    }
}
