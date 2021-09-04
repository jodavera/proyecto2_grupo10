/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo10;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Ricardo Siavichay
 */
public class VistaPrincipalController implements Initializable {

    @FXML
    private Button btinicio;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void iniciarSesion(MouseEvent event) throws IOException {
     App.setRoot("login");
    }

    @FXML
    private void simular(MouseEvent event) throws IOException {
       App.setRoot("simulacion"); 
    }
    
}
