/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo10.modelos;

import Datos.DatosCasas;
import Datos.DatosUsuarios;
import Datos.DatosVehiculos;
import com.mycompany.proyecto2_grupo10.App;
import java.io.IOException;
import java.util.ArrayList;



/**
 *
 * @author user
 */
public class BaseDatos {
    private ArrayList<Casas> casa;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Vehiculos> vehiculos;
    
    public BaseDatos () throws IOException{
        try{
        usuarios = DatosUsuarios.leerUsuarios();
        casa = DatosCasas.cargarCasas();
        vehiculos = DatosVehiculos.cargarDatosVehiculos();
        } catch( IOException ex){
            System.out.println("error");
            System.out.println(ex.getMessage());
            
        }
    }
    
    public ArrayList<Casas> getCasa() {
        return casa;
    }
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    public ArrayList<Vehiculos> getVehiculos(){
        return vehiculos;
    }
    
    
    //Metodos de usuarios en la base de datos
    public Residente agregarResidenteBD(String linea) throws IOException {
        DatosUsuarios.registrarNuevoUsuario(linea);
        String[] datos = linea.split(",");
        Usuario nuevoResidente = new Residente(datos[0],datos[1], datos[2], datos[3],datos[4],datos[6]);
        usuarios.add(nuevoResidente);
        Residente r = (Residente) nuevoResidente;
        r.setCorreo(datos[4]);
        return r;
    }
    public void actualizarPinUsuarioBD(Usuario u, String PIN){
        usuarios.remove(u);
        if (u instanceof Residente){
            Residente r = (Residente)u;
            r.setPin(PIN);
            usuarios.add(r);
        }
        
    }
    
    //Metodos de casas en la base de datos
    public void actualizarCasaBD(Casas casasActualizar,Usuario u){
        casa.remove(casasActualizar);
        System.out.println(casa);
        if (u instanceof Residente){
            Residente r = (Residente)u;
            casasActualizar.setResidente(r);
        }
        casa.add(casasActualizar); 
    }
    public void actualizarCasaBD(Casas casasActualizar,Double x,Double y){
        casa.remove(casasActualizar);
        casasActualizar.setUbicacion(x,y);
        casa.add(casasActualizar); 
    }

    //Metodos de vehiculos en la base de datos
    public void agregarVehiculoBD(String linea) throws IOException{
        DatosVehiculos.agregarNuevoVehiculos(linea);
        vehiculos=DatosVehiculos.cargarDatosVehiculos();
    }
}
