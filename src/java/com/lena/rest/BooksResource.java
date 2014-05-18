package com.lena.rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("books")
public class BooksResource {

    @Context
    private UriInfo context;

    public BooksResource() {
    }

    @GET
    @Produces("text/plain")
    public String getGreeting() {
        return "Hello! This is books resource.";
    }
    
    /*
        // Example of client request:
        Client client = ClientBuilder.newClient();
        client.register(MessageBodyReaderWriter.class).register(BooksResource.class);
        Response response = target.request()
        .post(Entity.entity(new Book("F#","11111111"), MediaType.APPLICATION_XML_TYPE));
        Book  = response.readEntity(Book.class);
    */
}
