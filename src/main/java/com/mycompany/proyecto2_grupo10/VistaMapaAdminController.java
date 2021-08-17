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

import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
/**
 * FXML Controller class
 *
 * @author Ricardo Siavichay
 */
public class VistaMapaAdminController implements Initializable {


    @FXML
    private MenuItem VerMapa;
    @FXML
    private MenuItem VerReporte;
    @FXML
    private MenuItem Salir;
    @FXML
    private Pane panelMapa;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void mostrarMapa(ActionEvent event) {
    }

}
