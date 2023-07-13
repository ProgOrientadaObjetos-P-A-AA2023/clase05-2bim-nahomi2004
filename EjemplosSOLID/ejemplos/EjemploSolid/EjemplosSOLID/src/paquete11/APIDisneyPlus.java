/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete11;

/**
 *
 * @author D E L L
 */
public class APIDisneyPlus implements APIMovie {
    private String apiKey;
    
    @Override
    public void establecerApiKey(String ak){
        apiKey = ak+"DISNEYPLUS123123";
    }
    
    @Override
    public String obtenerApiKey(){
        return apiKey;
    } 
}
