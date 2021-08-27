/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo10;

import com.mycompany.proyecto2_grupo10.App;
import com.mycompany.proyecto2_grupo10.modelos.Administrador;
import com.mycompany.proyecto2_grupo10.modelos.Casas;
import com.mycompany.proyecto2_grupo10.modelos.Residente;
import com.mycompany.proyecto2_grupo10.modelos.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class LoginController implements Initializable {

    @FXML
    private PasswordField txtclaves;
    @FXML
    private Button btlogins;
    @FXML
    private TextField txtusuario;
    @FXML
    private static Scene sc;
    
    static Residente rs;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void mostrarEleccion(MouseEvent event) throws IOException {
        
       
       String usu = txtusuario.getText();
       usu=usu.replaceAll(" ","");
       String password= txtclaves.getText();
       password=password.replaceAll(" ","");
        
       try{
            
            if ((password.length()) == 0 &&(usu.length() == 0)) {
                throw new NullPointerException("no puede dejar campos vacios");
                
            }else{
                if (password.length() == 0) {
                    throw new NullPointerException("Contraseña no puede er vacio");
                }
                else{
                if (usu.length() == 0) {
                    throw new NullPointerException("Usuario no puede ir vacio");
                }
            }}}catch(NullPointerException e){
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
            
                Parent root = fxmlLoader.load();
           //cree el scene y fije como nodo raiz el objeto que cargo con el fxml
           Scene scene = new Scene(root);
                VBox v = new VBox(new Label(e.getMessage()));
                e.getStackTrace();
                scene = new Scene(v);
                Stage stage = new Stage();
                stage.setScene(scene);

                 //muestre la aplicacion
                stage.show();
            }
       /// Validacion
       Usuario u= new Usuario(usu,password);
        System.out.println(usu);
        System.out.println(password);
        System.out.println(u.toString());
       Usuario c=u.buscarUsuario(App.bd.getUsuarios(),u);
       
       
       if(c== null){
           VBox error= new VBox(new Label("Credencial Incorrecta"));
           sc= new Scene(error);
           Stage escenario= new Stage();
           escenario.setScene(sc);
           escenario.show();
       }
       else{
           if(c instanceof Residente){

                rs = (Residente)c;
                for(Casas casa: App.bd.getCasa()){
                    if(casa.getResidente().getUsuario()!=null){
                        if(casa.getResidente().getUsuario().equals(rs.getUsuario())){
                            rs.setCasa(casa);
                        }
                        
                    }
                }
                FXMLLoader loader =  new FXMLLoader(App.class.getResource("residente.fxml"));
                Parent vistaResidente = loader.load();
                App.setRoot(vistaResidente);
           
           }
           else if(c instanceof Administrador){
           App.setRoot("VistaMapaAdmin");
           }
    }
       
       
    }

    public PasswordField getTxtclaves() {
        return txtclaves;
    }

    public Button getBtlogins() {
        return btlogins;
    }

    public TextField getTxtusuarios() {
        return txtusuario;
    }

    public static Scene getSc() {
        return sc;
    }

    public static Residente getRs() {
        return rs;
    }
    
}
