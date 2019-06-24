package main.java.com.study.designPatterns.iterator.caseOne;

/**
 * @author: whb
 * @date: 2019/6/13 17:37
 * @description: 行车记录仪对象
 */
public class DrivingRecorder {
    //当前记录位置
    private int index = -1;
    //假设只能记录10条视频
    private String[] records = new String[10];

    public void append(String record) {
        //循环覆盖
        if (index == 9) {
            index = 0;
        } else {
            index++;
        }
        //System.out.println(index + ":" + record);
        records[index] = record;
    }

    /**
     * 循环数组并显示所有10条记录
     */
    public void display() {
        for (int i = 0; i < 10; i++) {
            System.out.println("第" + (i + 1) + "条：" + records[i]);
        }
    }

    /**
     * 按顺序从新到旧显示10条记录
     */
    public void displayInOrder() {
        for (int i = index, loopCount = 0; loopCount < 10; i = i == 0 ? i = 9 : i - 1, loopCount++) {
            System.out.println(records[i]);
        }
    }

    //改造，通过迭代器实现
    public Iterator<String> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<String> {

        //迭代器游标，不染指原始游标
        int cursor = index;
        int loopCount = 0;

        @Override
        public String next() {
            //记录即将返回的游标位置
            int i = cursor;
            if (cursor == 0) {
                cursor = 9;
            } else {
                cursor--;
            }
            loopCount++;
            return records[i];
        }

        @Override
        public boolean hasNext() {
            return loopCount < 10;
        }
    }
}
