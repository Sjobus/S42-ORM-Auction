/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.web;

import auction.domain.User;
import auction.service.RegistrationMgr;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author myron
 */
@WebService
public class Registration
{
    
    private RegistrationMgr registrationMgr;
    private EntityManagerFactory emf;
    private EntityManager em;
    
    Registration()
    {
        emf = Persistence.createEntityManagerFactory("auctionPU");
        em = emf.createEntityManager();
        registrationMgr = new RegistrationMgr(em);
    }
    
    /**
     * Register a user to the Auction
     * @param email
     * @return registered user or null
     */
    public User registerUser(String email)
    {
        return null;
    }
    
    /**
     * Get a user from the Auction
     * @param email
     * @return User or null
     */
    public User getUser(String email)
    {
        return null;
    }
}
