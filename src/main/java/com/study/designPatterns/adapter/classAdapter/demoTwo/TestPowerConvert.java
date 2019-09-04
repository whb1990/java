package main.java.com.study.designPatterns.adapter.classAdapter.demoTwo;

/**
 * @author: whb
 * @date: 2019/9/4 15:27
 * @description: 测试类，通过Adapter类调用所需要的方法从而实现目标（不需要通过原有插头）
 */
public class TestPowerConvert {
    public static void main(String[] args) {

        Target mAdapter220V = new Adapter220V();
        ImportedMachine mImportedMachine = new ImportedMachine();

        //用户拿着进口机器插上适配器（调用Convert_110v()方法）
        //再将适配器插上原有插头（Convert_110v()方法内部调用Output_220v()方法输出220V）
        //适配器只是个外壳，对外提供110V，但本质还是220V进行供电
        mAdapter220V.convert_110v();
        mImportedMachine.Work();
    }
}

/**
 * 进口机器类
 */
class ImportedMachine {

    public void Work() {
        System.out.println("进口机器正常运行");
    }
}
