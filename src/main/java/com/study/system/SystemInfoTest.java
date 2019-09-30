package main.java.com.study.system;

/**
 * @author: whb
 * @date: 2019/9/30 17:05
 * @description: 获取系统相关信息
 */
public class SystemInfoTest {
    public static void main(String[] args) {
        System.out.println("Java运行时环境版本:" + System.getProperty("java.version"));
        System.out.println("Java 运行时环境供应商:" + System.getProperty("java.vendor"));
        System.out.println("Java 供应商的URL:" + System.getProperty("java.vendor.url"));
        System.out.println("Java安装目录:" + System.getProperty("java.home"));
        System.out.println("Java 虚拟机规范版本:" + System.getProperty("java.vm.specification.version"));
        System.out.println("Java 类格式版本号:" + System.getProperty("java.class.version"));
        System.out.println("Java类路径：" + System.getProperty("java.class.path"));
        System.out.println("加载库时搜索的路径列表:" + System.getProperty("java.library.path"));
        System.out.println("默认的临时文件路径:" + System.getProperty("java.io.tmpdir"));
        System.out.println("要使用的 JIT 编译器的名称:" + System.getProperty("java.compiler"));
        System.out.println("一个或多个扩展目录的路径:" + System.getProperty("java.ext.dirs"));
        System.out.println("操作系统的名称:" + System.getProperty("os.name"));
        System.out.println("操作系统的架构:" + System.getProperty("os.arch"));
        System.out.println("操作系统的版本:" + System.getProperty("os.version"));
        System.out.println("文件分隔符（在 UNIX 系统中是“/”）:" + System.getProperty("file.separator"));
        System.out.println("路径分隔符（在 UNIX 系统中是“:”）:" + System.getProperty("path.separator"));
        System.out.println("行分隔符（在 UNIX 系统中是“/n”）:" + System.getProperty("line.separator"));
        System.out.println("用户的账户名称:" + System.getProperty("user.name"));
        System.out.println("用户的主目录:" + System.getProperty("user.home"));
        System.out.println("用户的当前工作目录:" + System.getProperty("user.dir"));
        System.out.println("当前的classpath的绝对路径的URI表示法:" + Thread.currentThread().getContextClassLoader().getResource(""));
        System.out.println("得到的是当前的classpath的绝对URI路径:" + SystemInfoTest.class.getResource("/"));
        System.out.println("得到的是当前类Tfff.class文件的URI目录:" + SystemInfoTest.class.getResource(""));

    }
}
