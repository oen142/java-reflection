package org.example;

import org.example.annotation.MyAnnotation;
import org.example.refactoring.Book;
import org.example.refactoring.MyBook;

import java.lang.annotation.Annotation;
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
                Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
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

        System.out.println("===============================");
        Arrays.stream(Book.class.getAnnotations()).forEach(System.out::println);


        //애노테이션은 주석이랑 같다 기본적으로 클래스에 남는다 바이트코드를 로딩했을때 메모리 상에 남지 않는다. 런타임 시에도 유지하고 싶으면 Retention 런타임 기본값은 클래스
        //컴파일하고 기본적으로 바이트코드엔 들어있는데. 디컴파일에 들어있는거 보면 들어는있다.

        System.out.println("===============================");
        Arrays.stream(MyBook.class.getAnnotations()).forEach(System.out::println);

        System.out.println("===============================");
        //자기 자신에만 붙어있는 애노테이션만 가져온다.
        Arrays.stream(MyBook.class.getDeclaredAnnotations()).forEach(System.out::println);


        System.out.println("===============================");
        //자기 자신에만 붙어있는 애노테이션만 가져온다.
        Arrays.stream(MyBook.class.getDeclaredFields()).forEach(field -> Arrays.stream(field.getAnnotations()).forEach(annotation -> {
            if( annotation instanceof MyAnnotation){
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
                System.out.println("myAnnotation = " + myAnnotation.value());
                System.out.println("myAnnotation = " + myAnnotation.number());
            }
        }));
    }
}
