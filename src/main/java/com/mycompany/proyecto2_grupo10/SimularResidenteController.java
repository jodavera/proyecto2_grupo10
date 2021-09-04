/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo10;

import com.mycompany.proyecto2_grupo10.modelos.Usuario;
import com.mycompany.proyecto2_grupo10.modelos.Residente;
import com.mycompany.proyecto2_grupo10.modelos.Vehiculos;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
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
        int encontrado=0;
        Alert a = new Alert(Alert.AlertType.ERROR);
        Alert b = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Error");
        b.setTitle("Aviso");
        ArrayList<Usuario> usuarios = App.bd.getUsuarios();
        if (estado == 0){
            encontrado=0;
            System.out.println("en peaton");
            if(cedula.getLength()!=0 && pin.getLength()!=0){
                for (Usuario u:usuarios){
                    if(u instanceof Residente){
                        Residente r = (Residente) u;
                        if(r.getCedula().equals(cedula.getText()) && r.getPin().equals(pin.getText())){
                            encontrado=1;
                            cedula.clear();
                            pin.clear();
                            b.setContentText("Ah ingresado de manera exitosa");
                            b.show();}
                    }
                }
                if(encontrado==0){
                    a.setContentText("Los datos ingresados son incorrectos");
                    a.showAndWait();
                }
            }else{
                a.setContentText("Los campos no pueden ser vacios");
                a.showAndWait();
            }
            
        }else{
            System.out.println("en vehiculo");
            ArrayList<Vehiculos> vehiculos = App.bd.getVehiculos();
            if(placa.getLength()!=0){
                for (Vehiculos v:vehiculos){
                    if(v.getMatricula().equals(placa.getText())){
                        encontrado=1;
                        placa.clear();
                        b.setContentText("Ah ingresado de manera exitosa");
                        b.show();
                    }
                }
                if(encontrado==0){
                    a.setContentText("Los datos ingresados son incorrectos");
                    a.showAndWait();
            }   
            }else{
                a.setContentText("Los campos no pueden ser vacios");
                a.showAndWait();
        }
    }
    
    }

    @FXML
    private void volver(ActionEvent event) {
        try{
            //1. creamos el FXML
            FXMLLoader loader = new FXMLLoader(App.class.getResource("simulacion.fxml"));
            //2. cargar la vista
            Parent vistaSimular = loader.load();
            //3. fijar el contenido en la scena
            App.setRoot(vistaSimular);  
        }catch(IOException ex){
            System.out.println("No se ha podido cargar la vista");
        }
    }
}
