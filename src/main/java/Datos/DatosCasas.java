/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import com.mycompany.proyecto2_grupo10.App;
import com.mycompany.proyecto2_grupo10.modelos.Casas;
import com.mycompany.proyecto2_grupo10.modelos.Residente;
import com.mycompany.proyecto2_grupo10.modelos.Ubicacion;
import com.mycompany.proyecto2_grupo10.modelos.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *InputStream input = App.class.getResource(ruta).openStream();
                BufferedReader bf = new BufferedReader(
                                    new InputStreamReader(input,"UTF-8"))
 * @author Ricardo Siavichay
 */


public class DatosCasas {
    static String ruta = RutaConstante.RUTAARCHIVOS+"/Casas.txt";
    
    public static ArrayList<Casas> cargarCasas() {
        ArrayList<Casas> casas = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader(ruta))){
            String linea;
            while((linea = bf.readLine())!=null){
                System.out.println(linea);
                String[] p = linea.split(",");
                String[] u = p[4].split(":");
                Ubicacion ubicacion = new Ubicacion(Double.valueOf(u[0]),Double.valueOf(u[1]));
                Residente residente = new Residente();
                ArrayList<Usuario> usuarios = DatosUsuarios.leerUsuarios();
                Casas c = new Casas(p[0],p[1],residente,p[3],ubicacion,p[2]);
                for (Usuario us : usuarios){
                    if(us.getUsuario().equals(p[5])){
                        if(us instanceof Residente){
                        Residente r = (Residente) us;
                        c = new Casas(p[0],p[1],r,p[3],ubicacion,p[2]);
                        }
                    }}  
                
                casas.add(c);  
        }}  catch (IOException ex) {
            System.out.println("no se pudo cargar la informacion de las casas");
            ex.printStackTrace();
        }
        return casas;
    }
    
    public static void actualizarCasas(ArrayList<Casas> casas) throws IOException{

        try ( BufferedWriter bf = new BufferedWriter(new FileWriter(ruta,false))) {
                    for (Casas c:casas){
                        String linea=c.getVilla()+","+c.getManzana()+","+c.getCodigo()+","+c.getTipo()+","+c.getUbicacion().getX()+":"+c.getUbicacion().getY()+","+c.getResidente().getUsuario();
                        bf.write(linea);
                        bf.newLine();}
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
