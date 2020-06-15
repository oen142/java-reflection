package org.example;

import org.example.refactoring.Book;
import org.example.refactoring.MyBook;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException {
        //클래스 타입을 만들어서 힙에 넣어줌
        Class<Book> bookClass = Book.class;


        Book book = new Book();
        /*
        * 인스턴스가 있으면
        * */
        Class<? extends Book> aClass = book.getClass();

        //full qually fied name
        Class<?> aClass1 = Class.forName("org.example.refactoring.Book");


        Field[] fields = bookClass.getFields();

        System.out.println("===============================");
        Arrays.stream(bookClass.getFields()).forEach(System.out::println);
        //퍼블릭만 가져옴

        System.out.println("===============================");
        Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);


        System.out.println("===============================");

        Arrays.stream(bookClass.getDeclaredFields()).forEach(field -> {
            try {
                int modifiers = field.getModifiers();
                System.out.println("modifiers = " + Modifier.isPrivate(modifiers));
                field.setAccessible(true);
                //접근지시자 무시 가능
                System.out.printf("%s %s\n" , field,field.get(book));
            } catch (IllegalAccessException e) {


            }
        });


        System.out.println("===============================");
        Arrays.stream(bookClass.getMethods()).forEach(System.out::println);

        System.out.println("===============================");
        Arrays.stream(bookClass.getConstructors()).forEach(System.out::println);

        System.out.println("===============================");
        Arrays.stream(new Class[]{bookClass.getSuperclass()}).forEach(System.out::println);

        System.out.println("===============================");
        Class<?>[] interfaces = MyBook.class.getInterfaces();
        Arrays.stream(interfaces).forEach(System.out::println);

    }
}
