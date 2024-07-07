package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.acme.domain.Person;

import java.util.List;

@ApplicationScoped
public class PersonDao {

    @Inject
    private EntityManager entityManager;

    List<Person> getPeople(){

       Query query = entityManager.createNamedQuery("findAllPeople");

        return  query.getResultList();



    }

    Person createPerson(PersonDto  personDto){

        Person person = new Person();
        person.setName(personDto.name());
        person.setEmail(personDto.email());
        entityManager.persist(person);
        return person;


    }

}
