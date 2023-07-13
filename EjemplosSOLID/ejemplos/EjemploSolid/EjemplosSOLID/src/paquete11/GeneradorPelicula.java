/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GeneradorPelicula {
    
    private APIMovie llave;
    private String url;
    private ArrayList<String> urls = new ArrayList<>();    
    private String user;    
    private String nombreArchivo;
    private String rutaArchivo;
    private Scanner entrada;    
    // agregar un user (tipo String)
    
    public void establecerLlave(APIMovie l){ // APINetflix, APIAmazon
        llave = l;
    }
    
    public void establecerUrls(){
        String nombreArchivo = "usuarios.txt";
        String rutaArchivo = String.format("datos/%s", nombreArchivo);
        
        File f = new File(rutaArchivo);
        APIMovie apii;
        Random rand = new Random();         
        int lim = 600000;
        
        for (int i=0; i<f.length(); i++) {
            if (i>=0 && i<3) {
                apii = new APINetflix();
                apii.establecerApiKey(String.valueOf(rand.nextInt(lim)));  
                establecerLlave(apii);
            } else if (i>=3 && i<6) {
                apii = new APIDisneyPlus();
                apii.establecerApiKey(String.valueOf(rand.nextInt(lim)));
                establecerLlave(apii);
            } else if (i>=6 && i<9) {
                apii = new APIAmazonMovie();
                apii.establecerApiKey(String.valueOf(rand.nextInt(lim)));
                establecerLlave(apii);
            } else if (i>=9 && i<12) {
                apii = new APIStarPlus();
                apii.establecerApiKey(String.valueOf(rand.nextInt(lim)));
                establecerLlave(apii);
            }
            establecerUrl("http://api.movie?api=");
            urls.add(obtenerUrl());
        }
    }
    
    public void establecerUrl(String l){
        url = String.format("%s%s", l, obtenerLlave().obtenerApiKey());
    } 
    
    public APIMovie obtenerLlave(){
        return llave;
    }
    
    public String obtenerUrl(){
        return url;
    }
    
    public ArrayList<String> obtenerUrls(){
        return urls;
    }
    
    @Override
    public String toString () {        
        nombreArchivo = "usuarios.txt";
        rutaArchivo = String.format("datos/%s", nombreArchivo);
        
        File f = new File(rutaArchivo);
        String cadena = String.format("");
        
        if (f.exists()) {
            try {
                entrada = new Scanner(new File(rutaArchivo));
                cadena = String.format("Lista:\n");                    
                int i=0;
                if (f.exists()) {
                    while (entrada.hasNext()) {

                        String linea = entrada.nextLine();

                        ArrayList<String> linea_partes = new ArrayList<>(
                                Arrays.asList(linea.split(";")));

                        user = linea_partes.get(1);

                        cadena = String.format("%s\n[%s] %s - %s - %s",
                                cadena,
                                linea_partes.get(0),
                                user,
                                linea_partes.get(2),
                                obtenerUrls().get(i));
                        i++;
                    }
                }                
            }
            catch (FileNotFoundException e) {
                System.err.println("Error al leer del archivo: " + e);
            }
        }        
        return cadena;
    }    
}

/* public void establecerUser () {
        nombreArchivo = "usuarios.txt";
        rutaArchivo = String.format("datos/%s", nombreArchivo);
        
        File f = new File(rutaArchivo);

        if (f.exists()) {

            while (entrada.hasNext()) {
                
                String linea = entrada.nextLine();

                ArrayList<String> linea_partes = new ArrayList<>(
                        Arrays.asList(linea.split(";"))
                );
                
                user = linea_partes.get(1);
                users.add(user);
            } // fin de while
        }
    }
    
    public ArrayList<String> obtenerUsuario() {
        return users;
    } */
    