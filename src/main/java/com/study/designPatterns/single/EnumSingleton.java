package main.java.com.study.designPatterns.single;

/**
 * @author: whb
 * @date: 2019/6/13 10:09
 * @description: 枚举【推荐用】
 * 不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象。
 */
public enum EnumSingleton {
    Instance;

    public void whatEverMethod() {
    }
}
