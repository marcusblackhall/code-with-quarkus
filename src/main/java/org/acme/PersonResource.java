package org.acme;

import jakarta.inject.Inject;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/persons")
public class PersonResource {

    @Inject
    private PersonService personService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List<PersonDto> persons() {

        return personService.getPersons();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public PersonDto createPerson(PersonDto dto){
       return personService.createPerson(dto);
    }
}
