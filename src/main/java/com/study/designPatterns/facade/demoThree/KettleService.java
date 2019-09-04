package main.java.com.study.designPatterns.facade.demoThree;

/**
 * @author: whb
 * @date: 2019/9/4 22:34
 * @description: 烧水需要用水壶烧，将水加热
 */
public class KettleService {
    /**
     * 烧水加热
     *
     * @param who
     * @param water
     * @param burnTime
     */
    public void waterBurning(String who, Water water, int burnTime) {
        // 烧水，计算最终温度
        int finalTermperature = Math.min(100, water.getTemperature() + burnTime * 20);
        water.setTemperature(finalTermperature);
        System.out.println(who + " 使用水壶烧水，最终水温为 " + finalTermperature);
    }
}
