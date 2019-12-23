package springcloud.demo.rpc.transmission;

/**
 * @Author: Dely
 * @Date: 2019/11/28 17:30
 */


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;


/***
 *
 */
public class RpcClientHandler extends SimpleChannelInboundHandler<RpcResponseBody> {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("处理出错了（（*********************************");
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, RpcResponseBody o) throws Exception {
     }
}
