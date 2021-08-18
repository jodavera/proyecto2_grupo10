/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo10.modelos;

import com.mycompany.proyecto2_grupo10.App;
import com.mycompany.proyecto2_grupo10.modelos.Visitantes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
    private String nombre;
    
    public Casas(String v, String m, Residente r,String t, Ubicacion u,String n){
        villa=v;
        manzana=m;
        residente=r;
        ubicacion=u;
        tipo=t;
        nombre=n;
        
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
    public String getNombre(){
        return nombre;
    }
    
    public static List<Casas> cargarCasas() {
        
        String ruta = "Casas.txt";
        List<Casas> casas = new ArrayList<>();
        try(InputStream input = App.class.getResource(ruta).openStream();
                BufferedReader bf = new BufferedReader(
                                    new InputStreamReader(input,"UTF-8"))){
            String linea;
            while((linea = bf.readLine())!=null){
                System.out.println(linea);
                String[] p = linea.split(",");
                String[] u = p[4].split(":");
                Ubicacion ubicacion = new Ubicacion(Double.valueOf(u[0]),Double.valueOf(u[1]));
                Residente residente = new Residente("1111","correo","correo","correo",null);
                Casas c = new Casas(p[0],p[1],residente,p[3],ubicacion,p[2]);
                casas.add(c);
            }         
        }  catch (IOException ex) {
            System.out.println("no se pudo cargar la informacion de las tiendas");
            ex.printStackTrace();
        }
        return casas;
    }
}
