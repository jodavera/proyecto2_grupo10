/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo10;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

import javafx.scene.layout.HBox;
/**
 * FXML Controller class
 *
 * @author Ricardo Siavichay
 */
public class SimularResidenteController implements Initializable {


    @FXML
    private HBox h1;
    @FXML
    private HBox h2;
    @FXML
    private Button vehiculo;
    @FXML
    private Button peaton;
    @FXML
    private Button ingresarBoton;
    
    Label l1 = new Label();
    Label l2 = new Label();
    TextField cedula = new TextField();
    TextField pin = new TextField();
    TextField placa = new TextField();
    static int estado;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void mostrarSpeaton(ActionEvent event) {
        h1.getChildren().clear();
        h2.getChildren().clear();
        l1.setText("Ingrese su numero de cedula: ");
        l2.setText("Ingrese su pin: ");
        h1.getChildren().addAll(l1,cedula);
        h2.getChildren().addAll(l2,pin);
        ingresarBoton.setVisible(true);
        estado=0;
    }

    @FXML
    private void mostrarSvehiculo(ActionEvent event) {
        h1.getChildren().clear();
        h2.getChildren().clear();
        l1.setText("Ingrese su numero de placa: ");
        h1.getChildren().addAll(l1,placa);
        ingresarBoton.setVisible(true);
        estado=1;
        
    }

    @FXML
    private void ingresar(ActionEvent event) {
        if (estado == 0){
            System.out.println("en peaton");
        }else{
            System.out.println("en vehiculo");
        }
    }
    
}
