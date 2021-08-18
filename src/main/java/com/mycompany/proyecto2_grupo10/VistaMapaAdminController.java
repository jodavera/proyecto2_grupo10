/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo10;

import com.mycompany.proyecto2_grupo10.modelos.Casas;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
    private Pane panelAdmin;
    @FXML
    private VBox vResidente;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    
    
    @FXML
    private void mostrarMapa(ActionEvent event) {
        List<Casas> casas = Casas.cargarCasas();
       for (Casas c : casas){
           StackPane st = new StackPane();
           ImageView imgview = null;
           try{
              InputStream input = App.class.getResource( c.getTipo()).openStream();
              Image img = new Image(input, 100,100, true, true);
                imgview = new ImageView(img);
                }catch(NullPointerException | IOException ex){
                //no hay la imagen buscada
                System.out.println("No encontrada: "+c.getTipo());
                imgview = new ImageView();
                }
           Label l = new Label(c.getNombre());
           st.getChildren().addAll(imgview,l);
           
           //agregamos el st al mapa
           panelAdmin.getChildren().addAll(st);
           
           st.setLayoutX(c.getUbicacion().getX());
           st.setLayoutY(c.getUbicacion().getY());
           
           EventHandler eh = (event1) -> {
               vResidente.getChildren().clear();
               Label l1 = new Label("Residente: "+c.getResidente().getNombre());
               Label l2= new Label("Villa: "+c.getVilla());
               Label l3 = new Label("Manzana: "+ c.getManzana());
               vResidente.getChildren().addAll(l1,l2,l3);
           };
           EventHandler eh2 = (event2) -> {
               vResidente.getChildren().clear();
           };
           
           st.setOnMouseEntered(eh);
           st.setOnMouseExited(eh2);
           }
        }
}

