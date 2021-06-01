package test;

import java.sql.*;


/**
 *
 * @author Karina
 */
public class TestMySQLJDBC {
    public static void main(String[] args) {
        //conexion BD
        var url = "jdbc:mysql://localhost:3306/prueba?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url,"root","2015170921rami99");
            Statement instruccion = conexion.createStatement();
            var sql = "SELECT correoCliente, nombre, contraseña FROM cliente";
            ResultSet resultado = instruccion.executeQuery(sql);
            while(resultado.next()){
                System.out.println("correoCliente:" + resultado.getString("correoCliente"));
                System.out.println("nombre:" + resultado.getString("nombre"));
                System.out.println("contraseña:" + resultado.getString("contraseña"));
            }
        }catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
