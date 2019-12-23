package springcloud.demo.rpc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: Dely
 * @Date: 2019/11/27 22:46
 */
public class JdkHandler implements InvocationHandler {
    final Object delegate;

    public JdkHandler(Object delegate) {
        this.delegate = delegate;
    }

    /**
     * 通过Proxy类创建代理对象。
     *
     * @param delegate
     * @param <T>
     * @return
     */
    public static <T> T createJdkDynamicProxy(final T delegate) throws Exception{
        Class interfaces[] = delegate.getClass().getInterfaces();
        JdkHandler jdkHandler = new JdkHandler(delegate);
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        T jdkProxy = (T) Proxy.newProxyInstance(systemClassLoader, interfaces, jdkHandler);
        return jdkProxy;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk代理执行目标方法前");
        Object object = method.invoke(delegate, args);
        System.out.println("jdk执行目标方法后");
        return object;
    }
}
