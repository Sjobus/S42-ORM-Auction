/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction.dao;

import auction.domain.Item;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author myron
 */
public class ItemDAOJPAImpl implements ItemDAO
{
    private final EntityManager em;
    public ItemDAOJPAImpl (EntityManager em)
    {
        this.em = em;
    }

    @Override
    public int count() {
        Query q = em.createNamedQuery("ItemDAO.count", Item.class);
        return ((Long) q.getSingleResult()).intValue();
    }

    @Override
    public void create(Item item) {
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
        //em.close();
    }

    @Override
    public void edit(Item item) {
        em.getTransaction().begin();
        em.merge(item);
        em.getTransaction().commit();
    }

    @Override
    public void remove(Item item) {
        
        em.getTransaction().begin();
        em.remove(em.contains(item) ? item : em.merge(item));
        em.getTransaction().commit();
    }

    @Override
    public Item find(Long id) {
        try
        {
            Query q = em.createNamedQuery("ItemDAO.findById", Item.class);
            q.setParameter("id", id);
            return (Item) q.getSingleResult();
        }
        catch(Exception ex)
        {
            return null;
        }
    }

    @Override
    public List<Item> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Item.class));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public List<Item> findByDescription(String description) {
        try
        {
            Query q = em.createNamedQuery("ItemDAO.findByDescription", Item.class);
            q.setParameter("description", description);
            return q.getResultList();
        }
        catch(Exception ex)
        {
            return null;
        }    
    }
    
}
