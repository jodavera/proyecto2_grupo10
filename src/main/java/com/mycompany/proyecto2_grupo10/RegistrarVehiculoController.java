/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo10;

import com.mycompany.proyecto2_grupo10.modelos.Residente;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;

import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author Ricardo Siavichay
 */
public class RegistrarVehiculoController implements Initializable {


    @FXML
    private TextField matriculaCarro;
    @FXML
    private TextField propietarioCarro;
    
    private Residente residente;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        residente=LoginController.getRs();
        CambiarPinController.limitTextField(matriculaCarro, 8);
        // TODO
    }    
    
    @FXML
    private void registrarCarro(ActionEvent event) throws IOException {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error");
        Alert b = new Alert(Alert.AlertType.INFORMATION);
        if(matriculaCarro.getLength()==0 || propietarioCarro.getLength()==0){
            a.setContentText("Los campos no pueden ser vacios");
            a.showAndWait();
        }else{
            try{
                Integer valor = Integer.valueOf(propietarioCarro.getText());
                a.setContentText("El nombre del propietario no pueden ser numeros");
                a.showAndWait();
            }catch(IllegalArgumentException ex){
            String linea= matriculaCarro.getText()+","+propietarioCarro.getText()+","+residente.getUsuario();
            App.bd.agregarVehiculoBD(linea);
            b.setTitle("Aviso");
            b.setContentText("Vehiculo registrado con exito");
            b.showAndWait();
            matriculaCarro.clear();
            propietarioCarro.clear();
            }
        }
        
    }

    @FXML
    private void volver(ActionEvent event) throws IOException {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Aviso");
        a.setContentText("Volviendo a los datos del residente");
        a.showAndWait();
        FXMLLoader loader =  new FXMLLoader(App.class.getResource("residente.fxml"));
        Parent vistaResidente = loader.load();
        App.setRoot(vistaResidente);
    }

}
