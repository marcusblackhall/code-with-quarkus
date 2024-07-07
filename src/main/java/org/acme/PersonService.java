package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.domain.Person;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PersonService {

    @Inject
    PersonDao personDao;

    List<PersonDto> getPersons(){

        List<Person> people = personDao.getPeople();
        return people.stream().map(p -> new PersonDto(p.getId(),p.getName(),p.getEmail())).collect(Collectors.toList());


    }

    @Transactional
    PersonDto createPerson(PersonDto pdto){
        Person p =  personDao.createPerson(pdto);
        return  new PersonDto(p.getId(),p.getName(),p.getEmail());

    }

}
