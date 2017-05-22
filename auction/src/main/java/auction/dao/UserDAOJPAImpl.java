package auction.dao;

import auction.domain.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

public class UserDAOJPAImpl implements UserDAO {

    private final EntityManager em;

    public UserDAOJPAImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public int count() {
        Query q = em.createNamedQuery("UserDAO.count", User.class);
        return ((Long) q.getSingleResult()).intValue();
    }

    @Override
    public void create(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        //em.close();
    }

    @Override
    public void edit(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    @Override
    public void remove(User user) {
        em.getTransaction().begin();
        em.remove(em.merge(user));
        em.getTransaction().commit();
    }
    
    @Override
    public List<User> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(User.class));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public User findByEmail(String email) {
        try
        {
        Query q = em.createNamedQuery("UserDAO.findByEmail", User.class);
        q.setParameter("email", email);
        return (User) q.getSingleResult();
        }
        catch(Exception ex)
        {
            return null;
        }
    }
}
