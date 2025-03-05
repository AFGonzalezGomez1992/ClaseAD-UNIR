import dao.AutorDAO;
import dao.EditorialDAO;
import dao.LibroDAO;
import dao.LibreriaDAO;
import model.Autor;
import model.Direccion;
import model.Editorial;
import model.Libro;
import model.Libreria;
import org.hibernate.SessionFactory;

import java.util.Arrays;

public class Entrada {
    public static void main(String[] args) {

        AutorDAO autorDAO = new AutorDAO();
        EditorialDAO editorialDAO = new EditorialDAO();
        LibroDAO libroDAO = new LibroDAO();
        LibreriaDAO libreriaDAO = new LibreriaDAO();

        /*// Crear autores
        Autor autor1 = new Autor("Gabriel", "García Márquez", "1927-03-06");
        Autor autor2 = new Autor("Isabel", "Allende", "1942-08-02");
        Autor autor3 = new Autor("Mario", "Vargas Llosa", "1936-03-28");

        autorDAO.crearAutor(autor1);
        autorDAO.crearAutor(autor2);
        autorDAO.crearAutor(autor3);*/

        /*// Crear editoriales
        Editorial editorial1 = new Editorial("Editorial Alfa", new Direccion("Madrid", "Madrid"));
        Editorial editorial2 = new Editorial("Editorial Beta", new Direccion("Barcelona", "Cataluña"));

        editorialDAO.crearEditorial(editorial1);
        editorialDAO.crearEditorial(editorial2);*/

        /*// Crear libros
        Libro libro1 = new Libro("Cien Años de Soledad", 19.99, editorial1, autor1);
        Libro libro2 = new Libro("El Amor en los Tiempos del Cólera", 15.99, editorial1, autor1);
        Libro libro3 = new Libro("La Casa de los Espíritus", 18.99, editorial2, autor2);
        Libro libro4 = new Libro("Eva Luna", 14.99, editorial2, autor2);
        Libro libro5 = new Libro("La Ciudad y los Perros", 20.99, editorial1, autor3);
        Libro libro6 = new Libro("Conversación en la Catedral", 21.99, editorial2, autor3);
        Libro libro7 = new Libro("El Sueño del Celta", 22.50, editorial1, autor3);
        Libro libro8 = new Libro("Memoria de mis Putas Tristes", 12.99, editorial1, autor1);

        libroDAO.crearLibro(libro1);
        libroDAO.crearLibro(libro2);
        libroDAO.crearLibro(libro3);
        libroDAO.crearLibro(libro4);
        libroDAO.crearLibro(libro5);
        libroDAO.crearLibro(libro6);
        libroDAO.crearLibro(libro7);
        libroDAO.crearLibro(libro8);*/

        /*// Crear librerías
        Libreria libreria1 = new Libreria("Librería Central", "Luis Pérez", new Direccion("Valencia", "Valencia"));
        Libreria libreria2 = new Libreria("Librería del Barrio", "Ana González", new Direccion("Sevilla", "Andalucía"));

        libreria1.setLibros(Arrays.asList(libro1, libro3, libro5, libro7));
        libreria2.setLibros(Arrays.asList(libro2, libro4, libro6, libro8));

        libreriaDAO.crearLibreria(libreria1);
        libreriaDAO.crearLibreria(libreria2);*/

        // Consultas requeridas
        System.out.println("\n--- Todos los libros con su editorial y autor ---");
        libroDAO.obtenerTodosLosLibros().forEach(libro -> {
            System.out.println(libro.getTitulo() + " - " + libro.getAutor().getNombre() + " (" + libro.getEditorial().getNombre() + ")");
        });

        System.out.println("\n--- Todos los autores con sus libros ---");
        autorDAO.obtenerAutorPorId(1).getLibros().forEach(libro -> {
            System.out.println(libro.getTitulo());
        });

        System.out.println("\n--- Todas las librerías con sus libros ---");
        libreriaDAO.obtenerLibreriaPorId(1).getLibros().forEach(libro -> {
            System.out.println(libro.getTitulo());
        });
    }
}
