package springcloud.demo.rpc.serializable;


import java.io.*;

/**
 * @Author: Dely
 * @Date: 2019/11/27 21:31
 */
public class JdkSerialization implements Serialization{
    /**
     * 序列化
     * @param obj
     * @return
     * @throws IOException
     */
    @Override
    public byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
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
    public <T> T deserialize(byte[] bytes, Class<T> clz) throws IOException {
        ByteArrayInputStream byteInputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteInputStream);
        T res=null;
        try {
            res  = (T) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }
}
