/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.io.IOException;
import java.util.ArrayList;
import com.mycompany.proyecto2_grupo10.modelos.Visitantes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.io.IOException;
/**
 *
 * @author user
 */
public class DatosVisitantes {
    static String ruta = RutaConstante.RUTAARCHIVOS+"/Visitantes.txt";
    
    public static ArrayList<Visitantes> leerVisitantes() throws IOException {
        ArrayList<Visitantes> visi = new ArrayList<>();
            try ( BufferedReader bf = new BufferedReader(new FileReader(ruta))) {
                String linea;
                while ((linea = bf.readLine()) != null) {
                    System.out.println(linea);
                    String[] partes = linea.split(",");
                    if (partes.length == 6) {
                        LocalDateTime fechaInicio= LocalDateTime.parse(partes[3]);
                        
                        visi.add(new Visitantes(partes[0], partes[1],partes[2],fechaInicio,Boolean.parseBoolean(partes[4]),partes[5],partes[6]));
                        
                       }
                    }
              } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
                throw ex;
          
            }
        System.out.println(visi);
        return visi;
    }
    
    public static void registrarNuevoVisitante(String linea) throws IOException{
            try ( BufferedWriter bf = new BufferedWriter(new FileWriter(ruta,true))) {
                        bf.write(linea);
                        bf.newLine();
                        bf.close();
                        System.out.println("residente registrado con exito");
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Archivo no encontrado");
                throw ex;
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Error aqui"); 
                throw ex;
            }
    }
}
