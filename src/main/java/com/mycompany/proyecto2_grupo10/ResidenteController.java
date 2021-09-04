/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_grupo10;

import static Datos.DatosVisitantes.leerVisitantes;
import com.mycompany.proyecto2_grupo10.modelos.Casas;
import com.mycompany.proyecto2_grupo10.modelos.Residente;
import com.mycompany.proyecto2_grupo10.modelos.Vehiculos;
import com.mycompany.proyecto2_grupo10.modelos.Visitantes;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.UUID;
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
import javafx.scene.input.MouseEvent;
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
    private void RegistratNuevoVehiculo(ActionEvent event) throws IOException {
        FXMLLoader loader =  new FXMLLoader(App.class.getResource("registrarVehiculo.fxml"));
        Parent vistaResidente = loader.load();
        App.setRoot(vistaResidente);
        
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

    @FXML
    private void mostrarVehiculos(Event event) {
        vConstanteVehiculos.getChildren().clear();
        vVariableVehiculos.getChildren().clear();
        int cantidad=0;
        for (Vehiculos v: App.bd.getVehiculos()){
            if(v.getResidente().getUsuario().equals(residente.getUsuario())){
                cantidad+=1;
                Label lb1 = new Label();
                Label lb2 = new Label();
                Label lb3 = new Label();
                Label lb4 = new Label();
                lb1.setText("Vehiculo"+cantidad+" matricula: ");
                lb2.setText(v.getMatricula());
                lb3.setText("Vehiculo"+cantidad+" propietario: ");
                lb4.setText(v.getNombrePropietario());
                vConstanteVehiculos.getChildren().addAll(lb1,lb3);
                vVariableVehiculos.getChildren().addAll(lb2,lb4);
            }
        }
    }
    public ArrayList<Visitantes> filtrar(ArrayList<Visitantes> visitas){
    String inicio = fechaInicio.getText();
    String fin = fechaFin.getText();
    ArrayList<Visitantes> visititas= new ArrayList<>();
    for(Visitantes visit : visitas){ 
        //if(visit.getFinicio().toLocalDate().isBefore( LocalDate.parse(fin)) && visit.getFinicio().toLocalDate().isAfter( LocalDate.parse(inicio))){
            visititas.add(visit);
            }
    
       // }
    return visititas;
    }

    @FXML
    private void mostrarVisitas(MouseEvent event) throws IOException {
        ArrayList<Visitantes> visitas = filtrar(leerVisitantes());
        
        for(Visitantes v: visitas ){
            this.nombreVisitas.setText("hola");
            
            this.cedulaVIsitas.setText(v.getCedula());
            this.codigoVisitas.setText(UUID.randomUUID().toString().toUpperCase().substring(0,6));
            this.fechaInicio.setText(v.getFinicio().toLocalDate().toString());
            this.estadoVIsita.setText(String.valueOf(v.isEstado()));
    }
    }
}

