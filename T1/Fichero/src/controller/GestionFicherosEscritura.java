package controller;

import java.io.*;
import java.util.Scanner;

public class GestionFicherosEscritura {

    private int contador = 0;

    public void escribirFichero(String path) {
        Scanner scanner = new Scanner(System.in);
        //contador++;
        //path += "_escritura"+contador+".txt";
        //FILE -> FILEWRITER -> BUFFEREDWRITER ->PRINTWRITER -> CERRAR
        /*System.out.println("Cual es el nombre del fichero a guardar");
        String nombre = scanner.next();*/
        //File file = new File(path+nombre+".txt");
        File file = new File(path+"ejemplo.txt");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        PrintWriter printWriter = null;

        /*System.out.println("Por favor intruduce lo que quieres guardar");
        String lecturaFrase = scanner.nextLine();
        System.out.println("Indica si quieres sobreescribir el fichero");
        boolean sobreescritra = scanner.nextBoolean();*/

        try {
            fileWriter = new FileWriter(file, true); // append -> anexar o no la escritura
            //bufferedWriter = new BufferedWriter(fileWriter);
            //fileWriter.write("\n"+lecturaFrase);
            //bufferedWriter.newLine();
            //bufferedWriter.write("Escritura de una segunda linea con la escritura conjunta");
            printWriter = new PrintWriter(file);
            printWriter.println("Linea escrita con printWriter");
            printWriter.println("Otra linea escrita con printWriter");


        } catch (IOException e) {
            System.out.println("Error en la escritura del fichero, por permisos");
        } finally {
            try {
                //fileWriter.close();
                //bufferedWriter.close();
                printWriter.close();
            } catch (NullPointerException e) {
                System.out.println("Error en el cierrre de flujo");
            }
        }
    }
}
