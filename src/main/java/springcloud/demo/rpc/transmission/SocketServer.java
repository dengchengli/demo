package springcloud.demo.rpc.transmission;

/**
 * @Author: Dely
 * @Date: 2019/11/28 12:04
 */

import springcloud.demo.rpc.proxy.BookApi;
import springcloud.demo.rpc.proxy.impl.BookApiImpl;
import springcloud.demo.rpc.proxy.JdkHandler;
import springcloud.demo.rpc.serializable.KryoSerialization;
import springcloud.demo.rpc.serializable.Serialization;

import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * 服务端
 * 前4个字节封装请求和响应的内容长度，后边为实际内容
 */
public class SocketServer {
    private final static int port = 9000;

    public static void main(String[] args) throws Exception {
        start();
    }

    private static void start() throws Exception {
        ServerSocket serverSocket = new ServerSocket(9000);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 3000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
        CompletionService pool = new ExecutorCompletionService(executor);
        System.out.println("服务器已准备就绪");

        while (true) {
            final Socket socket = serverSocket.accept();
            pool.submit(new Callable() {
                @Override
                public Object call() throws Exception {
                    try {
                        DataInputStream dis = new DataInputStream(socket.getInputStream());
                        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                        int len = dis.readInt();
                        byte[] requestBody = new byte[len];
                        dis.read(requestBody);
                        /**
                         * 反序列化
                         */
                        Serialization kryo = new KryoSerialization();
                        RpcRequestBody rpcRequestBody = kryo.deserialize(requestBody, RpcRequestBody.class);
                        RpcResponseBody rpcResponseBody = new RpcResponseBody();

                        System.out.println("请求已到达：");
                        System.out.println(rpcRequestBody);

                        String interfaceName = rpcRequestBody.getInterfaceName();
                        Class clz = Class.forName(interfaceName);
                        String packet = clz.getPackage().getName().concat(".impl.");
                        System.out.println("包路径：" + packet);

                        /**
                         * 获取实现类
                         */
                        String implClassName = packet.concat(clz.getSimpleName().concat("Impl"));
                        System.out.println("实现类名称："+implClassName);

                        Class implClz  = Class.forName(implClassName);
                        System.out.println("方法名为："+rpcRequestBody.getMethodName());
                        /**
                         * 反射的方式实现
                         */
                        Method method = implClz.getMethod(rpcRequestBody.getMethodName());
                        Object value = method.invoke(implClz.newInstance());

                        /**
                         * jdk动态代理方式实现  还没实现
                         */


                        rpcResponseBody.setRequestId(rpcRequestBody.getRequestId());
                        rpcResponseBody.setValue(value);
                        rpcResponseBody.setRpcProtocolVersion(rpcRequestBody.getRpcProtocolVersion());

                        System.out.println("封装响应信息：");
                        System.out.println(rpcResponseBody);

                        /**
                         * 序列化 响应信息
                         */
                        byte[] responseBody = kryo.serialize(rpcResponseBody);
                        dos.writeInt(responseBody.length);
                        dos.write(responseBody);
                        dos.flush();

                        dis.close();
                        dos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        socket.close();

                    }
                    return null;
                }
            });

        }

    }

   /* private static <T>Object dynamicProcess(final T obj) throws Exception{
        T jdkDynamicProxy = JdkHandler.createJdkDynamicProxy(obj);
        jdkDynamicProxy.
    }*/
}