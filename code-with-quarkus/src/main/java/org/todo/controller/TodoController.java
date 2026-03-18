package org.todo.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.todo.dto.todoDto;
import org.todo.services.todoService;

@Path("/todo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TodoController {

    @Inject todoService todoService;

    @GET
    public Response findAll() {
        return this.todoService.findAll();
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(todoDto todoDto) {
        return this.todoService.create(todoDto);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") String id, todoDto todoDto) {
        return this.todoService.update(id, todoDto);
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String id) {
        return this.todoService.deleteById(id);
    }
}