package springcloud.demo.protocol.rmi;

/**
 * @Author: Dely
 * @Date: 2019/12/2 17:48
 */

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * 客户端通过rmi调用服务器端的服务
 */
public class ClientMain {
    public static void main(String[] args) {
        try {
            //通过注册的对象相关的引用的名字从注册表中获取引用对象。
            UserHandler  handler = (UserHandler) Naming.lookup("user");
            System.out.println(handler.getUserName());
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
