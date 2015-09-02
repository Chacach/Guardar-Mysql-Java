/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;
import java.sql.*;
/**
 *
 * @author alexander
 */
public class conexion_consulta {
    static Connection conexion=null;
    static Statement sentencia;
    public static void conectar(){
        String ruta="jdbc:mysql://localhost/Prueba";
        String user="root";
        String pass="182411";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection(ruta,user,pass); 
            sentencia= conexion.createStatement();
            System.out.println("Conectado");
        } catch (Exception e) {
            System.out.println("No conectado");
        }
    }
    public static void guardar(variables x){
        String q = "INSERT INTO Datos VALUES('"+x.getNombre()+"','"+x.getApellido()+"')";
        ejecutar(q);
    }
    
    public static void ejecutar(String q){
        try {
            sentencia.executeUpdate(q);
            System.out.println("Correcto");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
  
}
