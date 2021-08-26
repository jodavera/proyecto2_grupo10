/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo10.modelos;


/**
 *
 * @author user
 */
public class Casas {
    private String villa;
    private String manzana;
    private Residente residente;
    private Ubicacion ubicacion;
    private String tipo;
    private String codigo;
    
    public Casas(){
        
    }
    
    public Casas(String v, String m, Residente r,String t, Ubicacion u,String n){
        villa=v;
        manzana=m;
        residente=r;
        ubicacion=u;
        tipo=t;
        codigo=n;
        
    }
    
    public String getVilla(){
        return villa;
    }
    public String getManzana(){
        return manzana;
    }
    public Residente getResidente(){
        return residente;
    }
    public Ubicacion getUbicacion(){
        return ubicacion;
    }
    public String getTipo(){
        return tipo;
    }
    public String getCodigo(){
        return codigo;
    }
    
    public void setResidente(Residente r){
        residente=r;
    }
    
     @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof Casas) {
                Casas other = (Casas) obj;
                if (codigo.equals(other.getCodigo())) {
                    return true;
                }
            }
        }
        return false;
    }
}
