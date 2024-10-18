import model.Producto;

import java.io.*;

public class GestorFicheros {

    public void escribirBinarios(String path){

        //File
        File file = new File(path);
        DataOutputStream dataOutputStream = null;

        try {
            dataOutputStream = new DataOutputStream( new FileOutputStream(file));
            dataOutputStream.writeUTF("Ejemplo de escritura binaria");
            dataOutputStream.writeInt(5);
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeChar(234);
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Problema con el fichero");
        }finally {
            try {
                dataOutputStream.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error al cerrar");
            }
        }
    }
    public void lecturaBinarios(String path){

        //File
        File file = new File(path);
        DataInputStream dataInputStream = null;

        try {
            dataInputStream = new DataInputStream( new FileInputStream(file));
            String lectura = dataInputStream.readUTF();
            System.out.println(lectura);
            // chars
            int numero = dataInputStream.readInt();
            System.out.println(numero);
            // int
            boolean valor = dataInputStream.readBoolean();
            System.out.println(valor);
            // bool
            char letra = dataInputStream.readChar();
            System.out.println(letra);
            // char


        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Problema con el fichero");
        }finally {
            try {
                dataInputStream.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error al cerrar");
                System.out.println(e.getMessage());
            }
        }
    }
    public void escribirObjeto(String path){
        File file = new File(path);
        ObjectOutputStream objectOutputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(new Producto(1, "Producto1", 98.65, 1));
            objectOutputStream.writeObject(new Producto(2, "Producto2", 12.65, 3));

        } catch (IOException e) {
            System.out.println("Error en el fichero");
            System.out.println(e.getMessage());
        }finally {
            try {
                objectOutputStream.close();
            } catch (IOException |NullPointerException e) {
                System.out.println("Error al cerrar");
            }
        }
    }

    public void lecturaObjeto(String path){
        File file = new File(path);
        ObjectInputStream objectInputStream = null;

        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            Producto producto = (Producto) objectInputStream.readObject();
            producto.mostrarDatos();

        } catch (IOException e) {
            System.out.println("Error en la lectura del fichero");
        } catch (ClassNotFoundException e) {
            System.out.println("No se encuentra la clase destino");
        } catch (ClassCastException e){
            System.out.println("Error al declarar el tipo de datos");
        }
    }
}
