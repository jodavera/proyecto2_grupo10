/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import static Datos.DatosCasas.ruta;
import com.mycompany.proyecto2_grupo10.modelos.Administrador;
import com.mycompany.proyecto2_grupo10.App;
import com.mycompany.proyecto2_grupo10.modelos.Casas;
import com.mycompany.proyecto2_grupo10.modelos.Residente;
import com.mycompany.proyecto2_grupo10.modelos.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class DatosUsuarios {
    static String ruta = RutaConstante.RUTAARCHIVOS+"/usuarios.txt";
    public static ArrayList<Usuario> leerUsuarios() throws IOException {
        ArrayList<Usuario> usu = new ArrayList<>();
            try ( BufferedReader bf = new BufferedReader(new FileReader(ruta))) {
                String linea;
                while ((linea = bf.readLine()) != null) {
                    System.out.println(linea);
                    String[] partes = linea.split(",");
                    if (partes.length == 3) {
                            usu.add(new Administrador(partes[0], partes[1],partes[2]));
                        } else {
                                usu.add(new Residente(partes[0],partes[1], partes[2], partes[3],partes[4],partes[6]));
                                System.out.println(usu);
                        }
                    }
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
                throw ex;
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                throw ex;
            }
        System.out.println(usu);
        return usu;
    }
    
    public static void registrarNuevoUsuario(String linea) throws IOException{
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
    
        public static void actualizarUsuarios(ArrayList<Usuario> usuarios) throws IOException{
             try ( BufferedWriter bf = new BufferedWriter(new FileWriter(ruta,false))) {
                    for (Usuario u: usuarios){
                        if( u instanceof Residente){
                            Residente r = (Residente)u;
                        String linea= r.getPin()+","+r.getUsuario()+","+r.getNombre()+","+r.getClave()+","+r.getCorreo()+",residente,"+r.getGenero();
                        bf.write(linea);
                        bf.newLine();
                        } else {
                            Administrador a = (Administrador)u;
                            String linea = a.getUsuario()+","+a.getClave()+","+a.getNombre();
                            bf.write(linea);
                            bf.newLine();
                        }
                    }
                        bf.close();
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
    
    

