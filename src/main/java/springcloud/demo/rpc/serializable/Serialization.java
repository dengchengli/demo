package springcloud.demo.rpc.serializable;

import java.io.IOException;

/**
 * @Author: Dely
 * @Date: 2019/11/27 17:04
 */

public interface Serialization {
    byte[] serialize(Object obj) throws IOException;

    <T> T deserialize(byte[] bytes, Class<T> clz) throws IOException;
}
