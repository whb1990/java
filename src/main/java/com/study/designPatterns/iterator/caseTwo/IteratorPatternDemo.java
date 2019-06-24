package main.java.com.study.designPatterns.iterator.caseTwo;

/**
 * @author: whb
 * @date: 2019/6/14 9:20
 * @description: 测试类
 */
public class IteratorPatternDemo {

    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();
        for (Iterator iter = nameRepository.getIterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            System.out.println("Name:" + name);
        }
    }
}
