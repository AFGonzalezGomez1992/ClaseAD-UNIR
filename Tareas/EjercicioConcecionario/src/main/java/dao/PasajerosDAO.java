package dao;

import model.Pasajero;

import java.io.*;
import java.util.*;

public class PasajerosDAO {
    private static final String FICHERO_DAT = "pasajeros.dat";
    private List<Pasajero> pasajeros;
    private Map<Integer, List<Pasajero>> cochePasajeros;

    public PasajerosDAO() {
        pasajeros = new ArrayList<>();
        cochePasajeros = new HashMap<>();
        leerPasajeros();
    }

    public void leerPasajeros() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO_DAT))) {
            pasajeros = (ArrayList<Pasajero>) ois.readObject();
            cochePasajeros = (HashMap<Integer, List<Pasajero>>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, se creará uno nuevo al terminar el programa.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void escribirPasajeros() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO_DAT))) {
            oos.writeObject(pasajeros);
            oos.writeObject(cochePasajeros);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void anadirPasajero(Pasajero pasajero) {
        pasajeros.add(pasajero);
    }

    public void borrarPasajero(int id) {
        pasajeros.removeIf(pasajero -> pasajero.getId() == id);
        cochePasajeros.values().forEach(lista -> lista.removeIf(pasajero -> pasajero.getId() == id));
    }

    public Pasajero consultarPasajero(int id) {
        return pasajeros.stream().filter(pasajero -> pasajero.getId() == id).findFirst().orElse(null);
    }

    public List<Pasajero> listarPasajeros() {
        return pasajeros;
    }

    public void anadirPasajeroACoche(int idPasajero, int idCoche) {
        Pasajero pasajero = consultarPasajero(idPasajero);
        if (pasajero != null) {
            cochePasajeros.computeIfAbsent(idCoche, k -> new ArrayList<>()).add(pasajero);
        }
    }

    public void eliminarPasajeroDeCoche(int idPasajero, int idCoche) {
        List<Pasajero> pasajerosDelCoche = cochePasajeros.get(idCoche);
        if (pasajerosDelCoche != null) {
            pasajerosDelCoche.removeIf(pasajero -> pasajero.getId() == idPasajero);
        }
    }

    public List<Pasajero> listarPasajerosDeCoche(int idCoche) {
        return cochePasajeros.getOrDefault(idCoche, Collections.emptyList());
    }
}
