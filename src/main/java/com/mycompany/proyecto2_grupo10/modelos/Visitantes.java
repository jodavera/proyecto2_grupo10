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
    private String Correo;
    private boolean estado;
    private LocalDateTime Finicio;
    private String  Pin;

    public Visitantes(String nombre, String cedula,String Pin, LocalDateTime Finicio,boolean estado ) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.estado = estado;
        this.Finicio = Finicio;
        this.Pin = Pin;
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

    public String getCodigoAcceso() {
        return codigoAcceso;
    }

    public void setCodigoAcceso(String codigoAcceso) {
        this.codigoAcceso = codigoAcceso;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
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
        return "Visitantes:" + "nombre=" + nombre + ", cedula=" + cedula + ", codigoAcceso=" + codigoAcceso + ", Correo=" + Correo + ", estado=" + estado + ", Finicio=" + Finicio  + ", Pin=" + Pin ;
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
