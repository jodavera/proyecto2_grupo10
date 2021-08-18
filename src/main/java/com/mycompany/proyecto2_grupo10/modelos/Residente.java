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
    
    public Residente(){
        super();
    }
    public Residente(String usuario, String clave, String correo,String pin, ArrayList<Vehiculos> vehiculo ) {
        super(usuario, clave);
        this.pin = pin;
        this.correo = correo;
        this.vehiculo = vehiculo;
    }

    public Residente(String pin, String nombre, String usuario, String clave) {
        super(usuario, clave);
        this.pin = pin;
        this.nombre = nombre;
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


    public ArrayList<Vehiculos> getVehiculo() {
        return vehiculo;
    }

   

    @Override
    public String toString() {
        return "pin=" + pin + ", correo=" + correo +", vehiculo=" + vehiculo;
    }
    
    
}
