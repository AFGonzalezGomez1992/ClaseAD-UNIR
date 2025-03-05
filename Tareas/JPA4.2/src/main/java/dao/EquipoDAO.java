package dao;

import database.HibernateUtil;
import model.Equipo;
import org.hibernate.Session;

import java.util.List;

public class EquipoDAO {

    private Session session;

    public void crearEquipo(Equipo equipo) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(equipo);
        session.getTransaction().commit();
        session.close();
    }

    public Equipo obtenerEquipoPorId(int id) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Equipo equipo = session.get(Equipo.class, id);
        session.getTransaction().commit();
        session.close();
        return equipo;
    }

    public List<Equipo> obtenerTodosLosEquipos() {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Equipo> equipos = session.createQuery("FROM Equipo", Equipo.class).list();
        session.getTransaction().commit();
        session.close();
        return equipos;
    }
}
