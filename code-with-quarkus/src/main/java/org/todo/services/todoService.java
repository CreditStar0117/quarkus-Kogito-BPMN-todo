package org.todo.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.todo.dto.todoDto;

@ApplicationScoped
public class todoService {

    @Inject @RestClient TodoRestClientService todoRestClient;

    public Response findAll() {
        return this.todoRestClient.findAll();
    }

    public Response findById(String id) {
        return this.todoRestClient.findById(id);
    }

    public Response create(todoDto todoDto) {
        try {
            return this.todoRestClient.create(todoDto);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    public Response update(String id, todoDto todoDto) {
        try{
            return this.todoRestClient.update(id, todoDto);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    public Response deleteById(String id) {
        try{
            return this.todoRestClient.delete(id);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

}
