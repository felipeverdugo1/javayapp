package dao;



import jakarta.persistence.EntityManager;

import model.Producto;
import until.JPAUtil;

import java.util.List;

public class ProductoDAOImpl {
    public void guardar(Producto producto) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(producto);
        em.getTransaction().commit();
        em.close();
    }

    public List<Producto> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Producto> productos = em.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
        em.close();
        return productos;
    }
}