package springcloud.demo.rpc.transmission;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author: Dely
 * @Date: 2019/11/28 15:37
 */
public class NettyServer {
    private final static int port = 9000;
    public static void main(String[] args) throws InterruptedException {

        /**
         * 创建线程组
         */
        EventLoopGroup serverGroup = new NioEventLoopGroup(1);
        EventLoopGroup channelGruop = new NioEventLoopGroup(10);

        /**
         * 配置 channel等属性
         */

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(serverGroup, channelGruop)  //设置父和子线程组
                    .channel(NioServerSocketChannel.class)  //创建channel的类型
                    .option(ChannelOption.SO_BACKLOG,1)  //父channel的属性
                    .childHandler(new ChannelInitializer<Channel>() {  //子channel的处理器
                        @Override
                        protected void initChannel(Channel channel) throws Exception {
                            ChannelPipeline pipeline = channel.pipeline();
                            pipeline.addLast(new RpcDecoder(RpcRequestBody.class));
                            pipeline.addLast(new RpcEncoder(RpcRequestBody.class));
                            pipeline.addLast(new RpcServerHandler());
                        }
                    });

            /**
             * 绑定端口
             */
            ChannelFuture  future = bootstrap.bind(port).sync();
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            serverGroup.shutdownGracefully();
            channelGruop.shutdownGracefully();

        }

    }
}
