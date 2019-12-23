package springcloud.demo.rpc.transmission;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * @Author: Dely
 * @Date: 2019/11/28 18:10
 */
public class RpcClientRequestHandler extends ChannelOutboundHandlerAdapter {
    @Override
    public void read(ChannelHandlerContext ctx) throws Exception {
        RpcRequestBody requestBody = new RpcRequestBody();
        requestBody.setRequestId(999);
        requestBody.setMethodName("sell");
        ctx.writeAndFlush(requestBody).sync();
        ctx.close();
    }

}
