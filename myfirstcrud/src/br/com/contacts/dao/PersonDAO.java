package br.com.contacts.dao;

import br.com.contacts.factory.ConnectionFactory;
import br.com.contacts.model.Person;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    //CREATE ok
    //READ
    //DELETE
    //UPDATE

    public void save(Person person) {
        String sql = "INSERT INTO person(name, age, signinDate) VALUE (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Cria uma conexão com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();

            //Criamos uma PreparedStatement para executar uma query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //Adicionar os valores que são esperados pela query

            pstm.setString(1, person.getName());
            pstm.setInt(2, person.getAge());
            pstm.setDate(3, new Date(person.getSigninDate().getTime()));

            //Executar a query
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Person> getPeople() {
        String sql = "SELECT * FROM person";

        List<Person> people = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstm = null;

        //Classe que vai recuperar os dados do database ***SELECT
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while (rset.next()) {
                Person person = new Person();

                //Recuperar o id
                person.setId(rset.getInt("id"));

                //Recuperar o nome
                person.setName(rset.getString("name"));

                //Recuperar a idade
                person.setAge(rset.getInt("age"));

                //Recuperar a data de cadastro
                person.setSigninDate(rset.getDate("signinDate"));

                people.add(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }

                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return people;
    }

    public void update(Person person) {
        String sql = "UPDATE person SET name = ?, age = ?, signinDate = ?" + " WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Criar conexão com o database
            conn = ConnectionFactory.createConnectionToMySQL();

            //Criar a classe para executar a query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //Adicionar os valores para atualizar
            pstm.setString(1, person.getName());
            pstm.setInt(2, person.getAge());
            pstm.setDate(3, new Date(person.getSigninDate().getTime()));
            pstm.setInt(4, person.getId());

            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void deleteById(int id) {
        String sql = "DELETE FROM person WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
