package dao;

import database.HibernateUtil;
import model.Evento;
import org.hibernate.Session;

import java.util.List;

public class EventoDAO {

    private Session session;

    public void crearEvento(Evento evento) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(evento);
        session.getTransaction().commit();
        session.close();
    }

    public Evento obtenerEventoPorId(int id) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Evento evento = session.get(Evento.class, id);
        session.getTransaction().commit();
        session.close();
        return evento;
    }

    public List<Evento> obtenerTodosLosEventos() {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Evento> eventos = session.createQuery("FROM Evento", Evento.class).list();
        session.getTransaction().commit();
        session.close();
        return eventos;
    }
}
