/*
 * 
 * D - Dependency inversion principle (Principio de inversión de dependencias)
 */
package paquete11;

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
        
        GeneradorPelicula gp = new GeneradorPelicula();        
        gp.establecerUrls();
        System.out.printf("%s",gp);
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
        api6.establecerApiKey(String.valueOf(rand.nextInt(upperbound)));*/