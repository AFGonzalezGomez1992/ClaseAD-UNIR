import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;
import resources.PeticionJSON;

import java.io.*;

public class Entrada {

    public static void main(String[] args) {
        PeticionJSON peticionJSON = new PeticionJSON();
        peticionJSON.procesarPeticion();
        /*File file = new File("src/main/java/resources/usuario.txt");
        //txt ->JSON
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            StringBuffer lecturaCompleta = new StringBuffer();
            String linea = null;

            while((linea=bufferedReader.readLine())!=null){
                lecturaCompleta.append(linea);
            }

            JSONObject usuario = new JSONObject(lecturaCompleta.toString());
            String nombreUsuario = usuario.getString("nombre");
            JSONArray asignaturas = usuario.getJSONArray("asignaturas");
            for ( Object item : asignaturas ) {
                System.out.println(item);
            }

            System.out.println(asignaturas);

        } catch (FileNotFoundException e) {
            System.out.println("Error en el fichero");
        } catch (IOException e) {
            System.out.println("Error al leer");
        } finally{
            try {
                bufferedReader.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }*/

        // 1. Leer productos -> inprima informacion de los productos Nombre, precio, stok, descripcion
        // 2. Buscar producto -> pida por teclado un id y muestra la info de dicho producto
        // 3. Filtrar por precio -> pide un precio mínimo o max y se muestran los productos que cumplen dicho filtro
        // 4. Exportar productos -> Escribe en un .txt todos los productos de la URL -> JSON

        // BUSCAR INFORMACION DE LA LIBRERIA GSON
    }
}
