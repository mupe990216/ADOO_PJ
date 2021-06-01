package test;

import datos.ClienteDAO;
import domain.cliente;
import java.util.List;

/**
 *
 * @author Karina
 */
public class TestManejoClientes {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
        List<cliente> clientes = clienteDAO.seleccionar();
        for(cliente cliente: clientes) {
            System.out.println("clientes = "+ cliente);
        }
        /*
        clientes.forEach(cliente -> {
            System.out.println("clientes = "+ cliente);
        });*/
        
    }
}
