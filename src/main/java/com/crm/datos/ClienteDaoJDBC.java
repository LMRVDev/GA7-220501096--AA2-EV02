/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crm.datos;

import java.util.List;
import com.crm.dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * La clase ClienteDaoJDBC es un ejemplo de un Data Access Object (DAO) que se 
 * encarga de interactuar con una base de datos MySQL utilizando JDBC. El DAO se 
 * encarga de realizar operaciones CRUD (Create, Read, Update, Delete) sobre la 
 * tabla customer de la base de datos.
 */
public class ClienteDaoJDBC {

    private static final String SQL_SELECT = "SELECT id, address, city, name, neighborhood, phone_number FROM customer";

    private static final String SQL_SELECT_BY_ID = "SELECT id, address, city, name, neighborhood, phone_number FROM customer WHERE id=?";

    private static final String SQL_INSERT = "INSERT INTO customer(address, city, name, neighborhood, phone_number) VALUES(?, ?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE customer SET address=?, city=?, name=?, neighborhood=?, phone_number=? WHERE id=?";

    private static final String SQL_DELETE = "DELETE FROM customer WHERE id=?";
    
    
    /**
     * Devuelve una lista de objetos Cliente que corresponden a los registros de 
     * la tabla customer. El método conecta a la base de datos, ejecuta una 
     * consulta SQL para seleccionar todos los registros y los itera para crear 
     * objetos Cliente.
     */
    public List<Cliente> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<Cliente>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idCliente = rs.getInt("id");
                String direccion = rs.getString("address");
                String ciudad = rs.getString("city");
                String nombre = rs.getString("name");
                String barrio = rs.getString("neighborhood");
                String telefono = rs.getString("phone_number");
                
                System.out.println(nombre + " " + ciudad + " " + telefono);

                Cliente cliente = new Cliente(idCliente, direccion, ciudad, nombre, barrio, telefono);

                clientes.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.Close(rs);
            Conexion.Close(stmt);
            Conexion.Close(conn);
        }

        return clientes;
    }

    /**
     * Devuelve un objeto Cliente que coincide con el identificador proporcionado. 
     * El método conecta a la base de datos, ejecuta una consulta SQL para 
     * seleccionar el registro que coincide con el identificador y devuelve el 
     * objeto Cliente correspondiente.
     */
    public Cliente buscar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, cliente.getId());
            rs = stmt.executeQuery();
            rs.next();

            String direccion = rs.getString("address");
            String ciudad = rs.getString("city");
            String nombre = rs.getString("name");
            String barrio = rs.getString("neighborhood");
            String telefono = rs.getString("phone_number");

            cliente.setAddress(direccion);
            cliente.setCity(ciudad);
            cliente.setName(nombre);
            cliente.setNeighborhood(barrio);
            cliente.setPhone_number(telefono);

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.Close(rs);
            Conexion.Close(stmt);
            Conexion.Close(conn);
        }

        return cliente;
    }

    /**
     * Inserta un nuevo registro en la tabla customer. El método conecta a la 
     * base de datos, prepara una sentencia SQL para insertar un nuevo registro 
     * y ejecuta la sentencia.
     */
    public int insertar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, cliente.getAddress());
            stmt.setString(2, cliente.getCity());
            stmt.setString(3, cliente.getName());
            stmt.setString(4, cliente.getNeighborhood());
            stmt.setString(5, cliente.getPhone_number());
            
            rows = stmt.executeUpdate(); 

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.Close(stmt);
            Conexion.Close(conn);
        }

        return rows;
    }
    
    /**
     * Actualiza un registro existente en la tabla customer. El método conecta 
     * a la base de datos, prepara una sentencia SQL para actualizar un registro 
     * y ejecuta la sentencia.
     */
    public int actualizar(Cliente cliente){
         Connection conn = null;
        PreparedStatement stmt = null;

        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, cliente.getAddress());
            stmt.setString(2, cliente.getCity());
            stmt.setString(3, cliente.getName());
            stmt.setString(4, cliente.getNeighborhood());
            stmt.setString(5, cliente.getPhone_number());
            stmt.setInt(6, cliente.getId());
            
            rows = stmt.executeUpdate(); 

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.Close(stmt);
            Conexion.Close(conn);
        }

        return rows;
    }
    
    /**
     * Elimina un registro existente en la tabla customer. El método conecta a 
     * la base de datos, prepara una sentencia SQL para eliminar un registro y 
     * ejecuta la sentencia.
     */
    public int eliminar(Cliente cliente){
         Connection conn = null;
        PreparedStatement stmt = null;

        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, cliente.getId());
            
            rows = stmt.executeUpdate(); 

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.Close(stmt);
            Conexion.Close(conn);
        }

        return rows;
    }
    
    public static void main(String[] args) {
        ClienteDaoJDBC clientes = new ClienteDaoJDBC();
        clientes.listar();
        
    }

}
