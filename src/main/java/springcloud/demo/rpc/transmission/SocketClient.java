package springcloud.demo.rpc.transmission;

/**
 * @Author: Dely
 * @Date: 2019/11/28 13:04
 */

import com.esotericsoftware.kryo.Kryo;
import springcloud.demo.rpc.proxy.BookApi;
import springcloud.demo.rpc.serializable.KryoSerialization;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 客户端
 */
public class SocketClient {
    public static void main(String[] args) throws IOException, NoSuchMethodException {
        try {
            Socket socket = new Socket("localhost", 9000);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            RpcRequestBody rpcRequestBody = new RpcRequestBody();
            rpcRequestBody.setRequestId(1111);
            rpcRequestBody.setInterfaceName(BookApi.class.getName());
            rpcRequestBody.setMethodName(BookApi.class.getMethod("sell").getName());
            byte version = 2;
            rpcRequestBody.setRpcProtocolVersion(version);

            KryoSerialization kryo = new KryoSerialization();
            byte[] serialize = kryo.serialize(rpcRequestBody);
            dos.writeInt(serialize.length);
            dos.write(serialize);

            int length = dis.readInt();
            byte[] bytes = new byte[length];
            dis.read(bytes);
            RpcResponseBody responseBody = kryo.deserialize(bytes,RpcResponseBody.class);
            System.out.println(responseBody);
            dis.close();
            dos.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {

        }

    }
}
