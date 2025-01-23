import dao.ClienteDAO;
import dao.HabitacionDAO;
import dao.TrabajadorDAO;
import model.Cliente;
import model.Direccion;
import model.Habitacion;
import model.Trabajador;

public class Entrada {
    public static void main(String[] args) {

        TrabajadorDAO trabajadorDAO = new TrabajadorDAO();
        HabitacionDAO habitacionDAO = new HabitacionDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        // insercion -> insert
        /*Scanner scanner = new Scanner(System.in);
        SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        System.out.println("Introduce todos los datos del trabajador - nombre, apellido, direccion y telefono");
        session.persist(new Trabajador(scanner.next(), scanner.next(), scanner.nextInt(), scanner.next()));
        session.getTransaction().commit();
        session.close();*/

        // obtencion -> select
        /*SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Trabajador t = session.get(Trabajador.class,1);
        System.out.println(t.getNombre());
        session.getTransaction().commit();
        session.close();*/

        // actualizacion
        /*SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Trabajador trabajador = session.get(Trabajador.class,3);
        trabajador.setDirección("Sevilla");
        session.merge(trabajador);
        session.getTransaction().commit();
        session.close();*/

        // borrado
        /*SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Trabajador trabajador = new Trabajador(1);
        session.delete(trabajador);
        session.getTransaction().commit();
        session.close();*/

        // selección avanzada
        /*SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        // t nomenclatura para un trabajador
        // SELECT * FROM EMPLEADOS
        Query<Trabajador> query = session.createQuery("SELECT t FROM Trabajador t", Trabajador.class);
        List<Trabajador> listaTrabajadores = query.list();
        for (Trabajador trabajador: listaTrabajadores){
            System.out.println(trabajador);
        }
        session.getTransaction().commit();
        session.close();*/


        //trabajadorDAO.selecionHabitacionTrabajador(33);

        //habitacionDAO.getTrabajadorHabitacion(13);
        /*trabajadorDAO.insertarTrabajador(new Trabajador("Borja", "Martin",
                new Direccion("Madrid", "Madrid"),
                new Direccion("Galicia", "Galicia"), 4567),new Habitacion(3,300,3));*/

        /*for (int i = 10; i < 21; i++) {
            habitacionDAO.crearHabitacion(new Habitacion(1,i,4));
        }*/
        /*try {
            trabajadorDAO.insertarTrabajador(new Trabajador("Borja", "Martin",
                    new Direccion("Madrid", "Madrid"),
                    new Direccion("Barcelona", "Barcelona"), 123));
        }catch (ConstraintViolationException e){
            System.out.println("El teléfono esta duplicado, quieres indicarme otro");
        }*/
        //trabajadorDAO.seleccionarTodosByLocalidad("Madrid");

        //clienteDAO.crearCliente(new Cliente("Juan"),11);

        habitacionDAO.getAllClientes(11);

    }

}

