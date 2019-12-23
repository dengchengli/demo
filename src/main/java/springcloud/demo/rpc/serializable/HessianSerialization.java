package springcloud.demo.rpc.serializable;

/**
 * @Author: Dely
 * @Date: 2019/11/27 18:01
 */

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * hessian序列化方式
 */
public class HessianSerialization implements Serialization {
    @Override
    public byte[] serialize(Object obj) throws IOException {
        /**
         * 创建字节流数组
         */
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        /**
         * 为字节流创建hessian2Output对象
         */
        Hessian2Output output = new Hessian2Output(byteArrayOutputStream);
        /**
         * 序列化
         */
        output.writeObject(obj);
        /**
         * 将数据刷到字节流缓存中
         */
        output.flush();

        return byteArrayOutputStream.toByteArray();

    }

    /**
     * 反序列化
     * @param bytes
     * @param clz
     * @param <T>
     * @return
     * @throws IOException
     */
    @Override
    public <T> T deserialize(byte[] bytes, Class<T> clz) throws IOException{
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        Hessian2Input hessian2Input = new Hessian2Input(byteArrayInputStream);
        return (T) hessian2Input.readObject(clz);
    }
}
