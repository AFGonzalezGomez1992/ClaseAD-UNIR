package dao;

import database.HibernateUtil;
import model.Autor;
import org.hibernate.Session;

public class AutorDAO {

    private Session session;

    public void crearAutor(Autor autor) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(autor);
        session.getTransaction().commit();
        session.close();
    }

    public Autor obtenerAutorPorId(int id) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Autor autor = session.get(Autor.class, id);
        session.getTransaction().commit();
        session.close();
        return autor;
    }
}
