/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo10;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

/**
 * FXML Controller class
 *
 * @author Ricardo Siavichay
 */
public class SimulacionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void residente(ActionEvent event) {
        try{
            //1. creamos el FXML
            FXMLLoader loader = new FXMLLoader(App.class.getResource("simularResidente.fxml"));
            //2. cargar la vista
            Parent vistaSr = loader.load();
            //3. fijar el contenido en la scena
            App.setRoot(vistaSr);  
        }catch(IOException ex){
            System.out.println("No se ha podido cargar la vista");
                }
    }

    @FXML
    private void visitante(ActionEvent event) {
    }

}
