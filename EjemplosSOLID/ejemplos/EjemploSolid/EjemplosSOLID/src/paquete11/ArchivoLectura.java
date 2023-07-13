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
import java.util.Random;

/**
 *
 * @author reroes
 */
public class ArchivoLectura {

    private Scanner entrada;
    private String nombreArchivo;
    private String rutaArchivo;
    private ArrayList<Usuario> lista;

    public ArchivoLectura () {
        nombreArchivo = "usuarios.txt";
        rutaArchivo = String.format("datos/%s", nombreArchivo);
        File f = new File(rutaArchivo); // data/profesores.txt
        if (f.exists()) {
            try {
                entrada = new Scanner(new File(rutaArchivo));
            }
            catch (FileNotFoundException e) {
                System.err.println("Error al leer del archivo: " + e);

            } // fin de catch
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = "usuarios.txt";
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
        Usuario u;
        
        if (f.exists()) {

            while (entrada.hasNext()) {
                String linea = entrada.nextLine();

                ArrayList<String> linea_partes = new ArrayList<>(
                        Arrays.asList(linea.split(";")));
                
                u = new Usuario(linea_partes.get(1), linea_partes.get(2));
                lista.add(u);                
            }
        }
    }

    public ArrayList<Usuario> obtenerLista() {
        return lista;
    }

    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close();
        }
    }    
}
/*

                if (linea_partes.get(2).equals("Netflix")) {
                    u = new Usuario(linea_partes.get(1), linea_partes.get(2));
                    lista.add(u);
                }
                if (linea_partes.get(2).equals("Startplus")) {
                    u = new Usuario(linea_partes.get(1), linea_partes.get(2));
                    lista.add(u);
                }                
                if (linea_partes.get(2).equals("Amazon")) {
                    u = new Usuario(linea_partes.get(1), linea_partes.get(2));
                    lista.add(u);
                }
                if (linea_partes.get(2).equals("Disney")) {
                    u = new Usuario(linea_partes.get(1), linea_partes.get(2));
                    lista.add(u);
                }
*/
