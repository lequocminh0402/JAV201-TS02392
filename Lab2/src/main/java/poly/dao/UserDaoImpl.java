package poly.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import poly.entity.User;
import poly.utils.XJPA;

import java.util.List;

public class UserDaoImpl implements UserDao {
    EntityManager em = XJPA.getEntityManager();

    @Override
    public List<User> findAll() {
        String jpql = "select u from User u";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        return query.getResultList();
    }

    @Override
    public User findById(String id) {
        return em.find(User.class, id);
    }

    @Override
    public void create(User entity) {
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User item) {
        try {
            em.getTransaction().begin();
            em.merge(item);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteById(String id) {
        User entity = em.find(User.class, id);
        try {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }

    }
}
