import dao.DeportistaDAO;
import dao.EquipoDAO;
import dao.EntrenadorDAO;
import dao.EventoDAO;
import model.Deportista;
import model.Equipo;
import model.Entrenador;
import model.Evento;

import java.util.Arrays;

public class Entrada {
    public static void main(String[] args) {

        // Inicializar DAOs
        DeportistaDAO deportistaDAO = new DeportistaDAO();
        EquipoDAO equipoDAO = new EquipoDAO();
        EntrenadorDAO entrenadorDAO = new EntrenadorDAO();
        EventoDAO eventoDAO = new EventoDAO();

        // Crear equipos
        Equipo equipo1 = new Equipo("Equipo A");
        Equipo equipo2 = new Equipo("Equipo B");
        equipoDAO.crearEquipo(equipo1);
        equipoDAO.crearEquipo(equipo2);

        // Crear entrenadores y asignarles equipos (Relación 1 a 1)
        Entrenador entrenador1 = new Entrenador("Carlos Pérez", 10, equipo1);
        Entrenador entrenador2 = new Entrenador("Marta López", 8, equipo2);
        entrenadorDAO.crearEntrenador(entrenador1);
        entrenadorDAO.crearEntrenador(entrenador2);

        // Asignar entrenadores a equipos
        equipo1.setEntrenador(entrenador1);
        equipo2.setEntrenador(entrenador2);

        // Crear deportistas y asignarlos a equipos (Relación 1 a N)
        Deportista deportista1 = new Deportista("Juan García", 25, equipo1);
        Deportista deportista2 = new Deportista("Laura Martínez", 22, equipo1);
        Deportista deportista3 = new Deportista("Pedro Sánchez", 27, equipo2);
        Deportista deportista4 = new Deportista("Ana Fernández", 23, equipo2);

        deportistaDAO.crearDeportista(deportista1);
        deportistaDAO.crearDeportista(deportista2);
        deportistaDAO.crearDeportista(deportista3);
        deportistaDAO.crearDeportista(deportista4);

        // Crear eventos (Relación N a M)
        Evento evento1 = new Evento("Torneo Regional", "2025-05-15");
        Evento evento2 = new Evento("Campeonato Nacional", "2025-06-20");

        eventoDAO.crearEvento(evento1);
        eventoDAO.crearEvento(evento2);

        // Asignar equipos a eventos
        evento1.setEquipos(Arrays.asList(equipo1, equipo2));
        evento2.setEquipos(Arrays.asList(equipo1));

        equipo1.setEventos(Arrays.asList(evento1, evento2));
        equipo2.setEventos(Arrays.asList(evento1));

        // Consultas para demostrar las relaciones
        System.out.println("\n--- Equipos y Entrenadores ---");
        equipoDAO.obtenerTodosLosEquipos().forEach(equipo -> {
            System.out.println("Equipo: " + equipo.getNombre() + ", Entrenador: " + equipo.getEntrenador().getNombre());
        });

        System.out.println("\n--- Deportistas por Equipo ---");
        deportistaDAO.obtenerTodosLosDeportistas().forEach(deportista -> {
            System.out.println("Deportista: " + deportista.getNombre() + ", Equipo: " + deportista.getEquipo().getNombre());
        });

        System.out.println("\n--- Eventos y Equipos Participantes ---");
        eventoDAO.obtenerTodosLosEventos().forEach(evento -> {
            System.out.println("Evento: " + evento.getNombre() + ", Equipos:");
            evento.getEquipos().forEach(equipo -> System.out.println(" - " + equipo.getNombre()));
        });

        System.out.println("\n--- Equipos y Eventos en los que participan ---");
        equipoDAO.obtenerTodosLosEquipos().forEach(equipo -> {
            System.out.println("Equipo: " + equipo.getNombre() + ", Eventos:");
            equipo.getEventos().forEach(evento -> System.out.println(" - " + evento.getNombre()));
        });
    }
}
