package com.lena.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {
    
        public Book() {                   
        }
        
        public Book(String title, String isbn) {   
            this.setTitle(title);
            this.setISBN(isbn);
        }
        
        @XmlElement(required = true)
        protected String title;
        
        @XmlElement()
        protected Book.Author author;
        
        protected String genre;
        
        @XmlAttribute(name = "price")
        protected Float price;
        
        @XmlAttribute(name = "ISBN")
        protected String isbn;
        
        @XmlAttribute(name = "publicationdate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar publicationdate;

        public String getTitle() {
            return title;
        }

        public void setTitle(String value) {
            this.title = value;
        }

        public Book.Author getAuthor() {
            return author;
        }

        public void setAuthor(Book.Author value) {
            this.author = value;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String value) {
            this.genre = value;
        }

        public Float getPrice() {
            return price;
        }

        public void setPrice(Float value) {
            this.price = value;
        }

        public String getISBN() {
            return isbn;
        }

        public void setISBN(String value) {
            this.isbn = value;
        }

        public XMLGregorianCalendar getPublicationdate() {
            return publicationdate;
        }
        
        public void setPublicationdate(XMLGregorianCalendar value) {
            this.publicationdate = value;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "firstName",
            "lastName"
        })
        
        public static class Author {

            @XmlElement(name = "first-name", required = true)
            protected String firstName;
            @XmlElement(name = "last-name", required = true)
            protected String lastName;

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String value) {
                this.firstName = value;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String value) {
                this.lastName = value;
            }
        }
}