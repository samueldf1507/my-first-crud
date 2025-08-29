package br.com.contacts.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    //Nome do usuário mysql
    private static final String USER = "root";

    //Senha do usuário mysql
    private static final String PASSWORD = "1234abc";

    //Caminho do banco de dados, porta e nome do database
    private static final String databaseURl = "jdbc:mysql://localhost:3306/contacts";

    /*
    Conexão com o banco de dados
     */

    public static Connection createConnectionToMySQL() throws Exception {
        //Faz com que a classe seja carregada pela JVM
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Cria a conexão com o banco de dados
        Connection connection = DriverManager.getConnection(databaseURl, USER, PASSWORD);

        return connection;

    }

    public static void main(String[] args) throws Exception {
        //Recuperar uma conexão com o banco de dados
        Connection con = createConnectionToMySQL();

        //Testar se a conexão é nula
        if (con != null) {
            System.out.println("Conexão obetida com sucesso ");
            con.close();
        }
    }
}
