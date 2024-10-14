package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GestionFicherosEscritura {

    private int contador = 0;

    public void escribirFichero(String path) {
        Scanner scanner = new Scanner(System.in);
        //contador++;
        //path += "_escritura"+contador+".txt";
        //FILE -> FILEWRITER -> BUFFEREDWRITER ->PRINTWRITER -> CERRAR
        System.out.println("Cual es el nombre del fichero a guardar");
        String nombre = scanner.next();
        File file = new File(path+nombre+".txt");
        FileWriter fileWriter = null;

        System.out.println("Por favor intruduce lo que quieres guardar");
        String lecturaFrase = scanner.nextLine();
        System.out.println("Indica si quieres sobreescribir el fichero");
        boolean sobreescritra = scanner.nextBoolean();

        try {
            fileWriter = new FileWriter(file, sobreescritra); // append -> anexar o no la escritura
            fileWriter.write("\n"+lecturaFrase);


        } catch (IOException e) {
            System.out.println("Error en la escritura del fichero, por permisos");
        } finally {
            try {
                fileWriter.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cierrre de flujo");
            }
        }
    }
}
