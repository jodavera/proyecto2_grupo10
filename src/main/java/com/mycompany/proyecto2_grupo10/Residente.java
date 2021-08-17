/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo10;

import com.mycompany.proyecto2_grupo10.Usuario;
import com.mycompany.proyecto2_grupo10.Vehiculos;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Residente extends Usuario{
    private String pin;
    private String correo;
    private Casas casa;
    private ArrayList<Vehiculos> vehiculo;
    private String nombre ;

    public Residente(String usuario, String clave, String correo,String pin, Casas casa, ArrayList<Vehiculos> vehiculo ) {
        super(usuario, clave);
        this.pin = pin;
        this.correo = correo;
        this.casa = casa;
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

    public Casas getCasa() {
        return casa;
    }

    public ArrayList<Vehiculos> getVehiculo() {
        return vehiculo;
    }

   

    @Override
    public String toString() {
        return "pin=" + pin + ", correo=" + correo + ", casa=" + casa + ", vehiculo=" + vehiculo;
    }
    
    
}
