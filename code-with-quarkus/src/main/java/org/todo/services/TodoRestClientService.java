package org.todo.services;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.todo.dto.todoDto;

@Path("/todo-list")
@RegisterRestClient(configKey = "todo-api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface TodoRestClientService {

    @GET
    @Path("")
    Response findAll();

    @GET
    @Path("{id}")
    Response findById(@PathParam("id") String id);

    @POST
    @Path("")
    Response create(todoDto todoDto);

    @PUT
    @Path("{id}")
    Response update(@PathParam("id") String id, todoDto todoDto);

    @DELETE
    @Path("{id}")
    Response delete(@PathParam("id") String id);
}