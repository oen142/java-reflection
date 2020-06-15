package org.example.di;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContainerService {

    public static <T> T getObject(Class<T> tClass){
        T instance = createInstance(tClass);
        Arrays.stream(tClass.getDeclaredFields()).forEach(field -> {
            if(field.getAnnotation(Inject.class) != null){
                Object fieldInstance = createInstance(field.getType());
                field.setAccessible(true);
                try {
                    field.set(instance , fieldInstance );
                } catch (IllegalAccessException e) {
                    throw  new RuntimeException();
                }
            }
        });
        return instance;
    }
    private static <T> T createInstance(Class<T> classType) throws RuntimeException {
        try {
            return classType.getConstructor(null).newInstance();
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException();
        }
    }

    /*
     * 테스트 코드에서는 참조 가능
     * 반대는 불가능
     * */
}

