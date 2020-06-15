package org.example.refactoring;

public class Cook {

    public static String A = "A";
    private String B = "B";

    public Cook() {

    }

    public void c(){
        System.out.println("C");
    }

    public Cook(String b) {
        B = b;
    }

    public int sum(int left , int right){
        return left + right;
    }
    private void D(){
        System.out.println("D");
    }
}
