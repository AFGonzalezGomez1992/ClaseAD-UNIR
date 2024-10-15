package resources;

import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PeticionJSON {

    public void procesarPeticion(){


        //FILE -> FILE READER ->FILEREADER

        //URL -> HTTPCONNECTION -> BUFFERREADER
        String urlString = "https://dummyjson.com/products";
        try {
            URL url = new URL(urlString);
            HttpURLConnection conection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conection.getInputStream()));
            String linea = null;
            StringBuffer stringBuffer = new StringBuffer();
            while ((linea = bufferedReader.readLine())!=null){
                stringBuffer.append(linea);
            }

            JSONObject peticionProducto = new JSONObject(stringBuffer.toString());
            JSONArray listaProductos = peticionProducto.getJSONArray("products");
            for (Object item: listaProductos) {
                // item es un JSONObject -> YO LO SÉ
                JSONObject producto = (JSONObject) item;
                System.out.println("Nombre : "+producto.getString("title"));
                System.out.println("Precio : "+producto.getDouble("price"));
                JSONArray tags = producto.getJSONArray("tags");
                System.out.println("Las categorias del producto son:");
                for (Object tag: tags) {
                    System.out.println("\t"+tag);
                }

            }

            JSONObject producto = listaProductos.getJSONObject(0);
            System.out.println(producto.get("title"));

        } catch (MalformedURLException e) {
            System.out.println("No es una web, por favor intentalo de nuevo");
        } catch (IOException e) {
            System.out.println("Error en la página, no responde");
        }


    }
}
