/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import com.mycompany.proyecto2_grupo10.App;
import com.mycompany.proyecto2_grupo10.modelos.Residente;
import com.mycompany.proyecto2_grupo10.modelos.Usuario;
import com.mycompany.proyecto2_grupo10.modelos.Vehiculos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Ricardo Siavichay
 */
public class DatosVehiculos {
    static String ruta = RutaConstante.RUTAARCHIVOS+"/vehiculos.txt";
    
    public static ArrayList<Vehiculos> cargarDatosVehiculos() throws FileNotFoundException, IOException{
        ArrayList<Vehiculos> vehiculos = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader( new FileReader(ruta))){
            String linea;
            while((linea=bf.readLine())!=null){
                String[] datos = linea.split(",");
                for(Usuario u: DatosUsuarios.leerUsuarios()){
                    if(u instanceof Residente){
                        Residente r = (Residente)u;
                        if(r.getUsuario().equals(datos[2])){
                            Vehiculos v = new Vehiculos(datos[0], datos[1], r);
                            vehiculos.add(v);
                    }
                    }
                }
            }
        }catch(FileNotFoundException ex1){
            System.out.println("Archivo no encontrado");
        }catch(IOException ex2){
            System.out.println("Error en IOException");
        }
        return vehiculos;
    }
    
    public static void agregarNuevoVehiculos(String linea) throws IOException{
        try(BufferedWriter bf = new BufferedWriter(new FileWriter(ruta,true))){
            bf.write(linea);
            bf.newLine();
            bf.close();
        }catch(FileNotFoundException ex1){
            System.out.println("Archivo no encontrado");
        }catch(IOException ex2){
            System.out.println("Fallo IOException");
        }
    }
}
