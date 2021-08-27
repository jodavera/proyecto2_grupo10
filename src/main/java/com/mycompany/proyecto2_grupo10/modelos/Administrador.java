/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo10.modelos;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Administrador extends Usuario{
    private String nombre;

    

    public Administrador(String usuario, String clave,String nombre) {
        super(usuario, clave);
        this.nombre=nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    

   



    
    
    
}
