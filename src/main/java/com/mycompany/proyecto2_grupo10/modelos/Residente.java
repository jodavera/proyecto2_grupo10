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
public class Residente extends Usuario{
    private String pin;
    private String correo;
    private ArrayList<Vehiculos> vehiculo;
    private String nombre ;
    private Casas casa;
    private String genero;
    private String cedula;
    
    public Residente(){
        super();
    }
    public Residente(String usuario, String clave, String correo,String pin, ArrayList<Vehiculos> vehiculo ) {
        super(usuario, clave);
        this.pin = pin;
        this.correo = correo;
        this.vehiculo = vehiculo;
    }

    public Residente(String pin, String usuario, String nombre, String clave) {
        super(usuario, clave);
        this.pin = pin;
        this.nombre = nombre;
    }
    
    public Residente(String pin, String usuario, String nombre, String clave,String correo,String genero,String cedula) {
        super(usuario, clave);
        this.pin = pin;
        this.nombre = nombre;
        this.genero=genero;
        this.correo=correo;
        this.cedula=cedula;
    }



    
    

    public String getPin() {
        return pin;
    }
    public String getCorreo() {
        return correo;
    }
    public String getNombre(){
        return nombre;
    }
    public Casas getCasa(){
        return casa;
    }
    public String getGenero(){
        return genero;
    }
    public String getCedula(){
        return cedula;
    }
    
    public void setCasa(Casas c){
        casa=c;
    }
    public void setCorreo(String c){
        correo=c;
    }
    public void setPin(String p){
        pin=p;
    }

    public ArrayList<Vehiculos> getVehiculo() {
        return vehiculo;
    }

   

    @Override
    public String toString() {
        return "pin=" + pin + ", correo=" + correo +", vehiculo=" + vehiculo;
    }
    
}
