package springcloud.demo.rpc.proxy;

import springcloud.demo.rpc.proxy.impl.BookApiImpl;

/**
 * @Author: Dely
 * @Date: 2019/11/27 22:44
 */
public class TestMain {
    public static void main(String[] args) throws Exception{
        BookApi delegate = new BookApiImpl();
        /**
         * Jdk动态代理
         */
        BookApi jdkProxy = JdkHandler.createJdkDynamicProxy(delegate);
        jdkProxy.sell();
        /**
         * Cglib动态代理
         */
        BookApi cglibProxy = CglibInterceptor.createCglibDynamicProxy(delegate);
        cglibProxy.sell();

        /**
         * javassist字节码 实现动态代理   //该方法不再是在前后嵌入逻辑，没研究透
         */
        BookApi javassistBytecodeDynamicProxy = JavassistHandler.createJavassistBytecodeDynamicProxy(delegate);
        javassistBytecodeDynamicProxy.sell();

    }
}
