package springcloud.demo.protocol.rmi;

/**
 * @Author: Dely
 * @Date: 2019/12/2 17:37
 */

import springcloud.demo.protocol.rmi.UserHandler;
import springcloud.demo.protocol.rmi.impl.UserHandlerImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *通过map来存储对象引用
 */
public class ServerMain {
    public static void main(String[] args) {

            /**
             * 注册对象到注册表里边
             */
            start();
            System.out.println("rmi server is ready......");

    }

    /**
     * 创建注册表并将对象注册到注册表中
     */
    private static void start(){
        try {
            UserHandler  handler  = (UserHandler) UnicastRemoteObject.exportObject(new UserHandlerImpl(),1099);
            Registry  registry = LocateRegistry.createRegistry(1099);
            registry.rebind("user", handler);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


}
