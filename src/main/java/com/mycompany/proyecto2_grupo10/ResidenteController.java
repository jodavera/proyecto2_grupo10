/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo10;

import com.mycompany.proyecto2_grupo10.modelos.Casas;
import com.mycompany.proyecto2_grupo10.modelos.Residente;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
/**
 * FXML Controller class
 *
 * @author Ricardo Siavichay
 */
public class ResidenteController implements Initializable {


    @FXML
    private Label nombreResidente;
    @FXML
    private Label correoResidente;
    @FXML
    private Label manzanaResidente;
    @FXML
    private Label villaResidente;
    @FXML
    private VBox vConstanteVehiculos;
    @FXML
    private VBox vVariableVehiculos;
    @FXML
    private TextField fechaInicio;
    @FXML
    private TextField fechaFin;
    @FXML
    private TableColumn<?, ?> nombreVisitas;
    @FXML
    private TableColumn<?, ?> cedulaVIsitas;
    @FXML
    private TableColumn<?, ?> codigoVisitas;
    @FXML
    private TableColumn<?, ?> fechaVisita;
    @FXML
    private TableColumn<?, ?> estadoVIsita;
    
    private Residente residente;
    
    public void setResidente(Residente r){
        residente=r;
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        residente=LoginController.getRs();
        System.out.println(residente);
        nombreResidente.setText(residente.getNombre());
        correoResidente.setText(residente.getCorreo());
        manzanaResidente.setText(residente.getCasa().getManzana());
        villaResidente.setText(residente.getCasa().getVilla());
        
        // TODO
    }    
    
    @FXML
    private void CambiarPin(ActionEvent event) throws IOException {
        FXMLLoader loader =  new FXMLLoader(App.class.getResource("cambiarPin.fxml"));
        Parent vistaResidente = loader.load();
        App.setRoot(vistaResidente);
    }

    @FXML
    private void RegistratNuevoVehiculo(ActionEvent event) {
        
    }

    @FXML
    private void registrarVisita(ActionEvent event) {
    }

    @FXML
    private void buscarVisitas(ActionEvent event) {
    }

    @FXML
    private void salir(Event event) {
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

}
