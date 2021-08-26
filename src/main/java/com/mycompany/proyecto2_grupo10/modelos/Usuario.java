/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo10.modelos;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author user
 */
public class Usuario {
    private String usuario;
    private String clave;

    public Usuario(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }
    public Usuario(){
        
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }


    @Override
    public String toString() {
        return "usuario=" + usuario + ", clave=" + clave ;
    }
    

  @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof Usuario) {
                Usuario other = (Usuario) obj;
                if (usuario.equals(other.getUsuario()) && clave.equals(other.getClave())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public  Usuario buscarUsuario(ArrayList<Usuario> usuarios, Usuario u){
    if(u!= null){
        for (Usuario usu : usuarios){
          if (u.equals(usu)){
            return usu;
          }
        }
    }
    return null;
    }
    
    public static String generarNombreClaveUsuario() {
    int numero = (int) (Math.random()*10+5);
    Random r = new Random(); // Intialize a Random Number Generator with SysTime as the seed 
    StringBuilder sb = new StringBuilder(numero); 
    for(int i = 0; i < numero; i++) { // For each letter in the word 
     char tmp = (char) ('a' + r.nextInt('z' - 'a')); // Generate a letter between a and z 
     sb.append(tmp); // Add it to the String 
    } 
    return sb.toString(); 
}  
} 
    
    

