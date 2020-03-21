package main.java.com.study.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: whb
 * @date: 2020/3/9 15:20
 * @description: 反射略过泛型检查
 */
public class ReflectGenericIgnore {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Class<?> clazz = list.getClass();
        Method addMethod = clazz.getMethod("add", Object.class);
        addMethod.invoke(list, "字符串");
        System.out.println(list);
    }
}
