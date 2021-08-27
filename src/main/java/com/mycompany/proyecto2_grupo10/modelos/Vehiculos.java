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
public class Vehiculos {
    private String matricula;
    private String nombrePropietario;
    private Residente residente;

    
    public Vehiculos(String matricula, String nombrePropietario,Residente residente){
        this.matricula=matricula;
        this.nombrePropietario=nombrePropietario;
        this.residente=residente;
    }

    public String getMatricula() {
        return matricula;
    }
    public Residente getResidente() {
        return residente;
    }
    public String getNombrePropietario(){
        return nombrePropietario;
    }
    
    public void setResidente(Residente r){
        residente=r;
    }

    @Override
    public String toString() {
        return "matricula: " + matricula + " , propietario: "+nombrePropietario+ ", residente:" +residente ;
    }
    
    
}
