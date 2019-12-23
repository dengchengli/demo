package springcloud.demo.protocol.rmi.impl;

import springcloud.demo.protocol.rmi.UserHandler;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @Author: Dely
 * @Date: 2019/12/2 17:08
 */
public class UserHandlerImpl implements UserHandler{
    @Override
    public String getUserName() throws RemoteException{
        System.out.println("我是服务端的用户实现类！");
        return "you success!";
    }
}
