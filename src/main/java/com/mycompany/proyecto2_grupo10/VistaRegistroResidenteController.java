/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo10;

import Correo.Correo;
import Datos.DatosCasas;
import Datos.RutaConstante;
import com.mycompany.proyecto2_grupo10.modelos.Casas;
import com.mycompany.proyecto2_grupo10.modelos.Residente;
import com.mycompany.proyecto2_grupo10.modelos.Usuario;
import java.io.FileNotFoundException;
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
import javafx.scene.control.ComboBox;

import javafx.scene.control.TextField;
import javax.mail.MessagingException;
/**
 * FXML Controller class
 *
 * @author Ricardo Siavichay
 */
public class VistaRegistroResidenteController implements Initializable {


    @FXML
    private TextField nombreResidente;
    @FXML
    private TextField correoResidente;
    @FXML
    private ComboBox<String> generoResidente;
    @FXML
    private Button Bregistro;
    @FXML
    private Button BcancelarRe;
    
    private Casas casaSeleccionada;
    
    
    static String ruta = RutaConstante.RUTAARCHIVOS+"/usuarios.txt";
    @FXML
    private TextField cedulaResidente;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        generoResidente.getItems().addAll("masculino","femenino");
        CambiarPinController.limitTextField(cedulaResidente, 10);
    }

    public void setCasaSeleccionada(Casas c){
        casaSeleccionada=c;
    }
    
    @FXML
    private void enviarRegistro(ActionEvent event) throws FileNotFoundException, IOException {
        //verificamos que toda la informacion halla sido ingresada correctamente
            Alert a = new Alert(Alert.AlertType.ERROR);
            Alert b = new Alert(Alert.AlertType.INFORMATION);
                if ((nombreResidente.getText().length()) == 0 || (correoResidente.getText().length() == 0 ) || (generoResidente.getValue()==null) || cedulaResidente.getLength()==0) {
                a.setTitle("Error");
                a.setContentText("Los datos no del residente no pueden ser vacios");
                a.showAndWait();}else{
        //verificacion que el nombre no sea un numero
        int numero1;
        int numero2;
        try{
        numero2= Integer.valueOf(cedulaResidente.getText());
        if(cedulaResidente.getLength()==10){
        try{
        numero1 = Integer.valueOf(nombreResidente.getText());
        a.setTitle("Error");
        a.setContentText("El nombre del usuario no puede ser un numero");
        a.showAndWait(); 
        
        }catch(IllegalArgumentException ex1){

        ArrayList<Usuario>  usuarios = App.bd.getUsuarios();
        int bandera=0;
        
        //generamos el nombre de usuario unico el cual va a ser aleatorio
        String usuarioUsuario="";
        while(bandera==0){
            usuarioUsuario= Usuario.generarNombreClaveUsuario();
            for(Usuario u:usuarios){
                if (u instanceof Residente){
                        Residente r = (Residente)u;
                        if(!r.getUsuario().equals(usuarioUsuario)){
                        bandera=1;
                        }
                    }   
            }
        }
        
        //generamos la contrasena que tambien sera aleatoria
        String clave = Usuario.generarNombreClaveUsuario();
        
        //Generamos el pin unico de usuario
        String pin="";
        bandera = 0;
        while(bandera==0){
            int generador = (int)(Math.random()*9999+1000);
            pin+=generador;
            for (Usuario u: usuarios){
                if (u instanceof Residente){
                    Residente r = (Residente)u;
                    if(!r.getPin().equals(pin)){
                    bandera=1;
                    }
                }   
            }
        }
        
        String linea = pin+","+usuarioUsuario+","+nombreResidente.getText()+","+clave+","+correoResidente.getText()+","+"residente"+","+generoResidente.getValue()+","+cedulaResidente.getText();
        
        //Creamos el nuevo residente y lo agregamos al a base de datos y archivos
        Residente nuevoResidente=App.bd.agregarResidenteBD(linea);
        
        //Ubicamos el residente a la casa seleccionada
        App.bd.actualizarCasaBD(casaSeleccionada, nuevoResidente);
        DatosCasas.actualizarCasas(App.bd.getCasa());
        
        try {
                Correo.enviarCorreo( nuevoResidente);
                //Mostramos en pantalla la informacion
        b.setTitle("Informacion de Registro");
        b.setContentText("El residente "+nombreResidente.getText()+ " ah sido agregado satisfactoriamente\n"+"Codigo de casa de registro: "+casaSeleccionada.getCodigo());
        b.show();
        
        //Regresamos a la pantalla mapa
        try{
            //1. creamor el FXML
            FXMLLoader loader = new FXMLLoader(App.class.getResource("VistaMapaAdmin.fxml"));
            //2. cargar la vista
            Parent vistaMapa = loader.load();
            //3. fijar el contenido en la scena
            App.setRoot(vistaMapa);
           
            
        }catch(IOException ex){
            System.out.println("No se ha podido cargar la vista");
                }
        } catch (MessagingException ex) {
                a.setTitle("Error");
                a.setContentText("No se pudo enviar el mensaje, verifique la informacion del correo");
                a.showAndWait();
            }
        }}else{
            a.setTitle("Error");
            a.setContentText("La cedula debe contener 10 numeros");
            a.showAndWait();
        }
    
        } catch(IllegalArgumentException ex2){
            a.setTitle("Error");
            a.setContentText("El numero de cedula son numeros!");
            a.showAndWait(); 
            
        }
        

    }
    }

    @FXML
    private void cancelarRegistro(ActionEvent event) {
        nombreResidente.clear();
        correoResidente.clear();
        Alert b = new Alert(Alert.AlertType.INFORMATION);
        try{
            b.setTitle("Registro candelado");
            b.setContentText("Usted ha cancelado el registro de residente en esta casa");
            b.showAndWait();
            //1. creamos el FXML
            FXMLLoader loader = new FXMLLoader(App.class.getResource("VistaMapaAdmin.fxml"));
            //2. cargar la vista
            Parent vistaMapa = loader.load();
            //3. fijar el contenido en la scena
            App.setRoot(vistaMapa);  
        }catch(IOException ex){
            System.out.println("No se ha podido cargar la vista");
                }
    }
    
    
}