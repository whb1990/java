package main.java.com.study.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author: whb
 * @date: 2019/7/10 16:15
 * @description: 函数测试类
 */
public class FunctionTest {

    static List<Emp> empList = Arrays.asList(new Emp(1, "张三"),
            new Emp(2, "李四"),
            new Emp(3, "王五"),
            new Emp(4, "赵柳"));

    /**
     * Function应用
     */
    @Test
    public void testFunction() {
        Function<Emp, String> function = emp -> emp.getEname();
        empList.stream().forEach(emp -> {
            System.out.println(function.apply(emp));
        });
    }

    /**
     * Consumer应用
     */
    @Test
    public void testConsumer() {
        Consumer<Emp> consumer = Emp::printEmp;
        empList.stream().forEach(emp -> {
            consumer.accept(emp);
        });
    }

    /**
     * Predicate应用
     */
    @Test
    public void testPredicate() {
        Predicate<Emp> predicate = emp -> emp.getEmpno() > 1;
        empList.stream().forEach(emp -> {
            if (predicate.test(emp)) {
                Emp.printEmp(emp);
            }
        });
    }

    /**
     * 综合应用
     *
     * @param source
     * @param predicate
     * @param function
     * @param consumer
     * @param <T>       参数
     * @param <R>       返回值
     */
    private <T, R> void printEmpNameWhenEmpNoLg1(Iterable<T> source, Predicate<T> predicate, Function<T, R> function, Consumer<R> consumer) {
        for (T t : source) {
            if (predicate.test(t)) {
                R r = function.apply(t);
                consumer.accept(r);
            }
        }
    }

    @Test
    public void testFunctionInterface() {
        Predicate<Emp> predicate = emp -> emp.getEmpno() > 1;
        Function<Emp, String> function = emp -> emp.getEname();
        Consumer<String> consumer = System.out::println;
        printEmpNameWhenEmpNoLg1(empList, predicate, function, consumer);
    }
}
