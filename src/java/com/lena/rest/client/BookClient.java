package com.lena.rest.client;

import com.lena.entities.Book;
import com.lena.rest.BooksMessageBodyWriter;
import com.lena.rest.BooksResource;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class BookClient {
    
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        client.register(BooksMessageBodyWriter.class).register(BooksResource.class);
        WebTarget target = client.target("http://localhost:8084/service/library/");
        Response response = target.request().post(Entity.entity(new Book("F# book","11111111"), MediaType.APPLICATION_XML_TYPE));
        Book bookResponse = response.readEntity(Book.class);
    }
}
