package main.java.com.study.methodreference;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: whb
 * @date: 2019/7/10 17:12
 * @description: 方法引用测试
 */
public class MethodReferenceTest {

    public static final Person[] personArr = new Person[]{
            new Person("张三", LocalDate.of(1990, 4, 15)),
            new Person("李四", LocalDate.of(1989, 12, 23)),
            new Person("王五", LocalDate.of(1991, 6, 12)),
            new Person("萧炎", LocalDate.of(1990, 5, 20))
    };

    /**
     * 使用匿名内部类排序
     */
    @Test
    public void test() {
        Arrays.sort(personArr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });
        System.out.println(Arrays.asList(personArr));
    }

    /**
     * 使用Lambda表达式，未调用已存在的方法
     */
    @Test
    public void testLambda() {
        Arrays.sort(personArr, (a, b) -> {
            return a.getBirthday().compareTo(b.getBirthday());
        });
        System.out.println(Arrays.asList(personArr));
    }

    /**
     * 使用Lambda表达式，调用已存在的方法
     */
    @Test
    public void testLambda2() {
        Arrays.sort(personArr, (a, b) -> Person.compareByAge(a, b));
        System.out.println(Arrays.asList(personArr));
    }

    /**
     * 使用方法引用（静态方法引用）
     */
    @Test
    public void testMethodReference() {
        Arrays.sort(personArr, Person::compareByAge);
        System.out.println(Arrays.asList(personArr));
    }
}
