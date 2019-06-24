package main.java.com.study.designPatterns.iterator.caseTwo;

/**
 * @author: whb
 * @date: 2019/6/14 9:18
 * @description: 实现Container接口
 */
public class NameRepository implements Container {

    public String names[] = {"Java", "Redis", "Dubbo", "Zookeeper"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {

        int index = 0;

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }

        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }
    }
}
