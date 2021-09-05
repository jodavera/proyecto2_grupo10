/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Correo;
import com.mycompany.proyecto2_grupo10.modelos.Residente;
import com.mycompany.proyecto2_grupo10.modelos.Visitantes;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Ricardo Siavichay
 */
public class Correo {
    public static boolean correo(String asunto, String mensaje,String correo) throws  MessagingException{
        try{
            Properties p= new Properties();
            p.setProperty("mail.smtp.host","smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.setProperty("mail.smtp.port", "587");
            p.setProperty("mail.smtp.user","proyecto.poo1t@gmail.com");
            p.setProperty("mail.smtp.auth", "true");
            
            Session s =Session.getDefaultInstance(p,null);
            BodyPart texto= new MimeBodyPart();
            texto.setText(mensaje);
            MimeMultipart m= new MimeMultipart();
            m.addBodyPart(texto);
            MimeMessage mens= new MimeMessage(s);
            try{
            mens.setFrom(new InternetAddress("proyecto.poo1t@gmail.com"));
            mens.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
            mens.setSubject(asunto);
            mens.setContent(m);
            Transport t = s.getTransport("smtp");
            t.connect("proyecto.poo1t@gmail.com", "proyectopoo1");
            t.sendMessage(mens, mens.getRecipients(Message.RecipientType.TO));
            t.close();

            System.out.println("Correo enviado");
            return true;
        } catch(MessagingException e){
            System.out.println("Error"+e);
            System.out.println("No se pudo enviar el correo");
            return false;
        }
        } catch (AddressException ex1){
            System.out.println("Error en la direccion de correo");
        }catch (MessagingException ex2){
            System.out.println("Error en el menaje");
        }
        System.out.println("Correo enviado");
        return true;
        
    }
        
    public static void enviarCorreo(Residente r) throws MessagingException{
        String asunto;
        String mensaje;
        asunto="Usted se ha registrado como un residente de la Urbanizacion Nuevo Mundo\n A continuacion podra acceder a su Usuario, Contrasena y Pin que debera emplear.";
            mensaje="Su nombre de usuario es: "+r.getUsuario()+" Con clave: "+r.getClave()+" Y Pin de seguridad: "+r.getPin();
            System.out.println(mensaje);
            System.out.println(r.getCorreo());
            correo(asunto,mensaje,r.getCorreo());
            System.out.println("Correo enviado");
            }
        public static void enviarCorreo(Visitantes v) throws MessagingException{
        String asunto;
        String mensaje;
        asunto="Usted se ha registrado como un visitante";
            mensaje="Su pin de acceso es:" +v.getPin()+" Con visita al residente de usaurio: "+v.getResidente();
            System.out.println(mensaje);
            System.out.println(v.getCorreo());
            correo(asunto,mensaje,v.getCorreo());
            System.out.println("Correo enviado");
            }
        
}
