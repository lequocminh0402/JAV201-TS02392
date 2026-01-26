package poly.com.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import poly.com.dao.VideoDao;
import poly.com.entity.Video;
import poly.com.utils.XJPA;

import java.util.List;

public class VideoDaoImpl implements VideoDao {
    EntityManager em = XJPA.getEntityManager();

    @Override
    public List<Video> findAll() {
        String jpql = "select v from Video v";
        TypedQuery<Video> query = em.createQuery(jpql, Video.class);
        return query.getResultList();
    }

    @Override
    public Video findById(Integer id) {
        return em.find(Video.class, id);
    }

    @Override
    public Video create(Video video) {
        try {
            em.getTransaction().begin();
            em.persist(video);
            em.getTransaction().commit();
        }catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
        return video;
    }

    @Override
    public Video update(Video video) {
        try {
            em.getTransaction().begin();
            em.merge(video);
            em.getTransaction().commit();
        }catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
        return video;
    }

    @Override
    public void deleteById(Integer id) {
        Video video = em.find(Video.class, id);
        try {
            em.getTransaction().begin();
            em.remove(video);
            em.getTransaction().commit();
        }catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }
}
