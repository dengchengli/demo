package springcloud.demo.rpc.transmission;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @Author: Dely
 * @Date: 2019/11/28 17:29
 */
public class NettyClient {
    private final static int port = 9000;
    private final static String host = "localhost";

    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup(1);

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            ChannelPipeline pipeline = channel.pipeline();
                           // pipeline.addLast(new RpcClientRequestHandler());
                            pipeline.addLast(new RpcEncoder(RpcResponseBody.class));  //编码请求
                            pipeline.addLast(new RpcDecoder(RpcResponseBody.class));  //解码响应
                            pipeline.addLast(new RpcClientHandler()); //处理响应



                        }
                    });
            ChannelFuture future = bootstrap.connect(new InetSocketAddress(host, port)).sync();
            Channel channel = future.channel();
            RpcRequestBody requestBody = new RpcRequestBody();
            requestBody.setRequestId(8888);
            future = channel.writeAndFlush(requestBody);
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }

    }

}
