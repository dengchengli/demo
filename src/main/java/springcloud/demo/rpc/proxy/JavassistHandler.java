package springcloud.demo.rpc.proxy;

/**
 * @Author: Dely
 * @Date: 2019/11/28 0:43
 */

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtNewConstructor;
import javassist.CtNewMethod;

/**
 * javaSSits字节码动态代理
 */
public class JavassistHandler {

    public static <T> T createJavassistBytecodeDynamicProxy(final T delegate) throws Exception {
        System.out.println("javassist动态代理前");
        ClassPool mpool = new ClassPool(true);
        CtClass mCtc = mpool.makeClass(BookApi.class.getName() + "javassistProxy");
        mCtc.addInterface(mpool.get(BookApi.class.getName()));
        mCtc.addConstructor(CtNewConstructor.defaultConstructor(mCtc));
        mCtc.addMethod(CtNewMethod.make("public Object sell() {System.out.println(\"我是泼出去的水\");return \"dddd\";}", mCtc));
        Class<?> pc = mCtc.toClass();
        T bytecodeProxy = (T) pc.newInstance();
        Thread.sleep(4000);
        System.out.println("执行javassist动态代理后");
        return bytecodeProxy;
    }
}
