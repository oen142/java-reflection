package org.example.refactoring;

public class Book {

    private String a;
    private static String B = "B";
    private static final String c = "c";

    public String d = "d";
    protected  String e = "e";
    public Book(){

    }

    public Book(String a, String d, String e) {
        this.a = a;
        this.d = d;
        this.e = e;
    }

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
