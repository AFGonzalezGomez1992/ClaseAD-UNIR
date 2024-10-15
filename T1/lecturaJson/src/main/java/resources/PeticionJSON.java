package resources;

import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class PeticionJSON {

    /*public void procesarPeticion(){


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


    }*/

    public void metodoMenu(){
        int opcion =0;
         Scanner sc = new Scanner(System.in);
        //BufferReader br -> lectura por teclado

        do{
            System.out.println("1. Leer");
            System.out.println("2. Buscar");
            System.out.println("3. Filtrar");
            System.out.println("4. Exportar");
            System.out.println("5. Salir");
            System.out.println("Que opcion quieres realizar");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Leer JSON");
                    try {
                        URL url = new URL("https://dummyjson.com/products");
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        //String lectura = bufferedReader.readLine();
                        //JSONObject jsonObject = new JSONObject(lectura);
                        JSONObject jsonObject = new JSONObject(bufferedReader.readLine());
                        JSONArray jsonArray = jsonObject.getJSONArray("products");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject product = jsonArray.getJSONObject(i);
                            String title = product.getString("title");
                            String description = product.getString("description");
                            double price = product.getDouble("price");
                            int stock = product.getInt("stock");
                            //System.out.println("El producto %s tiene como precio %.2f y una descripcion %s\n", title, price, description);
                            System.out.println("El producto "+title+" tiene como precio "+price+" y una descripcion de "+description+"\n");
                        }

                    } catch (MalformedURLException e) {
                        System.out.println("No es una web, por favor intentalo de nuevo");
                    } catch (IOException e) {
                        System.out.println("Pagina web no responde");
                    }
                    break ;
                case 2:
                    System.out.println("Buscar elementos");
                    System.out.println("Cual es el id del elemento que buscas");
                    int id = sc.nextInt();
                    try {
                        URL url = new URL("https://dummyjson.com/products");
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        //String lectura = bufferedReader.readLine();
                        //JSONObject jsonObject = new JSONObject(lectura);
                        JSONObject jsonObject = new JSONObject(bufferedReader.readLine());
                        JSONArray jsonArray = jsonObject.getJSONArray("products");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject product = jsonArray.getJSONObject(i);

                            if (id == product.getInt("id")){
                                String title = product.getString("title");
                                String description = product.getString("description");
                                double price = product.getDouble("price");
                                int stock = product.getInt("stock");
                                //System.out.println("El producto %s tiene como precio %.2f y una descripcion %s\n", title, price, description);
                                System.out.println("El producto "+title+" tiene como precio "+price+" y una descripcion de "+description+"\n");
                            }
                        }

                    } catch (MalformedURLException e) {
                        System.out.println("No es una web, por favor intentalo de nuevo");
                    } catch (IOException e) {
                        System.out.println("Pagina web no responde");
                    }
                    break;
                case 3:
                    System.out.println("Filtrar elementos");
                    System.out.println("Introduce precio max");
                    int max = sc.nextInt();
                    System.out.println("Introduce precio min");
                    int min = sc.nextInt();
                    filtrarPrecio(min,max);
                    break;
                case 4:
                    System.out.println("Exprtar elementos");
                    exportarDatos();
                    break;
            }
        }while (opcion !=5);
    }

    private void exportarDatos(){
        // File ->FileWriter -><PrintWriter
        File file = new File("src/main/java/resources/producto.txt");
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileWriter(file));
            // Leer JSON -> iterar por producto -> escribe una linea

            URL url = new URL("https://dummyjson.com/products");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            //String lectura = bufferedReader.readLine();
            //JSONObject jsonObject = new JSONObject(lectura);
            JSONObject jsonObject = new JSONObject(bufferedReader.readLine());
            JSONArray jsonArray = jsonObject.getJSONArray("products");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                String title = object.getString("title");
                String description = object.getString("description");
                double price = object.getDouble("price");
                int stock = object.getInt("stock");
                String exportacionProducto = String.format("title:%s price:%.2f stock:%d", title,price,stock);
                printWriter.println(exportacionProducto);
            }

            System.out.println("Exportacion completada");

        } catch (MalformedURLException e){
            System.out.println("Error en URL");
        }
        catch (IOException e) {
            System.out.println("Error en los permisos");
        }finally {
            try{
                printWriter.close();
            }catch (NullPointerException e){
                System.out.println("Error en el cerrado");
            }

        }


    }

    private void filtrarPrecio(int min, int max){
        try {
            URL url = new URL("https://dummyjson.com/products");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            //String lectura = bufferedReader.readLine();
            //JSONObject jsonObject = new JSONObject(lectura);
            JSONObject jsonObject = new JSONObject(bufferedReader.readLine());
            JSONArray jsonArray = jsonObject.getJSONArray("products");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject product = jsonArray.getJSONObject(i);
                double price = product.getDouble("price");
                if (price<max && price>min){
                    String title = product.getString("title");
                    String description = product.getString("description");
                    int stock = product.getInt("stock");
                    System.out.printf("El producto %s tiene como precio %.2f y una descripcion %s\n", title, price, description);
                    //System.out.println("El producto "+title+" tiene como precio "+price+" y una descripcion de "+description+"\n");
                }
            }

        } catch (MalformedURLException e) {
            System.out.println("No es una web, por favor intentalo de nuevo");
        } catch (IOException e) {
            System.out.println("Pagina web no responde");
        }
    }
}
