package dao;

import database.HibernateUtil;
import model.Entrenador;
import org.hibernate.Session;

public class EntrenadorDAO {

    private Session session;

    public void crearEntrenador(Entrenador entrenador) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(entrenador);
        session.getTransaction().commit();
        session.close();
    }

    public Entrenador obtenerEntrenadorPorId(int id) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Entrenador entrenador = session.get(Entrenador.class, id);
        session.getTransaction().commit();
        session.close();
        return entrenador;
    }
}
