package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
    Clase "cDatos"
    Objetivo: Clase creada para simplificar las funciones al conectarse con
        la base de datos del tipo MySQL
 */
public class cDatos {

    private static final String JDBC_DB_NAME = "prueba";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/" + JDBC_DB_NAME + "?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Emo10blanco+";
    private Statement estancia;

    /*
        Metodo "Conecta"
        Descripcion: Metodo empleado para validar los datos del usuario que quiere
            crear una conexion con el gestor MySQL
        Entrada: No recibe ningun parametro
        Salida: Regresa un objeto del tipo Connection, es decir,
            me regresa todo lo necesario para saber como conectarme con 
            la base de datos del tipo MySQL
        Execpciones:
            Al intentar ejecutar este metodo puede que haya errores "execpciones" del tipo SQLException
            dicha excepcion será tratada en el try catch cuando se realice la conexion 
     */
    public static Connection conecta() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    /*
        Metodo "Consulta"
        Descripcion: 
        Entrada: Recibe dos parametros
            - Una cadena de caracteres, la cual sera mi sentencia SQL
            - Objeto del tipo conexion para validar la comunicacion entre MySQL y Java
        Salida:
     */
    public ResultSet consulta(String consulta, Connection conn) throws SQLException {
        this.estancia = (Statement) conn.createStatement();
        return this.estancia.executeQuery(consulta);
    }

    public void cierra(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public void cierra(PreparedStatement stmt) {
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public void cierra(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
