/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo10.modelos;

import java.time.LocalDateTime;

/**
 *
 * @author user
 */
public class Visitantes implements Comparable <Visitantes> {
    private String nombre;
    private String cedula;
    private String codigoAcceso;
    private String correo;
    private boolean estado;
    private LocalDateTime Finicio;
    private String  Pin;
    private String Ussresidente;
    
    public Visitantes(){
        
    }

    public Visitantes(String nombre, String cedula,String Pin, LocalDateTime Finicio,boolean estado,String correo,String r ) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.estado = estado;
        this.Finicio = Finicio;
        this.Pin = Pin;
        this.correo=correo;
        Ussresidente=r;
    }
        public Visitantes(String nombre, String cedula, LocalDateTime Finicio, String correo, String uss ) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.estado = false;
        this.Finicio = Finicio;
        this.correo = correo;
        Ussresidente=uss;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    public String getResidente(){
        return Ussresidente;
    }

    public String getCodigoAcceso() {
        return codigoAcceso;
    }

    public void setCodigoAcceso(String codigoAcceso) {
        this.codigoAcceso = codigoAcceso;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String Correo) {
        this.correo = Correo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public LocalDateTime getFinicio() {
        return Finicio;
    }

    public void setFinicio(LocalDateTime Finicio) {
        this.Finicio = Finicio;
    }
    
    public String getPin() {
        return Pin;
    }

    public void setPin(String Pin) {
        this.Pin = Pin;
    }

    @Override
    public String toString() {
        return "Visitantes:" + "nombre=" + nombre + ", cedula=" + cedula + ", codigoAcceso=" + codigoAcceso + ", Correo=" + correo + ", estado=" + estado + ", Finicio=" + Finicio  + ", Pin=" + Pin ;
    }
    
    
    @Override
    public int compareTo(Visitantes o) {  // es necesario el local date, ya que es innecesario el tiempo en el grafico de vistas vs dia
        if(o.getFinicio().toLocalDate().isAfter(Finicio.toLocalDate()) ){
            return -1;
        }else if(o.getFinicio().toLocalDate().isEqual(Finicio.toLocalDate())){
            return 0;            
        }else{
        return 1;
        }  
    }
}
