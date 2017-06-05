/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.web;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.ws.Endpoint;

/**
 *
 * @author Kevin
 */
public class PublishWebservice {
    
    private static final String url = "http://localhost:6080/WebAuction";
    private static final String url2 = "http://localhost:6080/WebRegistration";
    
    private static EntityManagerFactory emf;
    private static EntityManager em;
        
    public static void main(String[] args){
        emf = Persistence.createEntityManagerFactory("auctionPU");
        em = emf.createEntityManager();
        
        Endpoint.publish(url, new Auction(em));
        Endpoint.publish(url2, new Registration(em));

    }
}
