package main.java.com.study.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;

import java.util.List;

/**
 * @author: whb
 * @date: 2019/8/20 16:51
 * @description: guava测试字符串
 */
public class StringTest {

    //连接器
    private static final Joiner joiner = Joiner.on(",").skipNulls();

    //分割器
    private static final Splitter splitter = Splitter.on(",").trimResults().omitEmptyStrings();

    public static void main(String[] args) {
        //把集合/数组中的元素Join在一起
        String join = joiner.join(Lists.newArrayList("a", null, "b"));
        System.out.println("join = " + join);

        for (String tmp : splitter.split("a,   ,b,,")) {
            System.out.println("|" + tmp + "|");
        }

        //快速完成到集合的转换
        List<Integer> list = Ints.asList(1,3,5,7,9);
        System.out.println(Ints.join(",",1,3,1,4));

        //原生类型数组快速合并
        int[] newIntArray = Ints.concat(new int[]{1,2},new int[]{2,3,4});
        System.out.println(newIntArray.length);

        //最大/最下
        System.out.println(Ints.max(newIntArray)+" , "+Ints.min(newIntArray));

        //是否包含
        System.out.println(Ints.contains(newIntArray,6));

        //集合到数组的转换
        int[]someArray = Ints.toArray(list);

        /**
         * Multiset就是无序的，但是可以重复的集合
         */
        Multiset<String>multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("b");
        multiset.add("d");
        multiset.add("e");
        System.out.println(multiset.size());
        System.out.println(multiset.count("a"));

    }
}
