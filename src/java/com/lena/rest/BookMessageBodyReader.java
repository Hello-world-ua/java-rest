package com.lena.rest;

import com.lena.entities.Book;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

@Provider
public class BookMessageBodyReader implements MessageBodyReader<Book>{

    @Override
    public boolean isReadable(Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        return true;
    }

    @Override
    public Book readFrom(Class<Book> type, Type type1, Annotation[] antns, MediaType mt, MultivaluedMap<String, String> mm, InputStream in) throws IOException, WebApplicationException 
    {
        try {   
            JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);  
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();  
            Book book = (Book)unmarshaller.unmarshal(in) ;
            return book;
        } 
        catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
