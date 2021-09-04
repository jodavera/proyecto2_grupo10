/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo10;

import Datos.DatosCasas;
import Datos.DatosVisitantes;
import com.mycompany.proyecto2_grupo10.modelos.Casas;
import com.mycompany.proyecto2_grupo10.modelos.Visitantes;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Ricardo Siavichay
 */
public class VistaMapaAdminController implements Initializable{


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
        panelAdmin.setVisible(true);
        ArrayList<Casas> casas = DatosCasas.cargarCasas();
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
           Label l = new Label(c.getCodigo());
           st.getChildren().addAll(imgview,l);
           
           //agregamos el st al mapa
           panelAdmin.getChildren().addAll(st);
           
           st.setLayoutX(c.getUbicacion().getX());
           st.setLayoutY(c.getUbicacion().getY());
           
           EventHandler eh = (event1) -> {
               vResidente.getChildren().clear();
               Label l1 = new Label("Nombre Residente: "+c.getResidente().getNombre());
               Label l4 = new Label ("Usuario Residente: "+c.getResidente().getUsuario());
               Label l2= new Label("Villa: "+c.getVilla());
               Label l3 = new Label("Manzana: "+ c.getManzana());
               
               vResidente.getChildren().addAll(l1,l4,l2,l3);
           };
           EventHandler eh2 = (event2) -> {
               vResidente.getChildren().clear();
           };
           EventHandler eh3 = (event3) -> {
               System.out.println(c.getResidente());
               if (c.getResidente().getUsuario()==null){
               
               try{
            //1. create an FXMLLoader object and store in it the result of the statement
            FXMLLoader loader = new FXMLLoader(App.class.getResource("VistaRegistroResidente.fxml"));

            //2. cargar la vista
            Parent vistaRegistro = loader.load();
            VistaRegistroResidenteController cs = loader.<VistaRegistroResidenteController>getController();
            cs.setCasaSeleccionada(c);
            //3. fijar el contenido en la scena
            App.setRoot(vistaRegistro);
           
            
        }catch(IOException ex){
            System.out.println("No se ha podido cargar la vista");
            System.out.println("VistaAgradecimiento.fxml");
                }
            }
        };
           
           EventHandler eh4 = (event4) -> {
               st.startFullDrag();
               Double x = st.getLayoutX();
               Double y = st.getLayoutY();
               c.setUbicacion(x, y);
               try {
                   DatosCasas.actualizarCasas(casas);
                   App.bd.actualizarCasaBD(c, x, y);
                   
               } catch (IOException ex) {
                   ex.printStackTrace();
               }
               
           };
           st.setOnMouseEntered(eh);
           st.setOnMouseExited(eh2);
           st.setOnMouseClicked(eh3);
           st.setOnMouseDragEntered(eh4);
           }
        }
    
    public void mouseDragged(MouseEvent e){
        
    }

    @FXML
    private void cerrarSesion(ActionEvent event) {
        Alert b = new Alert(Alert.AlertType.INFORMATION);
         try{
            b.setTitle("Aviso");
            b.setContentText("Cierre de sesion satisfactorio");
            b.showAndWait();
            //1. creamos el FXML
            FXMLLoader loader = new FXMLLoader(App.class.getResource("VistaPrincipal.fxml"));
            //2. cargar la vista
            Parent vistaMapa = loader.load();
            //3. fijar el contenido en la scena
            App.setRoot(vistaMapa);  
        }catch(IOException ex){
            System.out.println("No se ha podido cargar la vista");
                }
    }

    @FXML
    private void mostrarReporte(ActionEvent event) throws IOException {
         panelAdmin.setVisible(true);
         ArrayList<Visitantes> visitas = DatosVisitantes.leerVisitantes();
         
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> grafico = new BarChart<String,Number>(xAxis,yAxis);
        grafico.setTitle("Cuantas Visitas entran por dia");
        XYChart.Series series1= new XYChart.Series();
        series1.setName("Vistas x Dia");
        for (Visitantes visi: visitas){
            String nombre=visi.getNombre();
             series1.getData().add(new XYChart.Data(nombre,visi.getFinicio()));
        }   
        grafico.getData().addAll(series1);
    }
}