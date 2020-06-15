package org.example.refactoring;

import org.example.annotation.DifferentAnnotation;
import org.example.annotation.MyAnnotation;

@MyAnnotation(name = "kim" , number =  200 )
public class Book {

    private String a;
    private static String B = "B";
    private static final String c = "c";

    @DifferentAnnotation
    public String d = "d";
    protected  String e = "e";
    public Book(){

    }

    @DifferentAnnotation
    public Book(String a, String d, String e) {
        this.a = a;
        this.d = d;
        this.e = e;
    }

    @DifferentAnnotation
    private void f(){
        System.out.println("F");
    }
    public void g(){
        System.out.println("g");
    }
    public  int h(){
        return 1;
    }
}
