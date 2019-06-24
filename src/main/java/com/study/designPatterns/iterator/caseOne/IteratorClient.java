package main.java.com.study.designPatterns.iterator.caseOne;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: whb
 * @date: 2019/6/13 17:52
 * @description: 迭代模式测试类
 */
public class IteratorClient {

    public static void main(String[] args) {
        DrivingRecorder recorder = new DrivingRecorder();
        for (int i = 0; i < 12; i++) {
            recorder.append("视频__" + i);
        }
        //recorder.display();
        //recorder.displayInOrder();
        //用户要获取交通事故视频，定义事故列表
        List<String> accidents = new ArrayList<>();
        //用户拿到迭代器
        Iterator<String> it = recorder.iterator();
        while (it.hasNext()) {
            String video = it.next();
            System.out.println(video);
            //用户翻看视频发现10和8可以作为证据
            if ("视频__10".equals(video) || "视频__8".equals(video)) {
                accidents.add(video);
            }
        }
        //拿到两个视频集给交警
        System.out.println("事故证据：" + accidents);
    }
}
