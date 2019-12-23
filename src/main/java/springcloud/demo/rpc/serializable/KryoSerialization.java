package springcloud.demo.rpc.serializable;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @Author: Dely
 * @Date: 2019/11/27 17:07
 */
public  class KryoSerialization implements Serialization{
    /**
     * 确保线程安全
     */
    private static final ThreadLocal<Kryo> kryos = new ThreadLocal<Kryo>(){
        @Override
        protected Kryo initialValue() {
            Kryo kryo = new Kryo();
            kryo.setReferences(true);
            kryo.setRegistrationRequired(false);
            return kryo;
        }
    };

    @Override
    public byte[] serialize(Object obj) {
        Kryo kryo = kryos.get();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Output output = new Output(byteArrayOutputStream);
        kryo.writeObject(output, obj);
        output.close();
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> clz) {
        Kryo kryo  = kryos.get();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        Input input =  new Input(byteArrayInputStream);
        input.close();
        return kryo.readObject(input,clz);
    }
}
