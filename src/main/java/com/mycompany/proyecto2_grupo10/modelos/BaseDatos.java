/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo10.modelos;

import Datos.DatosCasas;
import Datos.DatosUsuarios;
import java.io.IOException;
import java.util.ArrayList;



/**
 *
 * @author user
 */
public class BaseDatos {
    private ArrayList<Casas> casa;
    private ArrayList<Usuario> usuarios;
    
    public BaseDatos () throws IOException{
        try{
        usuarios = DatosUsuarios.leerUsuarios();
        casa = DatosCasas.cargarCasas();} catch( IOException ex){
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
    
    public Residente agregarResidenteBD(String linea) throws IOException {
        DatosUsuarios.registrarNuevoUsuario(linea);
        String[] datos = linea.split(",");
        Usuario nuevoResidente = new Residente(datos[0],datos[1], datos[2], datos[3],datos[6]);
        usuarios.add(nuevoResidente);
        Residente r = (Residente) nuevoResidente;
        return r;
    }
    
    public void actualizarCasa(Casas casasActualizar,Usuario u){
        casa.remove(casasActualizar);
        System.out.println(casa);
        if (u instanceof Residente){
            Residente r = (Residente)u;
            casasActualizar.setResidente(r);
        }
        casa.add(casasActualizar);
        
    }
    
}
