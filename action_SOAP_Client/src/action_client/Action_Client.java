/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action_client;

import auction.web.Bid;
import auction.web.Item;
import auction.web.User;

/**
 *
 * @author myron
 */
public class Action_Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public static java.util.List<auction.web.Item> findItemByDescription(java.lang.String arg0) {
        auction.web.AuctionService service = new auction.web.AuctionService();
        auction.web.Auction port = service.getAuctionPort();
        return port.findItemByDescription(arg0);
    }

    public static Item getItem(java.lang.Long arg0) {
        auction.web.AuctionService service = new auction.web.AuctionService();
        auction.web.Auction port = service.getAuctionPort();
        return port.getItem(arg0);
    }

    public static Bid newBid(auction.web.Item arg0, auction.web.User arg1, auction.web.Money arg2) {
        auction.web.AuctionService service = new auction.web.AuctionService();
        auction.web.Auction port = service.getAuctionPort();
        return port.newBid(arg0, arg1, arg2);
    }

    public static Item offerItem(auction.web.User arg0, auction.web.Category arg1, java.lang.String arg2) {
        auction.web.AuctionService service = new auction.web.AuctionService();
        auction.web.Auction port = service.getAuctionPort();
        return port.offerItem(arg0, arg1, arg2);
    }

    public static boolean revokeItem(auction.web.Item arg0) {
        auction.web.AuctionService service = new auction.web.AuctionService();
        auction.web.Auction port = service.getAuctionPort();
        return port.revokeItem(arg0);
    }

    public static User getUser(java.lang.String arg0) {
        auction.web.RegistrationService service = new auction.web.RegistrationService();
        auction.web.Registration port = service.getRegistrationPort();
        return port.getUser(arg0);
    }

    public static User registerUser(java.lang.String arg0) {
        auction.web.RegistrationService service = new auction.web.RegistrationService();
        auction.web.Registration port = service.getRegistrationPort();
        return port.registerUser(arg0);
    }
    
    
}
