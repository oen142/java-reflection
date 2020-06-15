package org.example;

import org.example.di.ContainerService;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ContainerServiceTest {
    @Test
    public void getObject_BookRepository(){
        BookRepository object = ContainerService.getObject(BookRepository.class);
        assertNotNull(object);
    }

    @Test
    public void getObject_BookService(){
        BookService object = ContainerService.getObject(BookService.class);
        assertNotNull(object);
        assertNotNull(object.bookRepository);

    }
}
