package springcloud.demo.rpc.transmission;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import springcloud.demo.rpc.serializable.KryoSerialization;

/**
 * @Author: Dely
 * @Date: 2019/11/28 15:44
 */

public class RpcEncoder extends MessageToByteEncoder {
    private final Class<?> genericClass;

    public RpcEncoder(Class<?> genericClass) {
        this.genericClass = genericClass;
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
        KryoSerialization kryo = new KryoSerialization();
        byte[] serialize = kryo.serialize(o);
        byteBuf.writeInt(serialize.length);
        byteBuf.writeBytes(serialize);
    }
}
