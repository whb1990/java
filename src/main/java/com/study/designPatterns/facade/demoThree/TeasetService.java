package main.java.com.study.designPatterns.facade.demoThree;

/**
 * @author: whb
 * @date: 2019/9/4 22:35
 * @description: 泡茶，将烧好的水与茶叶进行冲泡，最终得到一杯茶水
 */
public class TeasetService {
    /**
     * 泡茶
     *
     * @param who
     * @param water
     * @param teaLeaf
     * @return
     */
    public TeaWater makeTeaWater(String who, Water water, TeaLeaf teaLeaf) {
        String teawater = "一杯容量为 " + water.getCapacity() + ", 温度为 " + water.getTemperature() + " 的" + teaLeaf.getTeaName() + "茶水";
        System.out.println(who + " 泡了" + teawater);
        return new TeaWater(teawater);
    }
}
