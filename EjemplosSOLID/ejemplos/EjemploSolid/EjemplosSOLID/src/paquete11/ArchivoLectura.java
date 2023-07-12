/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author reroes
 */
public class ArchivoLectura {

    private Scanner entrada;
    private String nombreArchivo;
    private String rutaArchivo;
    private ArrayList<APIMovie> lista;
    // Este une a lo que descuartizamos y leerlo

    public ArchivoLectura () {
        nombreArchivo = "usuarios.txt";
        rutaArchivo = String.format("data/%s", nombreArchivo);
        // data/profesores.txt
        File f = new File(rutaArchivo); // data/profesores.txt
        if (f.exists()) {
            try {
                entrada = new Scanner(new File(rutaArchivo));
                // entrada = new Scanner(System.in);
                // entrada = new Scanner(f);
            } // fin de try
            catch (FileNotFoundException e) {
                System.err.println("Error al leer del archivo: " + e);

            } // fin de catch
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerRutaArchivo() {
        rutaArchivo = String.format("data/%s.txt",
                obtenerNombreArchivo());;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public String obtenerRutaArchivo() {
        return rutaArchivo;
    }

    public void establecerLista() {
        lista = new ArrayList<>();
        File f = new File(rutaArchivo);

        if (f.exists()) {

            while (entrada.hasNext()) {
                String linea = entrada.nextLine();

                ArrayList<String> linea_partes = new ArrayList<>(
                        Arrays.asList(linea.split(";"))
                );
                
                APIMovie p = new APIMovie(linea_partes.get(0),
                        linea_partes.get(1));
                lista.add(p);

            } // fin de while
        }
    }

    public ArrayList<APIMovie> obtenerLista() {

        return lista;
    }

    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close();
        } // cierra el archivo

    }

    @Override
    public String toString() {
        String cadena = "Lista Profesores\n";
        for (int i = 0; i < obtenerLista().size(); i++) {
            Profesor profTemporal = obtenerLista().get(i); // Obj. Profesor
            cadena = String.format("%s(%d) %s %s\n", cadena,
                    i + 1,
                    profTemporal.obtenerNombre(), // obtenerLista().get(i).obtenerNombre(),
                    profTemporal.obtenerTipo());    // obtenerLista().get(i).obtenerTipo());
        }
        return cadena;
    }    
    // arreglo.length es para los estáticos, arreglo.size es para los dinámicos
}
}