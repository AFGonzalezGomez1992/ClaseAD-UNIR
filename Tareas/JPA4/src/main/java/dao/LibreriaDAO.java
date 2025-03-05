package dao;

import database.HibernateUtil;
import model.Libreria;
import org.hibernate.Session;

public class LibreriaDAO {

    private Session session;

    public void crearLibreria(Libreria libreria) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(libreria);
        session.getTransaction().commit();
        session.close();
    }

    public Libreria obtenerLibreriaPorId(int id) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Libreria libreria = session.get(Libreria.class, id);
        session.getTransaction().commit();
        session.close();
        return libreria;
    }
}
