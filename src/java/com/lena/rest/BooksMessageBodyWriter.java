package com.lena.rest;

import com.lena.entities.Book;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

@Provider
public class BooksMessageBodyWriter implements MessageBodyWriter<Book> {

    @Override
    public boolean isWriteable(Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        return true;
    }

    @Override
    public long getSize(Book book, Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        return -1;
    }

    @Override
    public void writeTo(Book book, Class<?> type, Type type1, Annotation[] antns, MediaType mt, MultivaluedMap<String, Object> mm, OutputStream out) throws IOException, WebApplicationException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);  
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(book, out);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
