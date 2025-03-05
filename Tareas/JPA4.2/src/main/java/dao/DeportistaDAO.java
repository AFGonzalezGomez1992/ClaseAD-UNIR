package dao;

import database.HibernateUtil;
import model.Deportista;
import org.hibernate.Session;

import java.util.List;

public class DeportistaDAO {

    private Session session;

    public void crearDeportista(Deportista deportista) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(deportista);
        session.getTransaction().commit();
        session.close();
    }

    public Deportista obtenerDeportistaPorId(int id) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Deportista deportista = session.get(Deportista.class, id);
        session.getTransaction().commit();
        session.close();
        return deportista;
    }

    public List<Deportista> obtenerTodosLosDeportistas() {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Deportista> deportistas = session.createQuery("FROM Deportista", Deportista.class).list();
        session.getTransaction().commit();
        session.close();
        return deportistas;
    }
}
