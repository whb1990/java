package main.java.com.study.nio;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author: whb
 * @date: 2019/10/9 16:37
 * @description: 文件读取速度对比，nio处理大文件性能较优
 */
public class FileReaderCompared {
    public static void main(String[] args) {
        System.out.println("开始读取文件。。。");
        long start = System.currentTimeMillis();
        //inputStream(Paths.get("D:/Git.avi"));//龟速
        //bufferedInputStream(Paths.get("D:/Git.avi"));//性能一般
        //randomAccessFile(Paths.get("D:/Git.avi"));//龟速
        mappedFile(Paths.get("D:/Git.avi"));//性能超棒
        long end = System.currentTimeMillis();

        System.out.println("耗时：" + (end - start) + "毫秒");
    }

    /**
     * 普通输入流
     *
     * @param filename
     */
    public static void inputStream(Path filename) {
        try (InputStream is = Files.newInputStream(filename)) {
            int c;
            while ((c = is.read()) != -1) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 带缓冲的输入流
     *
     * @param filename
     */
    public static void bufferedInputStream(Path filename) {
        try (InputStream is = new BufferedInputStream(Files.newInputStream(filename))) {
            int c;
            while ((c = is.read()) != -1) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 随机访问文件
     *
     * @param filename
     */
    public static void randomAccessFile(Path filename) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(filename.toFile(), "r")) {
            for (long i = 0; i < randomAccessFile.length(); i++) {
                randomAccessFile.seek(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 内存映射文件
     * 调用 FileChannel 类的 map 方法从 channel 中获取 MappedByteBuffer，此类扩展了 ByteBuffer——提供了一些内存映射文件的基本操作方法
     * 稍微解释一下 map 方法的三个参数。
     * <p>
     * 1）mode 为文件映射模式，分为三种：
     * <p>
     * MapMode.READ_ONLY（只读），任何试图修改缓冲区的操作将导致抛出 ReadOnlyBufferException 异常。
     * <p>
     * MapMode.READ_WRITE（读/写），任何对缓冲区的更改都会在某个时刻写入文件中。需要注意的是，其他映射同一个文件的程序可能不能立即看到这些修改，多个程序同时进行文件映射的行为依赖于操作系统。
     * <p>
     * MapMode.PRIVATE（私有）， 对缓冲区的更改不会被写入到该文件，任何修改对这个缓冲区来说都是私有的。
     * <p>
     * 2）position 为文件映射时的起始位置。
     * <p>
     * 3）size 为要映射的区域的大小，必须是非负数，不得大于Integer.MAX_VALUE。
     *
     * @param filename
     */
    public static void mappedFile(Path filename) {
        try (FileChannel fileChannel = FileChannel.open(filename)) {
            long size = fileChannel.size();
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, size);
            for (int i = 0; i < size; i++) {
                mappedByteBuffer.get(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
