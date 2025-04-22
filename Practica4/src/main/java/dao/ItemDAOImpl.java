package dao;



import jakarta.persistence.EntityManager;

import model.Item;

import until.JPAUtil;

import java.util.List;

public class ItemDAOImpl implements ItemDAO{
    public void guardar(Item item) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
        em.close();
    }

    public List<Item> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Item> items = em.createQuery("SELECT i FROM Item i", Item.class).getResultList();
        em.close();
        return items;
    }
}