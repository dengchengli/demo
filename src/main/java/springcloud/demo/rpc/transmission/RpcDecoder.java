package springcloud.demo.rpc.transmission;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.ByteToMessageDecoder;
import springcloud.demo.rpc.serializable.KryoSerialization;

import java.util.List;

/**
 * @Author: Dely
 * @Date: 2019/11/28 15:44
 */
public class RpcDecoder extends ByteToMessageDecoder {

    private final Class<?> genericClass;

    public RpcDecoder(Class<?> genericClass) {
        this.genericClass = genericClass;
    }

    /**
     * 解码器
     * @param channelHandlerContext
     * @param byteBuf
     * @param list
     * @throws Exception
     */
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (byteBuf.readableBytes()<4) {
            return;
        }
        /**
         * 将下标重置到开始处
         */
        byteBuf.markReaderIndex();
        int length = byteBuf.readInt();
        if (byteBuf.readableBytes()<length) {
            /**
             * 如果剩下的数据没有报文长度的话，那就是不完整的报文体
             */
            byteBuf.resetReaderIndex();
            return;
        }
        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);
        KryoSerialization kryo = new KryoSerialization();
        Object deserialize = kryo.deserialize(bytes, genericClass);
        list.add(deserialize);
    }

}
