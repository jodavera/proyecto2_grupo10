/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import com.mycompany.proyecto2_grupo10.modelos.Administrador;
import com.mycompany.proyecto2_grupo10.App;
import com.mycompany.proyecto2_grupo10.modelos.Residente;
import com.mycompany.proyecto2_grupo10.modelos.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
                    if (partes.length == 7) {
                        if (partes[5].equals("admin")) {
                            usu.add(new Administrador(partes[1], partes[3]));
                        } else {
                            if (partes[5].equals("residente")) {
                                usu.add(new Residente(partes[0],partes[2], partes[1], partes[3],partes[6]));
                                System.out.println(usu);
                            }
                        }
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
}
