package springcloud.demo.rpc.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: Dely
 * @Date: 2019/11/28 0:24
 */

/**
 * cglib动态代理类
 */
public class CglibInterceptor implements MethodInterceptor {
    final Object delegate;

    public CglibInterceptor(Object delegate) {
        this.delegate = delegate;
    }


    public static <T> T createCglibDynamicProxy(final T delegate) throws Exception{
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new CglibInterceptor(delegate));
        enhancer.setInterfaces(delegate.getClass().getInterfaces());
        T cglibProxy = (T)enhancer.create();
        return cglibProxy;
    }


    /**
     * @param o           //目标方法的返回值
     * @param method      // 目标方法对象
     * @param objects     //目标方法参数
     * @param methodProxy //方法句柄
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib执行代理方法执行前");
        Object res = methodProxy.invoke(delegate, objects);
        System.out.println("cglib代理方法执行后");
        return res;
    }
}
