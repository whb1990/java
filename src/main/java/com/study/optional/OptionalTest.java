package main.java.com.study.optional;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author: whb
 * @date: 2019/7/10 15:09
 * @description: Optional测试类
 * 可能包含或不包含非空值的容器对象。 如果一个值存在， isPresent()将返回true和get()将返回值。
 * 提供依赖于存在或不存在包含值的其他方法，例如orElse() （如果值不存在则返回默认值）和ifPresent() （如果值存在则执行代码块）。
 */
public class OptionalTest {
    public static void main(String[] args) {
        //返回一个空的Optional实例。 此可选项不存在值。
        Optional<String> optional = Optional.empty();
        //返回具有 Optional的当前非空值的Optional。
        optional = Optional.of("OptionalTest");
        //如果存在值，则返回 true ，否则为 false 。
        System.out.println("optional" + (optional.isPresent() ? "存在值" : "不存在值"));
        //如果 Optional中存在值，则返回值，否则抛出 NoSuchElementException 。
        System.out.println("optional的值：" + optional.get());
        //如果存在返回值，否则返回 other 。
        System.out.println("optional = " + optional.orElse("fallback"));
        //如果存在值，则使用该值调用指定的消费者，否则不执行任何操作。
        optional.ifPresent((s) -> System.out.println(s.charAt(2)));

        test1();
        test2();
        test3();
    }

    static class Outer {
        Nested nested = new Nested();

        public Nested getNested() {
            return nested;
        }
    }

    static class Nested {
        Inner inner = new Inner();

        public Inner getInner() {
            return inner;
        }
    }

    static class Inner {
        String foo = "boo";

        public String getFoo() {
            return foo;
        }
    }

    public static <T> Optional<T> resolve(Supplier<T> resolver) {
        try {
            T result = resolver.get();
            //返回一个 Optional指定值的Optional，如果非空，则返回一个空的 Optional 。
            return Optional.ofNullable(result);
        } catch (NullPointerException e) {
            return Optional.empty();
        }
    }

    private static void test3() {
        Outer outer = new Outer();
        resolve(() -> outer.getNested().getInner().getFoo())
                .ifPresent(System.out::println);
    }

    /**
     * 如果存在值，则应用提供的映射函数，如果结果不为空，则返回一个Optional结果的Optional 。 否则返回一个空的Optional 。
     */
    private static void test2() {
        Optional.of(new Outer())
                .map(Outer::getNested)
                .map(Nested::getInner)
                .map(Inner::getFoo)
                .ifPresent(System.out::println);
    }

    /**
     * 如果一个值存在，应用提供的Optional映射函数给它，返回该结果，否则返回一个空的Optional 。
     * 这种方法类似于map(Function) ，但是提供的映射器是一个结果已经是Optional映射器，如果被调用， flatMap不会用额外的Optional 。
     */
    private static void test1() {
        Optional.of(new Outer())
                .flatMap(o -> Optional.ofNullable(o.nested))
                .flatMap(n -> Optional.ofNullable(n.inner))
                .flatMap(i -> Optional.ofNullable(i.foo))
                .ifPresent(System.out::println);
    }
}
