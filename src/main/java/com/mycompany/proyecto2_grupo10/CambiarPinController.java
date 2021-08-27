/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo10;


import com.mycompany.proyecto2_grupo10.modelos.Usuario;
import Datos.DatosUsuarios;
import com.mycompany.proyecto2_grupo10.modelos.Residente;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Ricardo Siavichay
 */
public class CambiarPinController implements Initializable {

    @FXML
    private TextField pinActual;
    @FXML
    private TextField pinNuevo;
    @FXML
    private TextField pinConfirmar;
    
    private Residente residente;
    
    public void setResidente(Residente r){
        residente=LoginController.getRs();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        residente=LoginController.getRs();
        CambiarPinController.limitTextField(pinNuevo, 4);
        CambiarPinController.limitTextField(pinActual, 4);
        CambiarPinController.limitTextField(pinConfirmar, 4);
        
        // TODO
    }    

    @FXML
    private void cambiarPin(ActionEvent event) throws IOException {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        Alert b = new Alert(Alert.AlertType.ERROR);
        System.out.println(residente);
        if(pinActual.getText().length()==0 || pinNuevo.getText().length()==0 || pinConfirmar.getText().length()==0){
            b.setTitle("Eror");
            b.setContentText("Los campos no pueden ser vacios");
            b.showAndWait(); 
            
        }else{
            if(residente.getPin().equals(pinActual.getText())){
                System.out.println("Si soy el pin actual");
                if(pinNuevo.getText().equals(pinConfirmar.getText())){
                    App.bd.actualizarPinUsuarioBD(residente, pinNuevo.getText());
                    DatosUsuarios.actualizarUsuarios(App.bd.getUsuarios());
                    a.setTitle("Exito");
                    a.setContentText("Cambio de Pin realizado con exito");
                    a.showAndWait();
                    pinActual.clear();;
                    pinNuevo.clear();
                    pinConfirmar.clear();
                }else{
                    b.setTitle("Eror");
                    b.setContentText("Los Pines no coinciden");
                    b.showAndWait();                }
            }else{
                    b.setTitle("Eror");
                    b.setContentText("El Pin ingresado es incorrecto");
                    b.showAndWait();
            }
        }
    }


    @FXML
    private void volverResidente(ActionEvent event) throws IOException {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Aviso");
        a.setContentText("Volviendo a los datos del residente");
        a.showAndWait();
        FXMLLoader loader =  new FXMLLoader(App.class.getResource("residente.fxml"));
        Parent vistaResidente = loader.load();
        App.setRoot(vistaResidente);
    }

    @FXML
    private void largoPinN(KeyEvent event) {
    }

    @FXML
    private void largoPinA(KeyEvent event) {
    }

    @FXML
    private void largoPinC(KeyEvent event) {
    }
    

    public static void limitTextField(TextField textField, int limit) {
        UnaryOperator<Change> textLimitFilter = change -> {
            if (change.isContentChange()) {
                int newLength = change.getControlNewText().length();
                if (newLength > limit) {
                    String trimmedText = change.getControlNewText().substring(0, limit);
                    change.setText(trimmedText);
                    int oldLength = change.getControlText().length();
                    change.setRange(0, oldLength);
                }
            }
            return change;
        };
        textField.setTextFormatter(new TextFormatter(textLimitFilter));
    }         

}
