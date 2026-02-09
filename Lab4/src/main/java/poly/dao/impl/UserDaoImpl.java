package poly.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import poly.dao.UserDao;
import poly.entity.User;
import poly.utils.XJPA;

import java.util.List;

public class UserDaoImpl implements UserDao {
    EntityManager em = XJPA.getEntityManager();

    @Override
    public User findIDorEmail(String email) {
        String jpql = "SELECT u FROM User u WHERE u.id = :val OR u.email = :val";
        try {
            return em.createQuery(jpql, User.class)
                    .setParameter("val", value)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}