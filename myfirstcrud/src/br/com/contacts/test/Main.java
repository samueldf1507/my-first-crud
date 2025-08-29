package br.com.contacts.test;

import br.com.contacts.dao.PersonDAO;
import br.com.contacts.model.Person;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();
        Person person = new Person();
        person.setName("Felipe");
        person.setAge(21);
        person.setSigninDate(new Date());



        personDAO.save(person);

        //Atualizar o contato
        Person person2 = new Person();
        person2.setName("Vinicius");
        person2.setAge(21);
        person2.setSigninDate(new Date());
        person2.setId(2); //É o número que está no banco de dados
        personDAO.update(person2);


        //Visualização de TODOS os registros do banco de dados
        for (Person p : personDAO.getPeople()) {
            System.out.println("ID: " + p.getId());
            System.out.println("Pessoa: " + p.getName());
            System.out.println("Idade: " + p.getAge());
            System.out.println("Data de cadastro: " + p.getSigninDate());
        }

    }
}
