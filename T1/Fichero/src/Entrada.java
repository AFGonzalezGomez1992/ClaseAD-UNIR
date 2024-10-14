import controller.GestionFicherosEscritura;
import controller.GestorFicherosLectura;

public class Entrada {

    public static void main(String[] args) {

        /*GestorFicherosLectura gestorFicherosLectura = new GestorFicherosLectura();
        //gestorFicheros.lecturaDirectorios("src/resources/directorio");
        //gestorFicheros.lecturaDirectorios("src/resources/ficheros")
        //gestorFicheros.lecturaRecursiva("c:/Users/Andrés/Documents/GitHub");
        try {
            gestorFicherosLectura.lecturaTextoPlano("src/resources/ficheros/lectura.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
        GestionFicherosEscritura gestionFicherosEscritura = new GestionFicherosEscritura();
        gestionFicherosEscritura.escribirFichero("src/resources/ficheros/escritura.txt");




        // instancias de objetos y llamadas a metodos
        //OBJETO CLASE 1
        //OBJETO CLASE 2

        // FILE -> fichero logico -> fisico
        // fichero logico
        // File ficheroSinPuntero = new File("C:\\Users\\Andrés\\Documents\\GitHub\\ClaseAD-UNIR\\T1\\Fichero\\src\\resources\\directorio\\ejemplo_fichero.md");
        /*File ficheroSinPuntero = new File("src/resources/directorio");
        System.out.println(ficheroSinPuntero.getName());
        System.out.println(ficheroSinPuntero.getParent());
        System.out.println(ficheroSinPuntero.length());
        System.out.println(ficheroSinPuntero.exists());
        System.out.println(ficheroSinPuntero.isDirectory());
        // File[] -> todos los FICHEROS que estan dentro del directorio
        ficheroSinPuntero.listFiles();
        // String[] -> todas las rutas de los FICHEROS que estan dentro del directorio
        ficheroSinPuntero.list();*/

        // 1 -> Obtener todos los nombres de los ficheros del directorio llamado directorio
        // 2 -> Crear una subcarpeta en el directorio llamado directorio y crear en ella un fichero
        //   -> Obtener todos los nombres de los fichers del directorio llamado directorio y el subdirectorio creado
        // 3 -> Listar el nombre de todos los ficheros del SISTEMA ( c:/ o /Users )

        // RECURSIVIDAD
        
        //if(!ficheroSinPuntero.exists()){
        //     try {
        //         ficheroSinPuntero.createNewFile();
        //     } catch (IOException e) {
        //         //throw new RuntimeException(e);
        //         System.out.println("Fallo en la creacion del fichero");
        //     }
        // }
    }
}
