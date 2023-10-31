package com.example.myapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionBD {

    private static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/CrearCuenta";
    private static final String USER = "postgres";
    private static final String PASS = "brissa08";
    private Connection conexion;

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Error al establecer la conexión");
        }
    }

    protected void cerrarConexion(Connection con) throws Exception{
       con.close();
    }
}
