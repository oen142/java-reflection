package org.example;

import org.example.refactoring.Cook;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassInfo {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {

        Class<?> aClass = Class.forName("org.example.refactoring.Cook");

        Cook myCook = (Cook) aClass.newInstance();
        System.out.println("myCook = " + myCook);

        Field a = myCook.getClass().getDeclaredField("A");
        System.out.println(a.get(null));
        a.set(null , "BBB");
        System.out.println(a.get(null));

        Field B = myCook.getClass().getDeclaredField("B");
        B.setAccessible(true);
        System.out.println(B.get(myCook));
        B.set(myCook , "BBBBsB");
        System.out.println(B.get(myCook));

        Method d = myCook.getClass().getDeclaredMethod("D");
        d.setAccessible(true);
        d.invoke(myCook);


        Method ds = myCook.getClass().getDeclaredMethod("sum" ,int.class , int.class);
        int invoke = (int) ds.invoke(myCook, 1, 2);
        System.out.println("invoke = " + invoke);
    }
}
