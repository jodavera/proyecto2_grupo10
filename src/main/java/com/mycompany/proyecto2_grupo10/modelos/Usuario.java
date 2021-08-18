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
    
}
    

