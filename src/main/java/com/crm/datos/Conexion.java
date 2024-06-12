/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crm.datos;

import jakarta.activation.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 * La clase Conexion es un ejemplo de cómo se puede implementar la conexión a una 
 * base de datos MySQL utilizando el framework Apache Commons DBCP2
 */
public class Conexion {

    //Parámetros de la base de datos
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/crm-db?useSSL=false&useTimezone=true&serverTimeZone=UTC&allowPublicKeyRetrival=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";
    
    //Objeto para gestionar la conexión a la base de datos
    private static BasicDataSource dataSource;

    /**
     * Método para gestionar la conexión a la base de datos. Si el objeto no ha 
     * sido inicializado antes, se crea un nuevo objeto y se configura con la URL, 
     * nombre de usuario y contraseña proporcionados.
     */
    public static BasicDataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASSWORD);
            dataSource.setInitialSize(50);
        }
        return dataSource;
    }

    /**
     * Método para devolver una conexión a la base de datos utilizando el objeto 
     * BasicDataSource. Si no hay una conexión disponible, se crea una nueva.
     */
    public static Connection getConnection() throws SQLException {
        //return getDataSource().getConnection();
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Driver MySQL no encontrado", e);
        }
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/crm-db", JDBC_USER, JDBC_PASSWORD);
    }

    /*
     * Es importante cerrar los objetos Connection, PreparedStatement y ResultSet 
     * por las siguientes razones:
     * 
     * Liberar recursos del sistema y la base de datos.
     * Evitar errores de "too many connections" (demasiadas conexiones).
     * Mejorar la seguridad y evitar acceso no autorizado a la base de datos.
     * Evitar errores de "ResultSet closed" (ResultSet cerrado) o "ResultSet already closed" (ResultSet ya cerrado).
     */
    
    public static void Close(ResultSet rs) {
        try {
            rs.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
    public static void Close(PreparedStatement stmt) {
        try {
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
    public static void Close(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

}
