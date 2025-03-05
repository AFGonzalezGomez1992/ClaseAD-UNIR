package dao;

import database.HibernateUtil;
import model.Libro;
import org.hibernate.Session;

import java.util.List;

public class LibroDAO {

    private Session session;

    public void crearLibro(Libro libro) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(libro);
        session.getTransaction().commit();
        session.close();
    }

    public List<Libro> obtenerTodosLosLibros() {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Libro> libros = session.createQuery("FROM Libro", Libro.class).list();
        session.getTransaction().commit();
        session.close();
        return libros;
    }
}
