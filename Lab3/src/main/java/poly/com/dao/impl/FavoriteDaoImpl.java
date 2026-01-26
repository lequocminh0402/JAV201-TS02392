package poly.com.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import poly.com.dao.FavoriteDao;
import poly.com.entity.User;
import poly.com.utils.XJPA;

import java.util.List;

public class FavoriteDaoImpl implements FavoriteDao {
    EntityManager em = XJPA.getEntityManager();

    @Override
    public List<FavoriteDao> findAll() {
        String jpql = "select f from Favorite f";
        TypedQuery<FavoriteDao> query = em.createQuery(jpql, FavoriteDao.class);
        return query.getResultList();
    }

    @Override
    public FavoriteDao findById(Integer id) {
        return em.find(FavoriteDao.class, id);
    }

    @Override
    public FavoriteDao create(FavoriteDao user) {
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public FavoriteDao update(FavoriteDao user) {
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public void deleteById(Integer id) {
        User user = em.find(User.class, id);
        try {
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }
}
