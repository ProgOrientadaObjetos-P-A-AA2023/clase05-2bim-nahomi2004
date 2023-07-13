/*
 * 
 * D - Dependency inversion principle (Principio de inversión de dependencias)
 */
package paquete11;

import java.util.ArrayList;
import java.util.Random;

public class Principal {
    public static void main(String[] args) {
        
        /*
        Usar el txt llamado usuarios.txt; por cada línea del archivo
        crer un API en función de su servicio; además el API ahora genera
        información estática (no cambia el API), se debe buscar la forma que el 
        API sea dinámico totalmente (usar alguna librería propia de JAVA, tipo 
        Random); la url final debe contener el tipo de servicio y el user
        Por cada objeto de tipo GeneradoPelicula presentar la información 
        a través de un toString
        */               
        Random rand = new Random();         
        int lim = 600000;
        
        
        // GeneradorPelicula gp = new GeneradorPelicula();        
        ArrayList<GeneradorPelicula> lista = new ArrayList<>();
        ArrayList<Usuario> user = new ArrayList<>();
        
        ArchivoLectura archivo = new ArchivoLectura();
        archivo.establecerLista();
        user = archivo.obtenerLista();
        archivo.cerrarArchivo();
        
        for (int i=0; i<user.size(); i++) {
            if (user.get(i).getServidor().equals("Netflix")) {
                APIMovie apii = new APINetflix();
                apii.establecerApiKey(String.valueOf(rand.nextInt(lim)));  
                GeneradorPelicula gp = new GeneradorPelicula(); 
                gp.establecerLlave(apii);
                gp.establecerUsuario(user.get(i));
                gp.establecerUrl("http://api.movieN=");
                lista.add(gp);
            } else if (user.get(i).getServidor().equals("Disney")) {
                APIMovie apii = new APIDisney();
                apii.establecerApiKey(String.valueOf(rand.nextInt(lim)));
                GeneradorPelicula gp = new GeneradorPelicula(); 
                gp.establecerLlave(apii);
                gp.establecerUsuario(user.get(i));
                gp.establecerUrl("http://api.movieD=");
                lista.add(gp);
            } else if (user.get(i).getServidor().equals("Amazon")) {
                APIMovie apii = new APIAmazonMovie();
                apii.establecerApiKey(String.valueOf(rand.nextInt(lim)));
                GeneradorPelicula gp = new GeneradorPelicula(); 
                gp.establecerLlave(apii);
                gp.establecerUsuario(user.get(i));
                gp.establecerUrl("http://api.movieA=");
                lista.add(gp);
            } else if (user.get(i).getServidor().equals("Startplus")) {
                APIMovie apii = new APIStarPlus();
                apii.establecerApiKey(String.valueOf(rand.nextInt(lim)));
                GeneradorPelicula gp = new GeneradorPelicula(); 
                gp.establecerLlave(apii);
                gp.establecerUsuario(user.get(i));
                gp.establecerUrl("http://api.movieS=");
                lista.add(gp);
            }
        }
        
        for (int i=0; i<user.size(); i++) {
            System.out.printf("%s",lista.get(i));
        }        
    }
}

/*APINetflix api1 = new APINetflix();
        api1.establecerApiKey(String.valueOf(rand.nextInt(upperbound)));
        APINetflix api2 = new APINetflix();
        api2.establecerApiKey(String.valueOf(rand.nextInt(upperbound)));
        APINetflix api3 = new APINetflix();
        api3.establecerApiKey(String.valueOf(rand.nextInt(upperbound)));
        
        APIDisneyPlus api4 = new APIDisneyPlus();
        api4.establecerApiKey(String.valueOf(rand.nextInt(upperbound)));
        APIDisneyPlus api5 = new APIDisneyPlus();
        api5.establecerApiKey(String.valueOf(rand.nextInt(upperbound)));
        APIDisneyPlus api6 = new APIDisneyPlus();
        api6.establecerApiKey(String.valueOf(rand.nextInt(upperbound)));


switch (user.get(i).getServidor()) {
                case ("Netflix") : {
                    apii = new APINetflix();
                    apii.establecerApiKey(String.valueOf(rand.nextInt(lim)));  
                    gp.establecerLlave(apii);
                    gp.establecerUsuario(user.get(i));
                    lista.add(gp);
                }
                case ("Disney") : {
                    apii = new APIDisney();
                    apii.establecerApiKey(String.valueOf(rand.nextInt(lim)));
                    gp.establecerLlave(apii);
                    gp.establecerUsuario(user.get(i));
                    lista.add(gp);
                }
                case ("Amazon") : {
                    apii = new APIAmazonMovie();
                    apii.establecerApiKey(String.valueOf(rand.nextInt(lim)));
                    gp.establecerLlave(apii);
                    gp.establecerUsuario(user.get(i));
                    lista.add(gp);
                }
                case ("Startplus") : {
                    apii = new APIStarPlus();
                    apii.establecerApiKey(String.valueOf(rand.nextInt(lim)));
                    gp.establecerLlave(apii);
                    gp.establecerUsuario(user.get(i));
                    lista.add(gp);
                }
            }*/