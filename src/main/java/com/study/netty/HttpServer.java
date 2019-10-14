package main.java.com.study.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

/**
 * @author: whb
 * @date: 2019/10/14 10:44
 * @description: Netty服务端
 */
public class HttpServer {

    private final int port;

    public HttpServer(int port) {
        this.port = port;
    }

    public void start() {
        ServerBootstrap bootstrap = new ServerBootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();
        bootstrap.group(group).channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        System.out.println("channel：" + socketChannel);
                        socketChannel.pipeline().addLast("decoder", new HttpRequestDecoder())
                                .addLast("encoder", new HttpResponseEncoder())
                                .addLast("aggregator", new HttpObjectAggregator(512 * 1024))
                                .addLast("handler", new HttpHandler());
                    }
                });
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage：" + HttpServer.class.getSimpleName() + "<port>");
            return;
        }
        int port = Integer.parseInt(args[0]);
        new HttpServer(port).start();
    }
}
