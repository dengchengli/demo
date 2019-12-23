package springcloud.demo.protocol.rmi;

/**
 * @Author: Dely
 * @Date: 2019/12/2 17:05
 */


import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 远程服务端暴露的服务接口
 */
public interface UserHandler extends Remote {
    String getUserName() throws RemoteException;

}
