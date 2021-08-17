/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo10;

/**
 *
 * @author user
 */
class Vehiculos {
    private String matricula;
    private Residente resident;

    public Vehiculos(String matricula, Residente resident) {
        this.matricula = matricula;
        this.resident = resident;
    }

    public String getMatricula() {
        return matricula;
    }

    public Residente getResident() {
        return resident;
    }

    @Override
    public String toString() {
        return "Vehiculos{" + "matricula=" + matricula + ", resident=" + resident + '}';
    }
    
    
}
