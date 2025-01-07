package dao;

import model.Coche;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CochesDAO {
    private static final String FICHERO_DAT = "coches.dat";
    private List<Coche> coches;

    public CochesDAO() {
        coches = new ArrayList<>();
        leerCoches();
    }

    public void leerCoches() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO_DAT))) {
            coches = (ArrayList<Coche>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, se creará uno nuevo al terminar el programa.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void escribirCoches() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO_DAT))) {
            oos.writeObject(coches);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void anadirCoche(Coche coche) {
        coches.add(coche);
    }

    public void borrarCoche(int id) {
        coches.removeIf(coche -> coche.getId() == id);
    }

    public Coche consultarCoche(int id) {
        return coches.stream().filter(coche -> coche.getId() == id).findFirst().orElse(null);
    }

    public List<Coche> listarCoches() {
        return coches;
    }

}
