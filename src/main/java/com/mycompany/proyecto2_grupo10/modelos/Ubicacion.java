/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo10.modelos;

/**
 *
 * @author Ricardo Siavichay
 */
public class Ubicacion {
    private Double x;
    private Double y;

    public Ubicacion(Double x,Double y) {
        this.x=x;
        this.y=y;
    }
    
    public Double getX(){
        return x;
    }
    public Double getY(){
        return y;
    }
    
    public void setX(Double x){
        this.x=x;
    }
    public void setY(Double y){
        this.y=y;
    }
    
    
}
