/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete08;

/**
 *
 * @author reroes
 */
public interface EvaluacionTipoDos {
    
    public void establecerPromedioEnsayo();
    public double obtenerPromedioEnsayo();
    // En las interfaces no puedo generar ningun metodo
    // ademas, los metodos solo se pueden establecer, asi como en la clase 
    // abstracta, pero sin la palabra abstract
    
    // Las clases que implementen la interface tienen la obligacion de darle 
    // cuerpo a TODOS los metodos
    
    // Estrcuturas que tienen metodos que no tienen cuerpo, eso son las 
    // interfaces
}
