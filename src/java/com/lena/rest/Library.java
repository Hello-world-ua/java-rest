package com.lena.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class Library {
    
    @GET
    @Produces("text/plain")
    public String welcome() {
        return "Welcome to the library!";
    }
    
    @Path("/books/{isbn}")
    public Book getBook(@PathParam("isbn") String isbn) {
        // return some Book
        return new Book();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response addBook(Book book) {
        // add book to some collection
        return Response.ok(book).type(MediaType.APPLICATION_XML_TYPE).build();
    }
    
    @DELETE
    @Path("/{isbn}")
    public void deleteBook(@PathParam("isbn") String isbn) {
        // delete book from some collection
    }
    
    public class Book {
        @Path("/author")
        public String getAuthor() {
            // return string
            return "author";
        }
    }
}
