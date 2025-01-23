package dao;

import database.HibernateUtil;
import model.Cliente;
import model.Habitacion;
import model.Trabajador;
import org.hibernate.Session;

public class ClienteDAO {

    private Session session;

    public  void crearCliente(Cliente cliente, int id){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(cliente);
        Habitacion habitacion = session.get(Habitacion.class,id);
        cliente.setHabitacion(habitacion);
        session.merge(cliente);
        session.getTransaction().commit();
        session.close();
    }

    public void relacionClienteTrabajador(int id){
        Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Cliente cliente = session.get(Cliente.class,id);
        for (Trabajador trabajador: cliente.getListaTrabajadores()) {
            System.out.println(trabajador.getNombre());
        }
        session.getTransaction().commit();
        session.close();

    }


}
