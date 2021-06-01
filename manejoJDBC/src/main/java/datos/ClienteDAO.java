package datos;

import static datos.conexion.*;
import domain.cliente;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karina
 */
//CLASE PARA LAS OPERACIONES EN LA BD (INSERT, UPDATE, ETC...)
public class ClienteDAO {

    //DEFINICION DE SENTENCIAS
    private static final String SQL_SELECT = "SELECT correoCliente, nombre, contraseña FROM cliente";

    //lista de objetos de tipo "cliente"
    public List<cliente> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        cliente cliente = null;
        List<cliente> clientes = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            //1.-recuperacion de datos
            while (rs.next()) {
                String correoCliente = rs.getString("correoCliente");
                String nombre = rs.getString("nombre");
                String contraseña = rs.getString("contraseña");

                //2.-objeto tipo cliente ------>  conversion de BD a objetos java
                cliente = new cliente(correoCliente, nombre, contraseña);

                //3.- se agrega a la lista
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                //4.- cerrar objetos
                conexion.close(rs);
                conexion.close(stmt);
                conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return clientes;
    }
}
