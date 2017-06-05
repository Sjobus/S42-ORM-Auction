/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.web;

import auction.domain.Bid;
import auction.domain.Category;
import auction.domain.Item;
import auction.domain.User;
import auction.service.AuctionMgr;
import auction.service.SellerMgr;
import java.util.List;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import nl.fontys.util.Money;

/**
 *
 * @author myron
 */
@WebService
public class Auction
{
    private AuctionMgr auctionMgr;
    private SellerMgr sellerMgr;
    
    Auction(EntityManager em)
    {
        auctionMgr = new AuctionMgr(em);
        sellerMgr = new SellerMgr(em);
    }
    
    /**
     * Get a specific item by id
     * @param id
     * @return Item or null
     */
    public Item getItem(Long id)
    {
        return auctionMgr.getItem(id);
    }
    
    /**
     * Find a item by description text
     * @param description
     * @return List of items found or null
     */
    public List<Item> findItemByDescription(String description)
    {
        return auctionMgr.findItemByDescription(description);
    }
    
    /**
     * Place a bid on a item
     * @param item
     * @param buyer
     * @param amount
     * @return the Bid placed on the item
     */
    public Bid newBid(Item item, User buyer, Money amount)
    {
        return auctionMgr.newBid(item, buyer, amount);
    }
    
    /**
     * Offer a item to the Action
     * @param seller
     * @param car
     * @param description
     * @return Item offered to the Action
     */
    public Item offerItem(User seller, Category car, String description)
    {
        return sellerMgr.offerItem(seller, car, description);
    }
    
    /**
     * Remove item from the Action
     * @param item
     * @return True if item is removed, false if not
     */
    public boolean revokeItem(Item item)
    {
        return sellerMgr.revokeItem(item);
    }
}
