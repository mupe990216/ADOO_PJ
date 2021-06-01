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
            Connection conexion = DriverManager.getConnection(url,"root","1234");
            Statement instruccion = conexion.createStatement();
            var sql = "SELECT * FROM TipoUsuario";
            ResultSet resultado = instruccion.executeQuery(sql);
            while(resultado.next()){
                System.out.print(resultado.getString("idTipoUsuario")+"  ");
                System.out.println(resultado.getString("Descripcion"));
            }
            resultado.close();
        }catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
