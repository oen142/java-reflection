package org.example.annotation;


import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.FIELD;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ANNOTATION_TYPE, FIELD , TYPE })
@Inherited //상속이 되는 어노테이션.
public @interface MyAnnotation {

    /*
    * 제한된 타입만 가질 수 있다.
    * 레퍼런스 타입을 가질 숭 있다.
    * 프리미티브 가능
    *
    * */

    /*
    * 값을 하나만 받을때만 유용하다.
    * */
    String value() default "SSE";


    String name() default  "KIM";
    int number() default 100;
    /*
    * 기본값들을 가질수가 있다.
    *
    * */
}
