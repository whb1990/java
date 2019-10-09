package main.java.com.study.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author: whb
 * @date: 2019/10/9 17:23
 * @description: NIO基石Path测试类
 */
public class PathTest {
    public static void main(String[] args) {
        // 相对路径
        Path dir = Paths.get("nioTest");

        // 输出 dir 的绝对路径
        System.out.println(dir.toAbsolutePath());

        if (Files.notExists(dir)) {
            try {
                // 如果目录不存在，则创建目录
                Files.createDirectory(dir);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        // 这时候 nioTest.txt 文件并未创建
        // 通过 resolve 方法把 dir 和 nioTest.txt 链接起来
        Path file = dir.resolve("nioTest.txt");

        // 输出 file 的绝对路径
        System.out.println(file.toAbsolutePath());

        if (Files.notExists(file)) {
            try {
                // 如果文件不存在，则创建文件
                Files.createFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //查找 nioTest 目录下的 txt 后缀的文件
        // 相对路径
        Path parentDir = Paths.get("nioTest");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(parentDir, "*.txt")) {
            for (Path entry : stream) {
                System.out.println(entry.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //使用walkFileTree从目录树中找到 txt 后缀的文件
        // 相对路径
        dir = Paths.get("nioTest");
        try {
            Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    if (file.toString().endsWith(".txt")) {
                        System.out.println(file.getFileName());
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        //快速读写文件
        file = Paths.get("nioPathTest.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
            writer.write("学习NIO，实现文件的快速读写");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
