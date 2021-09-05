/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo10;

import Correo.Correo;
import Datos.DatosVisitantes;
import com.mycompany.proyecto2_grupo10.modelos.Residente;
import com.mycompany.proyecto2_grupo10.modelos.Visitantes;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.mail.MessagingException;
/**
 * FXML Controller class
 *
 * @author Ricardo Siavichay
 */
public class RegistrarVisitanteController implements Initializable {


    @FXML
    private TextField nombreVisitante;
    @FXML
    private TextField cedulaVisitante;
    @FXML
    private TextField correoVisitante;
    @FXML
    private TextField fechaVisita;
    @FXML
    private Button Volver;
    
    Residente residente;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    residente=LoginController.getRs();
        Alert b  = new Alert(Alert.AlertType.INFORMATION);
        b.setTitle("Aviso");
        b.setContentText("El formato de la fecha de visita debe ser AA-MM-DD+T+HH:MM");
        b.showAndWait();
// TODO
    }    
    
    @FXML
    private void registrar(ActionEvent event) throws MessagingException, IOException {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error");
        Alert b  = new Alert(Alert.AlertType.INFORMATION);
        b.setTitle("Aviso");
        Visitantes v = new Visitantes();
        if(nombreVisitante.getLength()!=0 && cedulaVisitante.getLength()!=0 && fechaVisita.getLength()!=0 && correoVisitante.getLength()!=0){
        v = new Visitantes(nombreVisitante.getText(),cedulaVisitante.getText(),LocalDateTime.parse(fechaVisita.getText()),correoVisitante.getText(),residente.getUsuario());
        String pin ="";
        int generador = (int)(Math.random()*9999999+10000000);
        pin+=generador;
        v.setPin(pin);
        try{
        Correo.enviarCorreo(v);
        String linea = v.getNombre()+","+v.getCedula()+","+v.getPin()+","+"activo,"+fechaVisita.getText()+","+v.getCorreo()+","+residente.getUsuario();
        try{
        DatosVisitantes.registrarNuevoVisitante(linea);
        b.setContentText("Visita registrada con exito");
        b.showAndWait();}
        catch(IOException ex2 ){
            a.setContentText("Error al agregar al visitante");
            a.showAndWait();
        }
        }catch(MessagingException ex){
            a.setContentText("Error al enviar el correo");
            a.showAndWait();
        }
        }else{
            a.setContentText("Los recuadros no pueden ir vacios");
            a.showAndWait();
        }
        nombreVisitante.clear();
        fechaVisita.clear();
        cedulaVisitante.clear();
        correoVisitante.clear();
        
    }

    @FXML
    private void volver(ActionEvent event) throws IOException {
        FXMLLoader loader =  new FXMLLoader(App.class.getResource("residente.fxml"));
        Parent vistaResidente = loader.load();
        App.setRoot(vistaResidente);
    }

}
