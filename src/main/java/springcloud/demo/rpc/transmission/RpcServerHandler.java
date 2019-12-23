package springcloud.demo.rpc.transmission;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.HashMap;

/**
 * @Author: Dely
 * @Date: 2019/11/28 15:38
 */

/**
 * 编写业务处理逻辑
 */
public class RpcServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        RpcRequestBody requestBody = (RpcRequestBody) msg;
        RpcResponseBody responseBody = new RpcResponseBody();
        responseBody.setRequestId(requestBody.getRequestId());
        responseBody.setValue("gggg");
        ctx.writeAndFlush(responseBody).addListener(ChannelFutureListener.CLOSE);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        System.out.println("服务器处理异常！"+cause.getMessage());
        ctx.close();
    }
}
