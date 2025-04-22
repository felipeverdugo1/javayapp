package dao;



import jakarta.persistence.EntityManager;
import model.Item;
import model.Persona;
import until.JPAUtil;

import java.util.List;

public class PersonaDAOImpl implements PersonaDAO{
    public void guardar(Persona persona) {
    	if (!this.mailExistente(persona.getEmail())) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(persona);
        em.getTransaction().commit();
        em.close();
    	}
    }

    public List<Persona> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Persona> persona = em.createQuery("SELECT p FROM Persona p", Persona.class).getResultList();
        em.close();
        return persona;
    }
    
    public boolean mailExistente(String email) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                "SELECT COUNT(p) > 0 FROM Persona p WHERE p.email = :email", Boolean.class)
                .setParameter("email", email)
                .getSingleResult();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
}