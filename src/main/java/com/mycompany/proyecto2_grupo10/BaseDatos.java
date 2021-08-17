/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo10;

import Datos.DatosUsuarios;
import com.mycompany.proyecto2_grupo10.Casas;
import com.mycompany.proyecto2_grupo10.Usuario;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class BaseDatos {
    private ArrayList<Casas> casa;
    private ArrayList<Usuario> usuarios;
    public ArrayList<Casas> getCasa() {
        return casa;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    public BaseDatos () throws IOException{
        usuarios = DatosUsuarios.leerUsuarios();
    }
    
}
