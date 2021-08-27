package com.mycompany.proyecto2_grupo10;

import com.mycompany.proyecto2_grupo10.modelos.BaseDatos;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    public static BaseDatos bd;
    private static Scene scene;
    
    public void init ()throws IOException{
        System.out.println("En el init");
        System.out.println("Aqui aun no entramos al start");
        bd=new BaseDatos();
    }
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("VistaPrincipal"), 900, 750);
        stage.setScene(scene);
        stage.setTitle("Urbanización");
        stage.show();
    }
    static void setRoot(Parent root) {
        scene.setRoot(root);
    }
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    

}